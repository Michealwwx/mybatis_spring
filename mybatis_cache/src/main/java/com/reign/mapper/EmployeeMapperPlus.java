package com.reign.mapper;

import com.reign.domain.Employee;

import java.util.Map;

/**
 * @ClassName EmployeeMapper
 * @Description TODO
 * @Author wuwenxiang
 * @Date 2021-01-25 20:31
 * @Version 1.0
 **/
public interface EmployeeMapperPlus {

    Map<Integer,Employee> selectEmployeeById(Integer id);

    public Employee getEmpAndDeptById(Integer id);
}
