package com.heima.service;

import com.heima.dao.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author chengjinging
 * @date 2020/8/22 下午7:26
 */
@Component
@Aspect
public class SqlSessionManageAspect {
    @Pointcut("execution( * com.heima.service.AccountService.transfer(..))")
    public void poinCut(){

    }

    
//    @After("poinCut()")
//    public void commitAndClose(){
//        System.out.println("commitAndClose().....");
//        SqlSession sqlSession= DBUtil.threadLocal.get();
//        System.out.println("sqlSession from SqlSessionManage.commitAndClose()===" + sqlSession);
//        sqlSession.commit();
//        sqlSession.close();
//        System.out.println("sqlSession.commit()&&sqlSession.close() finish from SqlSessionManage.commitAndClose()");
//    }
//
//    @AfterThrowing("poinCut()")
//    public void rollBack(){
//        System.out.println("rollBack().....");
//        SqlSession sqlSession= DBUtil.threadLocal.get();
//        System.out.println("sqlSession from SqlSessionManage.rollBack()===" + sqlSession);
//        sqlSession.rollback();
//
//        sqlSession.close();
//        System.out.println("sqlSession.rollback() &&sqlSession.close() finish from SqlSessionManage.commitAndClose()");
//
//    }

    @Around("poinCut()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint){
        Object [] args=proceedingJoinPoint.getArgs();
        Object obj=null;
        try {

            obj=proceedingJoinPoint.proceed(args);

            return obj;


        } catch (Throwable e) {
            DBUtil.threadLocal.get().rollback();
            System.out.println("回滚.....");
            throw new RuntimeException(e);
        } finally {
            DBUtil.threadLocal.get().commit();
            DBUtil.threadLocal.get().close();
            System.out.println("提交&关闭.....");
        }



    }


    
    
}
