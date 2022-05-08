package org.example.lab2.knife;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
class Visual {
    Integer length;
    Integer width;
    String materialOfBlade;
    String materialOfHandle;
    boolean fuller;

    Visual(int length, int width, String materialOfBlade, String materialOfHandle, boolean fuller){
        this.length = length;
        this.width = width;
        this.materialOfBlade = materialOfBlade;
        this.materialOfHandle = materialOfHandle;
        this.fuller = fuller;
    }
}
