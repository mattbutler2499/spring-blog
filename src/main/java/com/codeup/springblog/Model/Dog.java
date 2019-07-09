package com.codeup.springblog.Model;

import javax.persistence.*;

@Entity
@Table (name = "dogs")
public class Dog {
    @Id
    @GeneratedValue
    private int id;

    @Column
    (nullable = false, length = 300)
    private int age;

    @Column (nullable = false, length = 300)
    private String name;

    @Column (nullable = false, length = 300)
    private String resideState;


    public Dog(int age, String name, String resideState) {
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}



// id, age, name, resideState