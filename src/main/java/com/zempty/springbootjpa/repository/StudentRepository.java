package com.zempty.springbootjpa.repository;

import com.zempty.springbootjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {


    // 查询数据库中指定名字的学生
    List<Student> findByName(String name);

    // 根据名字和年龄查询学生
    List<Student> getByNameAndAge(String name, Integer age);

    //删除指定名字的学生
    Long deleteByName(String name);

    // 统计指定名字学生的数量
    Long countByName(String name);

}
