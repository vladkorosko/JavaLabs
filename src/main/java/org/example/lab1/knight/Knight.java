package org.example.lab1.knight;

import org.example.lab1.item.Ammunition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Knight {
    private final List<Ammunition> _inventory = new ArrayList<>();

    public List<Ammunition> get_inventory() {
        return _inventory;
    }

    public void addItem(Ammunition item) {
        _inventory.add(item);
    }

    public boolean removeItem(Ammunition item) {
        return _inventory.remove(item);
    }

    public Ammunition removeItem(int index) {
        if (index >= _inventory.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return _inventory.remove(index);
    }

    public void sortInventory() {
        Collections.sort(_inventory);
    }

    public void clear() {
        _inventory.clear();
    }

    public List<Ammunition> findInRange(int min_price, int max_price) {
        return _inventory.stream()
                .filter(item->item.getPrice()>=min_price && item.getPrice()<=max_price)
                .collect(Collectors.toList());
    }

    public int calculatePrice() {
        return  _inventory.stream()
                .map(Ammunition::getPrice)
                .reduce(Integer::sum).orElse(0);
    }
}
