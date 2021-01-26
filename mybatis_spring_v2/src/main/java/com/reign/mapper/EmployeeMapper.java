package com.reign.mapper;

import com.reign.domain.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName EmployeeMapper
 * @Description TODO
 * @Author wuwenxiang
 * @Date 2021-01-25 20:31
 * @Version 1.0
 **/
public interface EmployeeMapper {

    public Employee selectEmployeeById(int id);

    public Employee selectEmployeeByLastNameAndEmail(@Param("asd") String lastName, @Param("email") String email);

    public void addEmp(Employee employee);

    public void delEmp(int id);

    public void updateEmp(Employee employee);
}
