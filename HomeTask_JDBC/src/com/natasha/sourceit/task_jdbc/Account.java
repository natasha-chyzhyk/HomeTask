package com.natasha.sourceit.task_jdbc;



/**
 * Created by Stas on 14.01.2017.
 */
public class Account {
    private int id;
    private char name;
    private int age;
    private int class_id;

    public int getId() {
        return id;
    }

    public char getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}
