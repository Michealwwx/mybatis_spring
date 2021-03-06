package com.reign.test;

import com.reign.config.SqlSessionFactoryConfig;
import com.reign.domain.Employee;
import com.reign.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EmployeeTest
 * @Description TODO
 * @Author wuwenxiang
 * @Date 2021-01-25 20:40
 * @Version 1.0
 **/
public class EmployeeTest {

    @Test
    public void test1() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Employee employee = sqlSession.selectOne("selectEmployeeById", 1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employee = sqlSession.getMapper(EmployeeMapper.class);
        System.out.println(employee.selectEmployeeById(1));
        sqlSession.close();
    }


    @Test
    public void testSelectByMultiParam() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employee = sqlSession.getMapper(EmployeeMapper.class);
        System.out.println(employee.selectEmployeeByLastNameAndEmail("\"laoda\"","3323@qq.com"));
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiParamMap() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employee = sqlSession.getMapper(EmployeeMapper.class);
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("lastName","laoda");
        paramMap.put("email","3323@qq.com");
        System.out.println(employee.selectEmployeeByMap(paramMap));
        sqlSession.close();
    }


    /**
     * 测试传入Collection参数
     */
    @Test
    public void testSelectByCollection() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employee = sqlSession.getMapper(EmployeeMapper.class);
        Collection<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        System.out.println(employee.selectByCollection(ids));
        sqlSession.close();
    }


    @Test
    public void testAdd() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        //TODO 如果使用openSession(),表示不自动提交，插入的时候没有数据，需要采用自动提交的openSession（true）
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee1 =new Employee();
        employee1.setEmail("add@email");
        employee1.setGender(1);
        employee1.setLastName("测试插入");
        employeeMapper.addEmp(employee1);
        System.out.println(employee1.getId());
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.selectEmployeeById(1);
        employee.setLastName("测试单参数随便写的更新");
        employee.setEmail("更新后的email");
        employeeMapper.updateEmp(employee);
        sqlSession.close();
    }

    @Test
    public void testDel() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper employee = sqlSession.getMapper(EmployeeMapper.class);
        employee.delEmp(2);
        sqlSession.close();
    }




}
