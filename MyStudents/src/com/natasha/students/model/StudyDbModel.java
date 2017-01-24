package com.natasha.students.model;

/**
 * Created by Stas on 15.01.2017.
 */
public class StudyDbModel extends BaseDbModel {

    private String title;


    @Override
    public String toString() {
        return String.format("Study:{id=%d, title=%s}", getId(), title);
    }

    public StudyDbModel(long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
