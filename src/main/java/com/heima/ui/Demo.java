package com.heima.ui;

import com.heima.dao.AccountDao;
import com.heima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chengjinging
 * @date 2020/8/22 下午12:31
 */
public class Demo {
    private static IAccountService accountService;



    public static void main(String[] args) {
        accountService.saveAccount();
    }
}
