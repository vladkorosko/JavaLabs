package org.example.lab2.knife;

import javax.naming.NameNotFoundException;

public class Knife {
    Integer id;
    Type type;
    Handy handy;
    String origin;
    Visual visual;
    Integer weight;
    boolean value;

    public Knife(Integer id, String type, String handy, String origin,
          int length, int width, String material_blade,
          String material_handle, boolean fuller,
          int weight, boolean value) throws NameNotFoundException {
        this.id = id;
        type = type.toLowerCase();
        switch (type) {
            case "knife" -> this.type = Type.KNIFE;
            case "dagger", "d" -> this.type = Type.DAGGER;
            case "straight sword", "ss" -> this.type = Type.STRAIGHT_SWORD;
            case "great sword", "gs" -> this.type = Type.GREAT_SWORD;
            case "curved sword", "cs" -> this.type = Type.CURVED_SWORD;
            case "katana", "k" -> this.type = Type.KATANA;
            case "curved great sword", "cgs" -> this.type = Type.CURVED_GREAT_SWORD;
            case "piercing sword", "ps" -> this.type = Type.PIERCING_SWORD;
            default -> throw new NameNotFoundException();
        }

        handy = handy.toLowerCase();
        switch (handy){
            case "single-handed", "sh", "single" -> this.handy = Handy.SINGLE_HANDED;
            case "don't matter", "dm" -> this.handy = Handy.DO_NOT_MATTER;
            case "double-handed", "dh", "double" -> this.handy = Handy.DOUBLE_HANDED;
            default -> throw new NameNotFoundException();
        }

        this.origin = origin;
        this.visual = new Visual(length,width,material_blade,material_handle,fuller);
        this.weight = weight;
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) throws NameNotFoundException {
        type = type.toLowerCase();
        switch (type) {
            case "knife" -> this.type = Type.KNIFE;
            case "dagger", "d" -> this.type = Type.DAGGER;
            case "straight sword", "ss" -> this.type = Type.STRAIGHT_SWORD;
            case "great sword", "gs" -> this.type = Type.GREAT_SWORD;
            case "curved sword", "cs" -> this.type = Type.CURVED_SWORD;
            case "katana", "k" -> this.type = Type.KATANA;
            case "curved great sword", "cgs" -> this.type = Type.CURVED_GREAT_SWORD;
            case "piercing sword", "ps" -> this.type = Type.PIERCING_SWORD;
            default -> throw new NameNotFoundException();
        }
    }

    public void setHand(String handy) throws NameNotFoundException {
        handy = handy.toLowerCase();
        switch (handy){
            case "single-handed", "sh", "single" -> this.handy = Handy.SINGLE_HANDED;
            case "don't matter", "dm" -> this.handy = Handy.DO_NOT_MATTER;
            case "double-handed", "dh", "double" -> this.handy = Handy.DOUBLE_HANDED;
            default -> throw new NameNotFoundException();
        }
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setLength(Integer length) {
        this.visual.setLength(length);
    }

    public void setWidth(Integer width) {
        this.visual.setWidth(width);
    }

    public void setMaterialOfBlade(String material_of_blade) {
        this.visual.setMaterialOfBlade(material_of_blade);
    }

    public void setMaterialOfHandle(String material_of_handle) {
        this.visual.setMaterialOfHandle(material_of_handle);
    }

    public void setFuller(boolean fuller) {
        this.visual.setFuller(fuller);
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getType() {
        return type.getName();
    }

    public String getHandy() {
        return handy.getName();
    }

    public String getOrigin() {
        return origin;
    }

    public Integer getLength() {
        return visual.getLength();
    }

    public Integer getWidth() {
        return visual.getWidth();
    }

    public String getMaterialOfBlade() {
        return visual.getMaterialOfBlade();
    }

    public String getMaterialOfHandle() {
        return visual.getMaterialOfHandle();
    }

    public boolean haveFuller() {
        return visual.haveFuller();
    }

    public Integer getWeight() {
        return weight;
    }

    public boolean isValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Knife{" +
                "id=" + id +
                ", type=" + type +
                ", handy=" + handy +
                ", origin='" + origin + '\'' +
                ", visual=" + visual +
                ", weight=" + weight.toString() +
                ", value=" + value +
                '}';
    }
}

