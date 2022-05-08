package org.example.lab1.item;

public class Gauntlets extends Ammunition{
    public Gauntlets(int weight, int price) {
        _weight = weight;
        _price = price;
    }

    @Override
    public String toString() {
        return "Gauntlets{" +
                "weight = " + _weight +
                ", price = " + _price +
                '}';
    }
}
