package com.reign.mapper;

import com.reign.domain.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmployeeMapper
 * @Description TODO
 * @Author wuwenxiang
 * @Date 2021-01-25 20:31
 * @Version 1.0
 **/
public interface EmployeeMapper {

    public Employee selectEmployeeById(int id);

}
