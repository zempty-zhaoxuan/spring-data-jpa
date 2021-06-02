package com.zempty.springbootjpa.entity.inheritance.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@Entity
@DiscriminatorValue("b1")
public class B1 extends Group1{
}
