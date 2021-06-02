package com.zempty.springbootjpa.entity.inheritance.per_table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class A3 extends Group3 {


    private String job;

    private String duty;

}
