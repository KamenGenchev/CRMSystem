package com.sirma.entities;

public record Client(int ID, String name, Industry industry, String contactPerson, double revenue) {


    @Override
    public String toString() {
        return "Client: " +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", industry=" + industry +
                ", contactPerson='" + contactPerson + '\'' +
                ", revenue=" + revenue;
    }


}
