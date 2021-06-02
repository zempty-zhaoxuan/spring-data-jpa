package com.zempty.springbootjpa.entity.inheritance.per_table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;


@Entity
@Setter
@Getter
@Accessors(chain = true)
public class B3 extends Group3 {


    private String brith;

    private String date;

}
