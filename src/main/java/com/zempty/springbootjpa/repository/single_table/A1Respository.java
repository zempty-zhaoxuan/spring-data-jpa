package com.zempty.springbootjpa.repository.single_table;

import com.zempty.springbootjpa.entity.inheritance.single_table.A1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface A1Respository extends JpaRepository<A1,Integer> {
}
