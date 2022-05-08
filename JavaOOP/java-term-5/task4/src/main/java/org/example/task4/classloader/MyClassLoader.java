package org.example.task4.classloader;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class MyClassLoader extends ClassLoader{
    private Class<?> info;
/*
    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue;
        try {
            while ( (nextValue = Objects.requireNonNull(inputStream).read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }

    @Override
    public Class<?> findClass(String name) {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }*/

    public MyClassLoader(String name) {
        try {
            this.info = Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showParent() {
        if (info.getSuperclass() != null && info.getSuperclass().getName() != "java.lang.Object"){
            System.out.println("The class " + info.getName() + " has superclass:");
            MyClassLoader loader = new MyClassLoader(info.getSuperclass().getName());
            loader.showAllInfo();
        }

        info.getSuperclass();
    }

    public void showPackageName(){
        System.out.println("The class is in '" + info.getPackageName()+"'");
        System.out.println();
    }

    public void showClassName(){
        System.out.println("The class name is '" + info.getName()+"'");
        System.out.println();
    }

    public void showClassFields() {
        Field[] fields = info.getDeclaredFields();
        if (fields.length > 0) {
            System.out.println("The class has field(s):");
            for (Field i : fields) {
                System.out.println(i);
            }
        }else{
            System.out.println("The class has no field");
        }
        System.out.println();
    }

    public void showClassConstructors(){
        Constructor[] constructors = info.getDeclaredConstructors();
        if (constructors.length > 0) {
            System.out.println("The class has constructor(s):");
            for (Constructor i : constructors) {
                System.out.println(i);
            }
        }else{
            System.out.println("The class has no constructor");
        }
        System.out.println();
    }

    public void showClassMethods(){
        Method[] methods = info.getDeclaredMethods();
        if (methods.length > 0) {
            System.out.println("The class has method(s):");
            for (Method i : methods) {
                System.out.println(i);
            }
        }else{
            System.out.println("The class has no method");
        }
        System.out.println();
    }

    public void showClassAnnotations(){
        Annotation[] annotations = info.getDeclaredAnnotations();
        if (annotations.length > 0) {
            System.out.println("The class has annotation(s):");
            for (Annotation i : annotations) {
                System.out.println(i);
            }
        }else{
            System.out.println("The class has no annotation");
        }
        System.out.println();
    }

    public void showAllInfo(){
        System.out.println();
        showPackageName();
        showClassName();
        showClassFields();
        showClassAnnotations();
        showClassConstructors();
        showClassMethods();
        showParent();
    }
}
