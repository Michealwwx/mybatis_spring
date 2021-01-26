package com.reign.mapper;

import com.reign.domain.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName EmployeeMapper
 * @Description TODO
 * @Author wuwenxiang
 * @Date 2021-01-25 20:31
 * @Version 1.0
 **/
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee selectEmployeeById(int id);
}
