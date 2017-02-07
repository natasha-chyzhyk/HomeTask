package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;

/**
 * Created by Stas on 27.01.2017.
 */
public class HumanDbModel extends SingleIdDbModel {

    private String firstName;
    private String lastName;
    private String middleName;
    private long livingFlatId;

    public static Builder builder(long id) {
        return new Builder(id);
    }

    public static class Builder {
        protected HumanDbModel model;

        protected Builder(long id) {
            model = new HumanDbModel(id);
        }
        public Builder setFirstName(String firstName) {
            model.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            model.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            model.middleName = middleName;
            return this;
        }

        public Builder setLivingFlatId(long flatId) {
            model.livingFlatId = flatId;
            return this;
        }

        public HumanDbModel build() {
            return model;
        }
    }

    public HumanDbModel(long id) {
        super(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public long getLivingFlatId() {
        return livingFlatId;
    }
}
