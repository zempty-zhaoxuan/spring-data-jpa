package com.zempty.springbootjpa.controller;

import com.zempty.springbootjpa.entity.ClassRoom;
import com.zempty.springbootjpa.entity.Desk;
import com.zempty.springbootjpa.entity.Student;
import com.zempty.springbootjpa.entity.Teacher;
import com.zempty.springbootjpa.repository.ClassRoomRepository;
import com.zempty.springbootjpa.repository.StudentRepository;
import com.zempty.springbootjpa.repository.TeacherProjection;
import com.zempty.springbootjpa.repository.TeacherRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import java.util.*;

@RestController
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private TeacherRepositoty teacherRepositoty;

    //级联保存的测试
    @PostMapping("/save_student")
    public Student saveStudent() {
        Student student = new Student()
                .setAge(19)
                .setName("zempty");

        Desk desk = new Desk()
                .setDeskNum(10);
//         学生分配座位，如果设置了级联保存，保存学生的时候也会保存座位，如果没设置级联添加课桌会报错
        student.setDesk(desk);
        return studentRepository.save(student);
    }



//    级联更新的测试
    @PutMapping("/update_student/{id}")
    public Student updateStudent(@PathVariable("id") Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        optional.ifPresent(student->{
            student.setName("zempty_zhao");
//            通过学生找到教室，更新教室的数据
            ClassRoom room = student.getClassRoom();
            room.setName("IT 666999");
            studentRepository.save(student);
        });
        return optional.get();
    }

    @DeleteMapping("/delete_student/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        optional.ifPresent(student -> {
            studentRepository.delete(student);
        });
    }

    @DeleteMapping("delete_room/{id}")
    public void deleteClassRoom(@PathVariable("id") Integer id) {
        Optional<ClassRoom> optional= classRoomRepository.findById(id);
        optional.ifPresent(classRoom ->{
            // 先找到所有的学生，把教室置空，然后删除教室
//            Set<Student> students = classRoom.getStudents();
//            students.forEach(student -> student.setClassRoom(null));
            classRoomRepository.delete(classRoom);
        });;
    }


    @PostMapping("/save_room")
    public ClassRoom saveClassRoom() {
        ClassRoom room = new ClassRoom()
                .setName("IT 教室");
        Set<Student> students = new HashSet<>();
        Student stu = new Student().setName("test123");
        students.add(stu);
        //改进代码，学生类维护关系，把教室设置到每一个学生当中
        students.forEach(student -> student.setClassRoom(room));
        room.setStudents(students);
        return classRoomRepository.save(room);
    }


    @PostMapping("/save_teacher")
    public Teacher saveTeacher() {
        Teacher teacher = new Teacher()
                .setName("张老师3")
                .setSubject("java")
                .setAge(30);
        return teacherRepositoty.save(teacher);
    }


    //通过find 关键字进行名字查询
    @GetMapping("/find/{name}")
    public List<Student> findStudentsByName(@PathVariable("name") String name) {
        return studentRepository.findByName(name);
    }

    //根据名字和年龄进行查询
    @GetMapping("/get/{name}/{age}")
    public List<Student> getStudentByNameAndAge(@PathVariable("name") String name,@PathVariable("age") Integer age) {
        return studentRepository.getByNameAndAge(name, age);
    }


    //根据名字进行删除操作
    @DeleteMapping("/delete/{name}")
    //删除的时候一定要添加事务注解
    @Transactional
    public Long deleteStudentByName(@PathVariable("name") String name) {
        return studentRepository.deleteByName(name);
    }

    //统计指定名字学生的数量
    @GetMapping("/count/{name}")
    public Long countStudentByName(@PathVariable("name") String name) {
        return studentRepository.countByName(name);
    }

    @GetMapping("/test1/{name}")
    public List<ClassRoom> getClassRoom1(@PathVariable("name") String name) {
        return classRoomRepository.findClassRoom1(name);
    }

    @GetMapping("/test2/{name}")
    public List<ClassRoom> getClassRoom2(@PathVariable("name") String name) {
        return classRoomRepository.findClassRoom2(name);
    }



    @GetMapping("/sort/{subject}")
    public List<Teacher> getTeachers(@PathVariable("subject") String subject) {
        // 第一种方法实例化出 Sort 类，根据年龄进行升序排列
        Sort sort1 = Sort.by(Sort.Direction.ASC, "age");

        //定义多个字段的排序
        Sort sort2 = Sort.by(Sort.Direction.DESC, "id", "age");

        // 通过实例化 Sort.Order 来排序多个字段
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "age");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "id");
        orders.add(order1);
        orders.add(order2);
        Sort sort3 = Sort.by(orders);
        //可以传不同的 sort1,2,3 去测试效果
        return teacherRepositoty.getTeachers(subject, sort3);
    }


    @GetMapping("page/{subject}")
    public Page<Teacher> getPage(@PathVariable("subject") String subject) {
        // 第一种方法实例化 Pageable
        Pageable pageable1 = PageRequest.of(1, 2);

        //第二种实例化 Pageable
        Sort sort = Sort.by(Sort.Direction.ASC, "age");
        Pageable pageable2 = PageRequest.of(1, 2, sort);

        //第三种实例化 Pageable
        Pageable pageable3 = PageRequest.of(1, 2, Sort.Direction.DESC, "age");


        //可以传入不同的 Pageable,测试效果
        Page page = teacherRepositoty.getPage(subject, pageable3);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        System.out.println(page.getNumberOfElements());
        System.out.println(page.getSize());
        return page;
    }

    @GetMapping("/specification/{subject}")
    public List<Teacher> specification(@PathVariable("subject") String subject) {
        //实例化 Specification 类
        Specification specification = ((root, criteriaQuery, criteriaBuilder) -> {
            // 构建查询条件
            Predicate predicate = criteriaBuilder.equal(root.get("subject"), subject);
            // 使用 and 连接上一个条件
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThan(root.get("age"), 21));
            return predicate;
        });
        //使用查询
        return teacherRepositoty.findAll(specification);
    }

    @GetMapping("/projection")
    public List<TeacherProjection> projection() {
        // 返回指定字段的数据
        List<TeacherProjection> projections = teacherRepositoty.getTeacherNameAndAge();
        projections.forEach(teacherProjection -> {
            System.out.println(teacherProjection.getAge());
            System.out.println(teacherProjection.getName());
            System.out.println(teacherProjection.getTotal());
        });
        return projections;
    }





}
