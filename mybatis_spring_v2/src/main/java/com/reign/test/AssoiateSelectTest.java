package com.reign.test;

import com.reign.config.SqlSessionFactoryConfig;
import com.reign.domain.Employee;
import com.reign.mapper.EmployeeMapperPlus;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Map;

/**
 * @ClassName: AssoiateSelectTest
 * @Description: 关联查询测试
 * @Author: wuwx
 * @Date: 2021-01-26 16:29
 **/
public class AssoiateSelectTest {

    @Test
    public void selectById() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperPlus employeeMapper = sqlSession.getMapper(EmployeeMapperPlus.class);
        Map<Integer, Employee> employeeMap = employeeMapper.selectEmployeeById(1);

        sqlSession.close();
    }
}
