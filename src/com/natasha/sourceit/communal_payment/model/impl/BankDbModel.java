package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.PaymentHelper;
import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;
import com.natasha.sourceit.communal_payment.model.StreetAddress;
import com.natasha.sourceit.communal_payment.model.User;

/**
 * Created by Stas on 29.01.2017.
 */
public class BankDbModel extends SingleIdDbModel implements PaymentHelper, User, StreetAddress {

    private String title;
    private StreetAddress address;
    private CredentialsDbModel creds;


    public final static Builder builder(long id) {
        return new Builder(id);
    }

    public static class Builder {
        private BankDbModel model;

        private Builder(long id) {
            model = new BankDbModel(id);
        }
        public Builder setTitle(String title) {
            model.title = title;
            return this;
        }
        public Builder setAddress(StreetAddress address) {
            model.address = address;
            return this;
        }
        public Builder setCredentials(CredentialsDbModel creds) {
            model.creds = creds;
            return this;
        }
        public BankDbModel build() {
            return model;
        }
    }

    private BankDbModel(long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getCity() {
        return address.getCity();
    }

    @Override
    public String getStreet() {
        return address.getStreet();
    }

    @Override
    public int getHouse() {
        return address.getHouse();
    }

    @Override
    public String getLogin() {
        return creds.getLogin();
    }

    @Override
    public boolean checkPassword(String password) {
        return creds.getPassword().equals(password);
    }
}
