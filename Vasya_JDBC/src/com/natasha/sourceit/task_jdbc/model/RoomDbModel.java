package com.natasha.sourceit.task_jdbc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class RoomDbModel extends BaseDbModel {

    private String number;
    private int floor;
    private int amount;
    private int school_id;
    private final List<ClassDbModel> classDbModels = new ArrayList<>();
    private final List<SubjectDbModel> subject = new ArrayList<>();

    public RoomDbModel(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Room:{id=%d, number=%s, floor=%d, amount=%d, school=%d, class=%s, subject=%s}", getId(), number, floor, amount, school_id, getStringClass(classDbModels), getStringSubject(subject));
    }

    private String getStringClass(List<ClassDbModel> classDbModels) {
        StringBuilder sb = new StringBuilder('(');
        for (int i=0; i<classDbModels.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(classDbModels.get(i));
        }
        sb.append(")");
        return sb.toString();
    }

    private String getStringSubject(List<SubjectDbModel> subject) {
        StringBuilder sb = new StringBuilder('(');
        for (int i=0; i<subject.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(subject.get(i));
        }
        sb.append(")");
        return sb.toString();
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public List<ClassDbModel> getClassDbModels() {
        return classDbModels;
    }

    public void setClassDbModels(List<ClassDbModel> classDbModels) {
        this.classDbModels.clear();
        if (classDbModels != null) {
            this.classDbModels.addAll(classDbModels);
        }
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
