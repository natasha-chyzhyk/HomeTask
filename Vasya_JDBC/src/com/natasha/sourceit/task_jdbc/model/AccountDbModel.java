package com.natasha.sourceit.task_jdbc.model;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class AccountDbModel extends BaseDbModel{

    private String name;
    private int age;
    private int class_id;
    private final List<SubjectDbModel> subject = new ArrayList<>();

    public AccountDbModel(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Account:{id=%d, name=%s, age=%d, class=%d, subject=%s}", getId(), name, age, class_id, getString(subject));
    }

    private String getString(List<SubjectDbModel> subject) {
        StringBuilder sb = new StringBuilder('(');
        for (int i=0; i<subject.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(subject.get(i));
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

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public List<SubjectDbModel> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectDbModel> subject) {
        this.subject.clear();
        if (subject != null) {
            this.subject.addAll(subject);
        }
    }
}
