package com.heima.service;

import com.heima.dao.DBUtil;
import com.heima.mapper.AccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void transfer(int sourceId ,int targetId ,int money){
        SqlSession sqlSession= new DBUtil().getSqlSession();

        AccountMapper accountMapper= sqlSession.getMapper(AccountMapper.class);

        long resultReduce=accountMapper.transferReduce(sourceId,money);
        long resultAdd=accountMapper.transferAdd(targetId,money);
        if(resultReduce==1&& resultAdd == 1){
            System.out.println("转出成功。。。。");
        }


    }



}
