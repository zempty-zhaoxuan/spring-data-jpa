//package com.zempty.springbootjpa.controller;
//
//
////import com.zempty.springbootjpa.entity.inheritance.per_table.A3;
////import com.zempty.springbootjpa.entity.inheritance.per_table.B3;
//import com.zempty.springbootjpa.repository.per_table.A3Repository;
//import com.zempty.springbootjpa.repository.per_table.B3Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class PerController {
//
//
//    @Autowired
//    private A3Repository a3Respository;
//
//    @Autowired
//    private B3Repository b3Respository;
//
//    @PostMapping("/a3")
//    public A3 saveA1(@RequestBody A3 a3) {
//        A3 a = a3Respository.save(a3);
//        return a;
//    }
//
//    @PostMapping("/b3")
//    public B3 saveB1(@RequestBody B3 b1) {
//        B3 b = b3Respository.save(b1);
//        return b;
//    }
//
//
//    @GetMapping("/all_B3")
//    public List<B3> getB1() {
//        return b3Respository.findAll();
//    }
//
//    @GetMapping("/all_A3")
//    public List<A3> getA1() {
//        return a3Respository.findAll();
//    }
//}
