package org.example.lab1.item;

public class Helmet extends Ammunition
{
    public Helmet(int weight, int price) {
        _weight = weight;
        _price = price;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "weight = " + _weight +
                ", price = " + _price +
                '}';
    }
}
