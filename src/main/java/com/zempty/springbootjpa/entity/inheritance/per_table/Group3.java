package com.zempty.springbootjpa.entity.inheritance.per_table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Setter
@Getter
@Accessors(chain = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Group3 {

    @Id
    // 使用 AUTO 通常会有一个多余的表 hibernate_sequence 生成
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String value;

}
