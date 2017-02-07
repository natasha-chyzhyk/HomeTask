package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;
import com.natasha.sourceit.communal_payment.model.StreetAddress;
import com.natasha.sourceit.communal_payment.model.User;


public class SupplyerDbModel extends SingleIdDbModel implements User, StreetAddress {


    private String title;
    private StreetAddress streetAddress;
    private CredentialsDbModel credentials;

    public static Builder builder(long id) {
        return new Builder(id);
    }

    public static class Builder {
        private SupplyerDbModel supl;
        public Builder(long id) {
            supl = new SupplyerDbModel(id);
        }
        public Builder setTitle(String title) {
            supl.title = title;
            return this;
        }
        public Builder setStreetAddress(StreetAddress streetAddress) {
            supl.streetAddress = streetAddress;
            return this;
        }
        public Builder setCredentials(CredentialsDbModel credentials) {
            supl.credentials = credentials;
            return this;
        }
        public SupplyerDbModel build() {
            return supl;
        }
    }

    private SupplyerDbModel(long id) {
        super(id);
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String getCity() {
        return streetAddress.getCity();
    }

    @Override
    public String getStreet() {
        return streetAddress.getStreet();
    }

    @Override
    public int getHouse() {
        return streetAddress.getHouse();
    }

    @Override
    public String getLogin() {
        return credentials.getLogin();
    }

    @Override
    public boolean checkPassword(String password) {
        return credentials.getPassword().equals(password);
    }
}
