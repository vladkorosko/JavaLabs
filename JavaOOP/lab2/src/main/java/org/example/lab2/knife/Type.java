package org.example.lab2.knife;

import javax.naming.NameNotFoundException;

enum Type {
    KNIFE("Knife"),
    DAGGER("Dagger"),
    STRAIGHT_SWORD("Straight Sword"),
    GREAT_SWORD("Great Sword"),
    CURVED_SWORD("Curved Sword"),
    KATANA("Katana"),
    CURVED_GREAT_SWORD("Curved Great Sword"),
    PIERCING_SWORD("Piercing Sword");

    private String name;

    Type(String name){
        name = name.toLowerCase();
        switch (name){
            case "knife" -> this.name = "Knife";
            case "dagger", "d" -> this.name = "Dagger";
            case "straight sword", "ss" -> this.name = "Straight Sword";
            case "great sword", "gs" -> this.name = "Great Sword";
            case "curved sword", "cs" -> this.name = "Curved Sword";
            case "katana", "k" -> this.name = "Katana";
            case "curved great sword", "cgs" -> this.name = "Curved Great Sword";
            case "piercing sword", "ps" -> this.name = "Piercing Sword";
            default -> {
                try {
                    throw new NameNotFoundException();
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getName() {
        return name;
    }
}
