package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;

/**
 * Created by Stas on 28.01.2017.
 */
public class CredentialsDbModel extends SingleIdDbModel {

    private String login, password;

    public CredentialsDbModel(long id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
