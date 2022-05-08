package org.example.lab2.knife;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
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
          int weight, boolean value) {
        this.id = id;
        this.type = Type.valueOf(type);
        this.handy = Handy.valueOf(handy);
        this.origin = origin;
        this.visual = new Visual(length,width,material_blade,material_handle,fuller);
        this.weight = weight;
        this.value = value;
    }

    public Integer getLength(){
        return visual.getLength();
    }

    public Integer getWidth(){
        return visual.getWidth();
    }

    public String getMaterialOfBlade(){
        return visual.getMaterialOfBlade();
    }

    public String getMaterialOfHandle(){
        return visual.getMaterialOfHandle();
    }

    public boolean hasFuller(){
        return visual.isFuller();
    }
}

