package com.heima.service;

/**
 * @author chengjinging
 * @date 2020/8/22 下午12:21
 */
public class Demo1 {


    public static void main(String[] args) {
        int [] arr=new int[]{};

        try {
            System.out.println(arr[0]);
        }catch (Exception e){
            e.printStackTrace();
//            throw new RuntimeException();  如果注掉 末尾代码会执行 如果不注掉 向上抛异常末尾代码没机会执行
        }finally {
            System.out.println("finally.....");
        }


        System.out.println("末尾代码");
    }
}
