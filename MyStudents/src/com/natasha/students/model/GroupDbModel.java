package com.natasha.students.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 15.01.2017.
 */
public class GroupDbModel extends BaseDbModel {

    private String title;
    private int startYear;
    private List<StudyDbModel> studies;
    private List<StudentDbModel> students;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("id="+getId());
        sb.append(", title="+title);
        sb.append(", startYear="+startYear);
        sb.append(", studies=[");

        for (int i=0; i<studies.size(); i++) {
            if (i>0) sb.append(", ");
            sb.append(studies.get(i).toString());
        }

        sb.append(']');

        sb.append(", students=[");

        for (int i=0; i<students.size(); i++) {
            if (i>0) sb.append(", ");
            sb.append(students.get(i).toString());
        }

        sb.append(']');

        sb.append('}');
        return sb.toString();
    }

    public GroupDbModel(long id) {
        super(id);
        studies = new ArrayList<>();
        students = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public List<StudyDbModel> getStudies() {
        return studies;
    }

    public void setStudies(List<StudyDbModel> studies) {
        this.studies.clear();
        if (studies != null) {
            this.studies.addAll(studies);
        }
    }

    public List<StudentDbModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDbModel> students) {
        this.students.clear();
        if (students != null) {
            this.students.addAll(students);
        }
    }
}
