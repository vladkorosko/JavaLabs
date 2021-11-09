package org.example.lab2.knife;

class Visual {
    Integer length;
    Integer width;
    String material_of_blade;
    String material_of_handle;
    boolean fuller;

    Visual(int length, int width, String material_of_blade, String material_of_handle, boolean fuller){
        this.length = length;
        this.width = width;
        this.material_of_blade = material_of_blade;
        this.material_of_handle = material_of_handle;
        this.fuller = fuller;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setMaterialOfBlade(String material_of_blade) {
        this.material_of_blade = material_of_blade;
    }

    public void setMaterialOfHandle(String material_of_handle) {
        this.material_of_handle = material_of_handle;
    }

    public void setFuller(boolean fuller) {
        this.fuller = fuller;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }

    public String getMaterialOfBlade() {
        return material_of_blade;
    }

    public String getMaterialOfHandle() {
        return material_of_handle;
    }

    public boolean haveFuller() {
        return fuller;
    }

    @Override
    public String toString() {
        return "Visual{" +
                "length=" + length +
                ", width=" + width +
                ", material_of_blade='" + material_of_blade + '\'' +
                ", material_of_handle='" + material_of_handle + '\'' +
                ", fuller=" + fuller +
                '}';
    }
}
