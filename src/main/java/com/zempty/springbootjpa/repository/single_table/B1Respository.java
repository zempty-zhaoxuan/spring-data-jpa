package com.zempty.springbootjpa.repository.single_table;

import com.zempty.springbootjpa.entity.inheritance.single_table.B1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface B1Respository extends JpaRepository<B1,Integer> {
}
