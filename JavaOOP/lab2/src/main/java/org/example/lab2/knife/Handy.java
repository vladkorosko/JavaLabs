package org.example.lab2.knife;

import javax.naming.NameNotFoundException;

enum Handy {
    SINGLE_HANDED("Single-handed"),
    DO_NOT_MATTER("Don't-matter"),
    DOUBLE_HANDED("Double-handed");

    private String name;

    Handy(String name){
        name = name.toLowerCase();
        switch (name){
            case "single-handed", "sh", "single" -> this.name = "Single-handed";
            case "don't-matter", "dm" -> this.name = "Don't-matter";
            case "double-handed", "dh", "double" -> this.name = "Double-handed";
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
