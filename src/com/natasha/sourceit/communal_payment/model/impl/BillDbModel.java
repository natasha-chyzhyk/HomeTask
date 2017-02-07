package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;

import java.util.Date;

/**
 * Created by Stas on 28.01.2017.
 */
public class BillDbModel extends SingleIdDbModel {

    private FlatDbModel flat;
    private long serviceId;
    private Date dateCreation;
    private float scaledPriceAtCreation;
    private float abonentPriceAtCreation;
    private float totalCharge;

    public static Builder builder(long id) {
        return new Builder(id);
    }

    public static class Builder {
        private BillDbModel bill;


        private Builder(long id) {
            bill = new BillDbModel(id);
        }
        public Builder setFlat(FlatDbModel flat) {
            bill.flat = flat;
            return this;
        }
        public Builder setServoceId(long serviceId) {
            bill.serviceId = serviceId;
            return this;
        }
        public Builder setDateCreation(Date dateCreation) {
            bill.dateCreation = dateCreation;
            return this;
        }
        public Builder setPrices(float scaledPriceAtCreation, float abonentPriceAtCreation) {
            bill.scaledPriceAtCreation = scaledPriceAtCreation;
            bill.abonentPriceAtCreation = abonentPriceAtCreation;
            return this;
        }
        public Builder setTotalCharge(float totalCharge) {
            bill.totalCharge = totalCharge;
            return this;
        }

        public BillDbModel build() {
            //TODO Validate all fields set
            return bill;
        }
    }

    private BillDbModel(long id) {
        super(id);
    }

    public FlatDbModel getFlat() {
        return flat;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public EndServiceDbModel getEndService() {
        for (EndServiceDbModel serv : flat.getServices()) {
            if (serv.getId() == serviceId) {
                return serv;
            }
        }
        throw new IllegalStateException("Ooops! Service for this bill was not found");
    }

    public float getScaledPriceAtCreation() {
        return scaledPriceAtCreation;
    }

    public float getAbonentPriceAtCreation() {
        return abonentPriceAtCreation;
    }

    public float getTotalCharge() {
        return totalCharge;
    }
}
