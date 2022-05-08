package org.example.task4;

import org.example.task4.classloader.MyClassLoader;
import org.example.task4.testclasses.Test;
import org.example.task4.testclasses.TestClass1;

public class Main {
    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader("org.example.task4.classloader.MyClassLoader");
        loader.showAllInfo();
    }
}
