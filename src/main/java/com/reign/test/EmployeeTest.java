package com.reign.test;

import com.reign.config.SqlSessionFactoryConfig;
import com.reign.domain.Employee;
import com.reign.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @ClassName EmployeeTest
 * @Description TODO
 * @Author wuwenxiang
 * @Date 2021-01-25 20:40
 * @Version 1.0
 **/
public class EmployeeTest {

    @Test
    public void test1(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee = sqlSession.selectOne("selectEmployeeById",1);
        System.out.println(employee);
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employee = sqlSession.getMapper(EmployeeMapper.class);
        System.out.println(employee.selectEmployeeById(1));
        sqlSession.close();
    }

}
