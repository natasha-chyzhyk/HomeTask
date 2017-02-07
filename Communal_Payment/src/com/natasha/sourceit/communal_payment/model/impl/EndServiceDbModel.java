package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.CalculationFormulaType;
import com.natasha.sourceit.communal_payment.model.ServiceType;
import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;


public class EndServiceDbModel extends SingleIdDbModel {

    private SupplyerDbModel supplyer;
    private ServiceType serviceType;
    private String serviceOption;
    private String description;
    private float scaledPrice;
    private float abonentPrice;
    private CalculationFormulaType calculationType;

    public static Builder builder(long id) {
        return new Builder(id);
    }

    public static class Builder {
        EndServiceDbModel serv;
        private Builder(long id) {
            serv = new EndServiceDbModel(id);
        }
        public Builder setSupplyer(SupplyerDbModel supplyer) {
            serv.supplyer = supplyer;
            return this;
        }
        public Builder setServiceType(ServiceType serviceType) {
            serv.serviceType = serviceType;
            return this;
        }
        public Builder setServiceOption(String serviceOption) {
            serv.serviceOption = serviceOption;
            return this;
        }
        public Builder setDescription(String description) {
            serv.description = description;
            return this;
        }
        public Builder setScaledPrice(float scaledPrice) {
            serv.scaledPrice = scaledPrice;
            return this;
        }
        public Builder setAbonentPrice(float abonentPrice) {
            serv.abonentPrice = abonentPrice;
            return this;
        }
        public Builder setCalculationType(CalculationFormulaType calculationType) {
            serv.calculationType = calculationType;
            return this;
        }

        public EndServiceDbModel build() {
            //TODO Validate all fields set
            return serv;
        }
    }

    private EndServiceDbModel(long id) {
        super(id);
    }

    public SupplyerDbModel getSupplyer() {
        return supplyer;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public String getServiceOption() {
        return serviceOption;
    }

    public String getDescription() {
        return description;
    }

    public float getScaledPrice() {
        return scaledPrice;
    }

    public float getAbonentPrice() {
        return abonentPrice;
    }

    public CalculationFormulaType getCalculationType() {
        return calculationType;
    }
}
