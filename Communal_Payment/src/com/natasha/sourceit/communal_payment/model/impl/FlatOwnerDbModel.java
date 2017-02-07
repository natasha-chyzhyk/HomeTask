package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.User;

/**
 * Created by Stas on 29.01.2017.
 */
public class FlatOwnerDbModel extends HumanDbModel implements User {

    private CredentialsDbModel creds;
    private long ownFlatId;

    public static Builder builder(long id) {
        return new Builder(id);
    }

    public static class Builder extends HumanDbModel.Builder {

        protected FlatOwnerDbModel ownerModel;

        protected Builder(long id) {
            super(id);
            //Override parent model to use parent setters;
            super.model = ownerModel = new FlatOwnerDbModel(id);
        }

        public Builder setOwnFlatId(long ownFlatId) {
            ownerModel.ownFlatId = ownFlatId;
            return this;
        }

        public Builder setCredentials(CredentialsDbModel creds) {
            ownerModel.creds = creds;
            return this;
        }

        public FlatOwnerDbModel build() {
            return ownerModel;
        }
    }


    private FlatOwnerDbModel(long id) {
        super(id);
    }

    public long getOwnFlatId() {
        return ownFlatId;
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
