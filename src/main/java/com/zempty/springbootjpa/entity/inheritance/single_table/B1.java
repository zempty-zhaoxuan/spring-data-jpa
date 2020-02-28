package com.zempty.springbootjpa.entity.inheritance.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("b1")
public class B1 extends Group1{
}
