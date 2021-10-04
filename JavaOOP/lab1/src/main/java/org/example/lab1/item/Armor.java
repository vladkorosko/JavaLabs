package org.example.lab1.item;

public class Armor extends Ammunition{
    public Armor(int weight, int price) {
        _weight = weight;
        _price = price;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "weight = " + _weight +
                ", price = " + _price +
                '}';
    }
}
