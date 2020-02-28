package com.zempty.springbootjpa.entity.inheritance.joined;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Setter
@Getter
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Group2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String value;


}
