package com.reign.test;

import com.reign.config.SqlSessionFactoryConfig;
import com.reign.domain.Employee;
import com.reign.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SelectTest
 * @Description: TODO
 * @Author: wuwx
 * @Date: 2021-01-26 14:44
 **/
public class SelectTest {

    @Test
    public void selectByLastName() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.selectByLastName("lao%");
    }


    /**
     * 返回一条数据的map，key就是列名，value就是对应的值
     */
    @Test
    public void getEmpByIdReturnMap() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map<String,Object> map = employeeMapper.getEmpByIdReturnMap(1);
        System.out.println(map);
    }

    /**
     * 返回多条数据的map，key为主键，value是employee
     */
    @Test
    public void getEmpsReturnMap() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map<Integer,Employee> map = employeeMapper.getEmpsReturnMap("lao%");
        System.out.println(map);
    }


    /**
     * 自定义结果映射
     */
    @Test
    public void get() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map<Integer,Employee> map = employeeMapper.getEmpsReturnMap("lao%");
        System.out.println(map);
    }

}
