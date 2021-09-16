package Item;

public class Weapon extends Ammunition{
    public Weapon(int weight, int price) {
        _weight = weight;
        _price = price;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weight = " + _weight +
                ", price = " + _price +
                '}';
    }
}
