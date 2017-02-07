package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.DoubleIdDbModel;
import com.natasha.sourceit.communal_payment.model.IAccountId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 27.01.2017.
 */
public class AccountDbModel extends DoubleIdDbModel implements IAccountId {

    private FlatDbModel flat;
    private SupplyerDbModel supplyer;
    List<PaymentDbModel> payments;


    public static AccountDbModel create(SupplyerDbModel supplyer, FlatDbModel flat, List<PaymentDbModel> payments) {
        AccountDbModel acc = new AccountDbModel(supplyer.getId(), flat.getId());
        acc.flat = flat;
        acc.supplyer = supplyer;
        acc.setPayments(payments);
        return acc;
    }

    private void setPayments(List<PaymentDbModel> payments) {
        this.payments = new ArrayList<>(payments.size());
        this.payments.addAll(payments);
    }


    private AccountDbModel(long supplyerId, long flatId) {
        super(supplyerId, flatId);
    }

    public FlatDbModel getFlat() {
        return flat;
    }

    public SupplyerDbModel getSupplyer() {
        return supplyer;
    }

    public List<PaymentDbModel> getPayments() {
        List<PaymentDbModel> ppp = new ArrayList<>(this.payments.size());
        ppp.addAll(this.payments);
        return ppp;
    }

    @Override
    public long flatId() {
        return flat.getId();
    }

    @Override
    public long supplyerId() {
        return supplyer.getId();
    }
}
