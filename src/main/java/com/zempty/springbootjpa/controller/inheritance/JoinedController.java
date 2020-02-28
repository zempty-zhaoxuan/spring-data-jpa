package com.zempty.springbootjpa.controller.inheritance;

import com.zempty.springbootjpa.entity.inheritance.joined.A2;
import com.zempty.springbootjpa.entity.inheritance.joined.B2;
import com.zempty.springbootjpa.repository.joined.A2Repository;
import com.zempty.springbootjpa.repository.joined.B2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoinedController {

    @Autowired
    private A2Repository a2Repository;

    @Autowired
    private B2Repository b2Repository;

    @PostMapping("/a2")
    public A2 saveA2(@RequestBody A2 a2) {
        return a2Repository.save(a2);
    }

    @PostMapping("/b2")
    public B2 saveA2(@RequestBody B2 b2) {
        return b2Repository.save(b2);
    }

    @GetMapping("/a2s")
    public List<A2> getA2s() {
        return a2Repository.findAll();
    }

    @GetMapping("/b2s")
    public List<B2> getB2s() {
        return b2Repository.findAll();
    }
}
