package Item;

public class Trousers extends Ammunition{
    public Trousers(int weight, int price) {
        _weight = weight;
        _price = price;
    }

    @Override
    public String toString() {
        return "Trousers{" +
                "weight = " + _weight +
                ", price = " + _price +
                '}';
    }
}
