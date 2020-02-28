package com.zempty.springbootjpa.entity.inheritance.joined;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Setter
@Getter
@Accessors(chain = true)
@Entity
@PrimaryKeyJoinColumn(name="b2_id")
public class B2 extends Group2 {

    private String job;

    private String date;
}
