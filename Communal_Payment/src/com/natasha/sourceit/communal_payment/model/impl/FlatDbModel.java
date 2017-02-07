package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.FlatAddress;
import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;
import com.natasha.sourceit.communal_payment.model.StreetAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 27.01.2017.
 */
public class FlatDbModel extends SingleIdDbModel implements FlatAddress {

    private float square;
    private int flatNumber;
    private FlatOwnerDbModel owner;
    private StreetAddress streetAddress;
    private List<HumanDbModel> occupants;
    private List<EndServiceDbModel> services;

    public static Builder builder(long id) {
        return new Builder(id);
    }




    public static class Builder {
        FlatDbModel flat;
        private Builder(long id) {
            flat = new FlatDbModel(id);
        }

        public Builder setSquare(float square) {
            flat.square = square;
            return this;
        }
        public Builder setFlatNumber(int flatNumber) {
            flat.flatNumber = flatNumber;
            return this;
        }
        public Builder setOwner(FlatOwnerDbModel owner) {
            flat.owner = owner;
            return this;
        }
        public Builder setStreetAddress(StreetAddress streetAddress) {
            flat.streetAddress = streetAddress;
            return this;
        }
        public Builder setOccupants(List<HumanDbModel> occupants) {
            flat.occupants = occupants;
            return this;
        }
        public Builder setServices(List<EndServiceDbModel> services) {
            flat.services = services;
            return this;
        }
        public FlatDbModel build() {
            return flat;
        }
    }

    private FlatDbModel(long id) {
        super(id);
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
    public int getFlatNumber() {
        return flatNumber;
    }

    public float getSquare() {
        return square;
    }

    public HumanDbModel getOwner() {
        return owner;
    }

    public List<HumanDbModel> getOccupants() {
        List<HumanDbModel> occ = new ArrayList<>(occupants.size());
        occ.addAll(occupants);
        return occ;
    }

    public List<EndServiceDbModel> getServices() {
        List<EndServiceDbModel> items = new ArrayList<>(services.size());
        items.addAll(services);
        return items;
    }
}
