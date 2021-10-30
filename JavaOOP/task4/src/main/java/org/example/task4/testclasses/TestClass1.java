package org.example.task4.testclasses;

public class TestClass1 extends Test{
    private int a;
    public static String name;
    public static final int index = 1;


    public void setA(int a) {
        this.a = a;
    }

    public static void setName(String name) {
        TestClass1.name = name;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
