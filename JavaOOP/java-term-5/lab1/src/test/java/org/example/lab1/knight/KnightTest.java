package org.example.lab1.knight;

import org.example.lab1.item.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void addItem() {
        Knight k = new Knight();
        assertEquals(k.get_inventory().size(), 0);
        List<Ammunition> l = new ArrayList<>();
        Ammunition a1 = new Helmet(1, 1);
        l.add(a1);
        k.addItem(a1);
        assertEquals(k.get_inventory(), l);
        a1 = new Armor(1, 2);
        l.add(a1);
        k.addItem(a1);
        assertEquals(k.get_inventory(), l);
        a1 = new Weapon(2, 1);
        l.add(a1);
        k.addItem(a1);
        assertEquals(k.get_inventory(), l);
        a1 = new Gauntlets(2, 2);
        l.add(a1);
        k.addItem(a1);
        assertEquals(k.get_inventory(), l);
        a1 = new Shoes(3, 2);
        l.add(a1);
        k.addItem(a1);
        assertEquals(k.get_inventory(), l);
        a1 = new Trousers(3, 1);
        l.add(a1);
        k.addItem(a1);
        assertEquals(k.get_inventory(), l);
        a1 = new Trousers(3, 1);
        l.add(a1);
        k.addItem(a1);
        assertEquals(k.get_inventory(), l);
        assertEquals(k.get_inventory().size(), 7);
    }

    @Test
    void removeItem() {
        Knight k = new Knight();
        List<Ammunition> l = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Ammunition a = AmmunitionGenerator.generate();
            k.addItem(a);
            l.add(a);
        }
        for (int i = 9; i>=0; i--){
            l.remove(i);
            k.removeItem(i);
            assertEquals(k.get_inventory(), l);
        }
        for(int i = 0; i < 10; i++){
            Ammunition a = AmmunitionGenerator.generate();
            k.addItem(a);
            l.add(a);
        }
        for (int i = 9; i>=0; i--){
            Ammunition a = l.get((int)(Math.random()*l.size()));
            l.remove(a);
            k.removeItem(a);
            assertEquals(k.get_inventory(), l);
        }
    }

    @Test
    void sortInventory() {
        for (int i = 0; i < 10; i++){
            Knight k = new Knight();
            List<Ammunition> l;
            for(int j = 0; j < 9; j++){
                Ammunition a = AmmunitionGenerator.generate();
                k.addItem(a);
            }
            k.sortInventory();
            l = k.get_inventory();
            for (int j = 0; j < l.size()-1; j++){
                assertTrue(l.get(j).getWeight() <= l.get(j+1).getWeight());
            }
        }
    }

    @Test
    void clear() {
        Knight k = new Knight();
        Ammunition a = new Armor(1,1);
        for (int i = 1; i < 20; i++){
            for (int j = 0; j < i; j++){
                k.addItem(a);
            }
            assertEquals(k.get_inventory().size(), i);
            k.clear();
            assertEquals(k.get_inventory().size(), 0);
        }
    }

    @Test
    void findInRange() {
        for (int j = 0; j< 5; j++) {
            Knight k = new Knight();
            for (int i = 0; i < 100; i++) {
                Ammunition a = AmmunitionGenerator.generate();
                k.addItem(a);
            }
            List<Ammunition> l;
            int border1 = (int) (Math.random() * 100);
            int border2 = (int) (Math.random() * 100);
            if (border1 > border2) {
                int temp = border1;
                border1 = border2;
                border2 = temp;
            }
            l = k.findInRange(border1, border2);
            for (Ammunition a : l) {
                assertTrue(a.getPrice() >= border1);
                assertTrue(a.getPrice() <= border2);
            }
        }
    }

    @Test
    void calculatePrice() {
        for (int i = 0; i < 10; i++) {
            Knight k = new Knight();
            List<Ammunition> l = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Ammunition a = AmmunitionGenerator.generate();
                k.addItem(a);
                l.add(a);
            }
            int sum = l.stream()
                    .map(Ammunition::getPrice)
                    .reduce(Integer::sum)
                    .orElse(0);
            assertEquals(k.calculatePrice(), sum);
        }
    }
}