package com.zempty.springbootjpa.entity.inheritance.single_table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Setter
@Getter
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public abstract class Group1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String value;
}
