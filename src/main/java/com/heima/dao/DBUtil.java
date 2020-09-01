package com.heima.dao;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author chengjinging
 * @date 2020/8/22 下午7:16
 */
public class DBUtil {
    public static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    private SqlSession sqlSession;
    public  SqlSession getSqlSession(){
        InputStream inputStream =
                ResolverUtil.Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new
                SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =
                sqlSessionFactoryBuilder.build(inputStream);

        this.sqlSession = sqlSessionFactory.openSession();
        threadLocal.set(sqlSession);
        System.out.println("sqlSession added threadLocal  ==="+ this.sqlSession);
        return this.sqlSession;
    }

}
