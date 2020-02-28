package com.zempty.springbootjpa.repository;

import com.zempty.springbootjpa.entity.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRoom,Integer> {

    //使用的 JPQL 的 sql 形式 from 后面是类名
    // ?1 代表是的是方法中的第一个参数
    @Query("select s from ClassRoom s where s.name =?1")
    List<ClassRoom> findClassRoom1(String name);

    //这是使用正常的 sql 语句去查询
    // :name 是通过 @Param 注解去确定的
    @Query(nativeQuery = true,value = "select * from class_room c where c.name =:name")
    List<ClassRoom> findClassRoom2(@Param("name")String name);


}
