package com.natasha.sourceit.task18;

import javax.print.attribute.IntegerSyntax;
import java.io.Serializable;

/**
 * Created by Stas on 18.12.2016.
 */
public class Staff implements Serializable {
    private String firsstName;
    private String lastName;
    private String nickName;
    private double sallaryValue;
    private boolean isRegular;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirsstName() {
        return firsstName;
    }

    public void setFirsstName(String firsstName) {
        this.firsstName = firsstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getSallaryValue() {
        return sallaryValue;
    }

    public void setSallaryValue(double sallaryValue) {
        this.sallaryValue = sallaryValue;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setIsRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }
}
