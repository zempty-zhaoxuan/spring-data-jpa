package com.zempty.springbootjpa.repository;

import com.zempty.springbootjpa.entity.Student;
import com.zempty.springbootjpa.entity.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepositoty extends JpaRepository<Teacher,Integer> {

    // 正常使用，只是多加了一个 sort 参数而已
    @Query("select t from Teacher t where t.subject = ?1")
    List<Teacher> getTeachers(String subject, Sort sort);
}
