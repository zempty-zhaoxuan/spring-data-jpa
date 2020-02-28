package com.zempty.springbootjpa.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
@Accessors(chain = true)
@Entity(name = "stu")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String name;

    // 设置级联保存，保存学生的时候也会保存课桌
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinTable( name = "stu_desk",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="desk_id") )
    private Desk desk;

    //设置级联更新，在跟新 student 的时候如果更新 classroom , 会级联更新 classroom
    @ManyToOne(cascade = CascadeType.MERGE)
    private ClassRoom classRoom;

    //设置级联删除操作，这是多对对的级联删除，
    // 删除学生的同时会删除关联的老师，如果老师还有关联其他的学生，就会报错，除非老师类也要级联删除，这个删除是要慎重的
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name="stu_teacher",joinColumns = @JoinColumn(name = "stu_id"),inverseJoinColumns = @JoinColumn(name="teacher_id"))
    private Set<Teacher> teachers;

    @Transient
    private String test;

    private int age;

    private LocalTime onDuty;

    private LocalDate onPosition;

    private LocalDateTime birthdayTime;
}
