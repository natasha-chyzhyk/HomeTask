package com.natasha.sourceit.task_jdbc.model;

import com.natasha.sourceit.task_jdbc.model.BaseDbModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class ClassDbModel extends BaseDbModel {

    private String number;
    private int room_id;
    private final List<AccountDbModel> account = new ArrayList<>();

    public ClassDbModel(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Class:{id=%d, number=%s, room_id=%d, account=%s}", getId(), number, room_id, getString(account));
    }

    private String getString(List<AccountDbModel> account) {
        StringBuilder sb = new StringBuilder('(');
        for (int i=0; i<account.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(account.get(i));
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

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public List<AccountDbModel> getAccount() {
        return account;
    }

    public void setAccount(List<AccountDbModel> account) {
        this.account.clear();
        if (account != null) {
            this.account.addAll(account);
        }
    }
}
