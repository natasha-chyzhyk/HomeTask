package com.natasha.sourceit.task_jdbc1.model;


import java.util.List;

/**
 * Created by Stas on 21.01.2017.
 */
public class AccountDbModel extends BaseDbModel {

    private String name;
    private int age;
    private ClassDbModel classes;
    private List<SubjectDbModel> sudject;

    public AccountDbModel(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Account:{id=%d, name=%s, classes=%s, sudject=%s}", getId(), name, classes, getString(sudject));
    }

    private String getString(List<SubjectDbModel> sudject) {
        StringBuilder sb = new StringBuilder('(');
        for (int i=0; i<sudject.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(sudject.get(i));
        }
        sb.append(")");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClassDbModel getClasses() {
        return classes;
    }

    public void setClasses(ClassDbModel classes) {
        this.classes = classes;
    }

    public List<SubjectDbModel> getSudject() {
        return sudject;
    }

    public void setSudject(List<SubjectDbModel> sudject) {
        this.sudject = sudject;
    }
}