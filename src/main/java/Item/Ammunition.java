package Item;

public abstract class Ammunition implements Comparable{
    protected Integer _weight;
    protected Integer _price;

    public int getWeight() {
        return _weight;
    }

    public int getPrice() {
        return _price;
    }

    @Override
    public int compareTo(Object o)
    {
        Ammunition a = (Ammunition) o;
        return _weight.compareTo(a._weight);
    }

}