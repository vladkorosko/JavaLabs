package org.example.lab1.item;

public class Shoes extends Ammunition{
    public Shoes(int weight, int price) {
        _weight = weight;
        _price = price;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "weight = " + _weight +
                ", price = " + _price +
                '}';
    }
}
