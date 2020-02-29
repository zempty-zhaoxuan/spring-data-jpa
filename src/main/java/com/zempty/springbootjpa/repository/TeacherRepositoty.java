package com.zempty.springbootjpa.repository;

import com.zempty.springbootjpa.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepositoty extends JpaRepository<Teacher,Integer> {

    // 正常使用，只是多加了一个 Sort 参数而已
    @Query("select t from Teacher t where t.subject = ?1")
    List<Teacher> getTeachers(String subject, Sort sort);


    //正常使用，只是多加了一个 Pageable 参数而已
    @Query("select t from Teacher t where t.subject = :subject")
    Page<Teacher> getPage(@Param("subject") String subject, Pageable pageable);
}
