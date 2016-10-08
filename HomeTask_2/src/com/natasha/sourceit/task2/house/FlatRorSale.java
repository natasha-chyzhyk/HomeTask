package com.natasha.sourceit.task2.house;

public class FlatRorSale extends Flat{
    private float price;
    private boolean urgent;

    public void setPrice(float price){
        this.price = price;
    }

    public void setUrgent(boolean urgent){
        this.urgent = urgent;
    }

    public float getPrice() {
        return price;
    }

    public boolean getUrgent() {
        return urgent;
    }

    public void sale(){
        System.out.println("Flat for sale: "+ price + ", " + (urgent ? "urgently" : "not urgently"));
    }

    public void sold(){
        System.out.println("Flat is sold: "+ price);
    }
}
