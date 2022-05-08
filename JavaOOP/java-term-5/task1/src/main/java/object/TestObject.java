package object;

import java.io.Serializable;

public class TestObject implements Serializable {
    private int number;
    private String text;

    public TestObject(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}
