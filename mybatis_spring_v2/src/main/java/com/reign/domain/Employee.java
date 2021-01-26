package com.reign.domain;

import com.reign.domain.other.Dept;

/**
 * @ClassName Employee
 * @Description TODO
 *
 * 字段如果名字不一样，可以手动在mapper.xml中使用别名  或者在配置文件setting中开启驼峰命名
 *   select id,last_name lastName,gender,email from Employee where id = #{id}
 *
 * @Author wuwenxiang
 * @Date 2021-01-25 20:25
 * @Version 1.0
 **/
public class Employee {
    private int id;
    private String lastName;
    private int gender;
    private String email;
    private Dept dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    //FIXME  构造方法和toString中属性的顺序一定要和数据表字段名字一致，否则解析映射会出错
//    public Employee(int id, String lastName, String email, int gender) {
//        this.id = id;
//        this.lastName = lastName;
//        this.email = email;
//        this.gender = gender;
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
