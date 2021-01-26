package com.reign.mapper;

import com.reign.domain.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 多参数采用命名参数
     * @param lastName
     * @param email
     * @return
     */
    public Employee selectEmployeeByLastNameAndEmail(@Param("asd") String lastName, @Param("email") String email);

    /**
     * 多参数，采用map
     * @param map
     * @return
     */
    public Employee selectEmployeeByMap(Map<String,Object> map);

    public Employee selectByCollection(Collection<Integer> ids);

    public void addEmp(Employee employee);

    public void delEmp(int id);

    public void updateEmp(Employee employee);

    public List<Employee> selectByLastName(String lastName);

    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    @MapKey("id")
    public Map<Integer,Employee> getEmpsReturnMap(String lastName);
}
