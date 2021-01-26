package com.reign.test;

import com.reign.config.SqlSessionFactoryConfig;
import com.reign.domain.Employee;
import com.reign.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @ClassName: CacheTest
 * @Description: TODO
 * @Author: wuwx
 * @Date: 2021-01-26 17:31
 **/
public class CacheTest {

    @Test
    public void testFirstLevelCache() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employee = sqlSession.getMapper(EmployeeMapper.class);
        Employee e1 = employee.selectEmployeeById(1);
        Employee e2 = employee.selectEmployeeById(1);
        System.out.println("两次结果是否相同："+(e1==e2));
        System.out.println(employee.selectEmployeeById(1));
        sqlSession.close();
    }


    @Test
    public void testSecondLevelCache() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();


        EmployeeMapper employee1 = sqlSession1.getMapper(EmployeeMapper.class);
        EmployeeMapper employee2= sqlSession2.getMapper(EmployeeMapper.class);



        Employee e1 = employee1.selectEmployeeById(1);
        System.out.println("第一次查询："+e1);
        sqlSession1.close();
        //TODO 第一个会话关闭后，会将查询返回的结果放入二级缓存，供后续其他session使用

        Employee e2 = employee2.selectEmployeeById(1);
        System.out.println("第二次查询："+e1);
        System.out.println("两次结果是否相同："+(e1==e2));

        sqlSession2.close();
    }
}
