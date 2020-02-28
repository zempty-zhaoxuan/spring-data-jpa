package com.zempty.springbootjpa.repository;

import com.zempty.springbootjpa.entity.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk,Integer> {
}
