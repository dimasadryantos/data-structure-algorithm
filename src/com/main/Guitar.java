package com.main;

public class Guitar {

    private String ownerName;
    private String guitarType;
    private String guitarBrand;
    private String price;


    public Guitar(String ownerName, String guitarType, String guitarBrand, String price) {
        this.ownerName = ownerName;
        this.guitarType = guitarType;
        this.guitarBrand = guitarBrand;
        this.price = price;

    }


    public String getPrice() {
        return price;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getGuitarType() {
        return guitarType;
    }

    public String getGuitarBrand() {
        return guitarBrand;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "ownerName='" + ownerName + '\'' +
                ", guitarType='" + guitarType + '\'' +
                ", guitarBrand='" + guitarBrand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
