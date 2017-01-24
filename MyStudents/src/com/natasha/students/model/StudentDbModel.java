package com.natasha.students.model;

import java.util.Date;

/**
 * Created by Stas on 15.01.2017.
 */
public class StudentDbModel extends BaseDbModel {
    private String name;
    private Date birthday;
    private GroupDbModel group;

    public StudentDbModel(long id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Student:{id=%d, name=%s, birthday=%s, group_id=%d}", getId(), name, birthday, group.getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public GroupDbModel getGroup() {
        return group;
    }

    public void setGroup(GroupDbModel group) {
        this.group = group;
    }
}
