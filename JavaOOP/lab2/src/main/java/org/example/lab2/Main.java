package org.example.lab2;

import org.example.lab2.knife.Knife;
import org.example.lab2.parser.dox.MyDOMParser;
import org.example.lab2.parser.sax.MySAXParser;
import org.example.lab2.parser.stax.MyStAXParser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("DOM parser");
        MyDOMParser p = new MyDOMParser("knife.xsd", "knives.xml");
        List<Knife> knives = p.parseXML();
        for (Knife k : knives){
            System.out.println(k);
        }
        System.out.println();
        System.out.println("SAX parser");
        MySAXParser p2 = new MySAXParser( "knives.xml", "knife.xsd");
        knives = p2.parseXML();
        for (Knife k : knives){
            System.out.println(k);
        }

        System.out.println();
        System.out.println("StAX parser");
        MyStAXParser p3 = new MyStAXParser( "knives.xml", "knife.xsd");
        knives = p3.parseXML();
        for (Knife k : knives){
            System.out.println(k);
        }

    }
}
