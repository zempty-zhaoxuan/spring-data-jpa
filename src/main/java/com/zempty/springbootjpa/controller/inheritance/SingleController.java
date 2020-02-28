package com.zempty.springbootjpa.controller.inheritance;


import com.zempty.springbootjpa.entity.inheritance.single_table.A1;
import com.zempty.springbootjpa.entity.inheritance.single_table.B1;
import com.zempty.springbootjpa.repository.single_table.A1Respository;
import com.zempty.springbootjpa.repository.single_table.B1Respository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SingleController {

    @Autowired
    private A1Respository a1Respository;

    @Autowired
    private B1Respository b1Respository;

    @PostMapping("/a")
    public A1 saveA1(@RequestBody A1 a1) {
        A1 a = a1Respository.save(a1);
        return a;
    }

    @PostMapping("/b")
    public B1 saveB1(@RequestBody B1 b1) {
        B1 b = b1Respository.save(b1);
        return b;
    }


    @GetMapping("/all_B1")
    public List<B1> getB1() {
        return b1Respository.findAll();
    }

    @GetMapping("/all_A1")
    public List<A1> getA1() {
        return a1Respository.findAll();
    }

}
