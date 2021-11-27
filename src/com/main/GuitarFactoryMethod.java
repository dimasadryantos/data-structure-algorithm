package com.main;

public class GuitarFactoryMethod {


    public static Guitar fender(String ownerName) {
        return new Guitar(ownerName, "strato caster", "fender", "10000");
    }

    public static Guitar prs(String ownerName) {
        return new Guitar(ownerName, "tele caster", "prs", "12000");
    }


}
