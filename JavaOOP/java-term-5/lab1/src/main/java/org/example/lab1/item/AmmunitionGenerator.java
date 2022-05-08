package org.example.lab1.item;

public interface AmmunitionGenerator {
    public static Ammunition generate(){
        Ammunition a;
        int t = (int)(Math.random()*6);
        switch (t){
            case 0 -> a = new Helmet((int)(Math.random()*10), (int)(Math.random()*100));
            case 1 -> a = new Armor((int)(Math.random()*10), (int)(Math.random()*100));
            case 2 -> a = new Weapon((int)(Math.random()*10), (int)(Math.random()*100));
            case 3 -> a = new Gauntlets((int)(Math.random()*10), (int)(Math.random()*100));
            case 4 -> a = new Trousers((int)(Math.random()*10), (int)(Math.random()*100));
            default -> a = new Shoes((int)(Math.random()*10), (int)(Math.random()*100));
        }
        return a;
    }
}

