package com.zempty.springbootjpa.entity.inheritance.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("a1")
public class A1 extends Group1 {

    private String test;
}
