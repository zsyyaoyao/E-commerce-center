package com.zsy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zsy.entity.Member;
import com.zsy.entity.Result;
import com.zsy.handler.CustomGlobalBlockHandler;
import com.zsy.handler.CustomGlobalFallbackHandler;
import com.zsy.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class MemberController {
    @Resource
    private MemberService memberService;

    private static int num = 0; //执行的计数器


    /**
     * value = "t6" 表示 sentinel限流资源的名字
     * blockHandlerClass = CustomGlobalBlockHandler.class : 全局限流处理类
     * blockHandler = "handlerMethod1": 指定使用全局限流处理类哪个方法，来处理限流信息
     * fallbackClass = CustomGlobalFallbackHandler.class: 全局fallback处理类
     * fallback = "fallbackHandlerMethod1": 指定使用全局fallback处理类哪个方法来处理java异常/业务异常
     * exceptionsToIgnore = {RuntimeException.class}: 表示如果t6()抛出RuntimeException, 就使用系统默认方式处理
     *
     * @return
     */
    @GetMapping("/t6")
    @SentinelResource(value = "t6",
            fallbackClass = CustomGlobalFallbackHandler.class,
            fallback = "fallbackHandlerMethod1",
            blockHandlerClass = CustomGlobalBlockHandler.class,
            blockHandler = "handlerMethod1",
            exceptionsToIgnore = {NullPointerException.class})
    public Result t6() {

        if (++num % 5 == 0) {
            throw new NullPointerException("null指针异常 num=" + num);
        }
        if (num % 6 == 0) {
            throw new RuntimeException("RuntimeException异常 num=" + num);
        }

        log.info("执行t6() 线程id={}", Thread.currentThread().getId());
        return Result.success("200", "t6() 执行成功ok");
    }


    //完成对热点key限流的测试

    /**
     * 老师解读
     * 1.@SentinelResource : 指定sentinel限流资源
     * 2.value = "news" 表示sentinel限流资源 名称,由程序员指定
     * 3. blockHandler = "newsBlockHandler": 当出现限流时，由newsBlockHandler方法进行处理
     */
    @GetMapping("/news")
    @SentinelResource(value = "news", blockHandler = "newsBlockHandler")
    public Result queryNews(@RequestParam(value = "id", required = false) String id,
                            @RequestParam(value = "type", required = false) String type) {
        log.info("到db查询");
        return Result.success("返回news id =" + id);

    }

    //完成对热点key限流/异常处理的方法
    public Result newsBlockHandler(String id, String type, BlockException blockException) {
        return Result.success("查询id=" + id + "新闻 触发热点key限流保护 sorry....");
    }


    @GetMapping("/t1")
    public Result t1() {
        return Result.success("t1()执行...");
    }

    @GetMapping("/t2")
    public Result t2() {
        //try {
        //    TimeUnit.SECONDS.sleep(1);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}
        log.info("执行t2() 线程id={}", Thread.currentThread().getId());
        return Result.success("t2()执行...");
    }

    @GetMapping("/t3")
    public Result t3() {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Result.success("t3执行.....");
    }

    @GetMapping("/t4")
    public Result t4() {
        //设计异常比例达到50%
        if (++num % 2 == 0) {
            System.out.println(3 / 0);
        }
        log.info("熔断降级测试[异常比例] 执行t4() 线程id={}", Thread.currentThread().getId());
        return Result.success("t4执行....");
    }

    @GetMapping("/t5")
    public Result t5() {
        //出现10次异常,需要设置大于6,留出几次做测试和加入簇点链路
        if (++num <= 10) {
            System.out.println(3 / 0);
        }
        log.info("熔断降级测试[异常数] 执行t5() 线程id={}", Thread.currentThread().getId());
        return Result.success("t5执行....");
    }


    @PostMapping(value = "/member/save")
    public Result save(@RequestBody Member member) {
        int result = memberService.save(member);
        log.info("reset= " + result);
        if (result > 0) { //成功
            return Result.success("添加用户成功 member-service-nacos-provider-10004", result);
        } else {
            return Result.error("401", "添加用户失败");
        }
    }

    @GetMapping(value = "/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id) {

        //在sentinel中 /member/get?id=1 和 /member/get?id=2 被统一认为是 member/get 所以只要对/member/get 限流
        //@GetMapping(value = "/member/get", params = "id")
        //public Result getMemberById(Long id) {

        //模拟超时,休眠1s
        //try {
        //    TimeUnit.SECONDS.sleep(1);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}

        Member member = memberService.queryMemberById(id);
        log.info("查询结果= " + member);
        if (member != null) {
            return Result.success("查询成功,member-service-nacos-provider-10004", member);
        } else {
            return Result.error("402", "ID= " + id + " 不存在");
        }
    }
}