package com.heima.ui;

import com.heima.service.AccountService;
import com.heima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chengjinging
 * @date 2020/8/21 下午10:32
 */
public class UiDemo {


    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        AccountService aservice = (AccountService) ac.getBean("accountService");
        aservice.saveAccount();




    }





}
