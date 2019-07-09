package com.codeup.springblog.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "people")
public class Person {
    @Id
    @GeneratedValue
    private int id;

}
