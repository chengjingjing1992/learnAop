package com.heima.ui;

import com.heima.dao.DBUtil;
import com.heima.entity.Account;
import com.heima.mapper.AccountMapper;
import com.heima.service.AccountService;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

/**
 * @author chengjinging
 * @date 2020/8/22 下午5:40
 */
public class UiDemo2 {

    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService=(AccountService) ac.getBean("accountService");
        accountService.transfer(1,7,2000);



    }


}
