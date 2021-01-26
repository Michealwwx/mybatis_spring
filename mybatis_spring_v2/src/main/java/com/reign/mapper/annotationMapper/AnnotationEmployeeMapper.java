package com.reign.mapper.annotationMapper;

import com.reign.domain.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName AnnotationEmployeeMapper
 * @Description TODO
 * @Author wuwenxiang
 * @Date 2021-01-25 22:28
 * @Version 1.0
 **/
public interface AnnotationEmployeeMapper {
    @Select("select * from employee where id=#{id}")
    public Employee selectEmployeeById(int id);
}
