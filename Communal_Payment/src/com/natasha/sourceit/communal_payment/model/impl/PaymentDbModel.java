package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.IAccountId;
import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;

import java.util.Date;

/**
 * Created by Stas on 27.01.2017.
 */
public class PaymentDbModel extends SingleIdDbModel implements IAccountId {

    private IAccountId accId;
    private Date date;
    private float summa;

    public static Builder builder(long id) {
        return new Builder(id);
    }

    public static class Builder {
        private PaymentDbModel paym;
        public Builder(long id) {
            paym = new PaymentDbModel(id);
        }

        public Builder setAccount(IAccountId accId) {
            paym.accId = accId;
            return this;
        }

        public Builder setDate(Date date) {
            paym.date = date;
            return this;
        }

        public Builder setSumma(float summa) {
            paym.summa = summa;
            return this;
        }

        public PaymentDbModel build() {
            return paym;
        }
    }


    private PaymentDbModel(long id) {
        super(id);
    }


    @Override
    public long flatId() {
        return accId.flatId();
    }

    @Override
    public long supplyerId() {
        return accId.supplyerId();
    }

    public Date getDate() {
        return date;
    }

    public float getSumma() {
        return summa;
    }
}


