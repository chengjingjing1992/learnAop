package com.heima.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author chengjinging
 * @date 2020/8/21 下午11:35
 */
@Component
@Aspect // 切面类
public class Logger {
    @Pointcut("execution( * com.heima.service.*.*(..))")
    public void pt1(){

    }
//    @Before("pt1()")
    public void writeLog(){
        System.out.println("日志记录.....");
    }
    @After("pt1()")
    public void tailLog(){
        System.out.println("最终日志......");
    }
    @AfterReturning("pt1()")
    public void returnAfter(){
        System.out.println("后置通知.....");

    }
    @AfterThrowing("pt1()")
    public void throwLog(){
        System.out.println("异常日志.....");

    }
    @Around("pt1()")
    public Object arountLog(ProceedingJoinPoint pjp) throws Throwable {


        Object [] args=pjp.getArgs();
        Object obj=null;
        try {
            System.out.println("arountLog.....前置通知");

            obj=pjp.proceed(args);
            System.out.println("arountLog.....后置通知");
            return obj;

        } catch (Throwable throwable) {
            System.out.println("arountLog.....异常通知");

            throw new RuntimeException();

        }finally {
            System.out.println("arountLog.....最终通知");

        }



    }



}
