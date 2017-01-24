package com.natasha.abstractdao.model;

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
