package com.heima.service;

import org.springframework.stereotype.Component;

/**
 * @author chengjinging
 * @date 2020/8/21 下午11:19
 */
@Component
public class AccountService {
    public void saveAccount() {
        System.out.println("存钱服务进行中....");
//        int [] arr= new int []{} ;
//        System.out.println(arr[0]);
    }
    public void updateAccount(int money) {
        System.out.println("更新账户...."+money);
    }
    public int deleteAccount(int money) {
        System.out.println("删除账户....");
        return 100;
    }
}
