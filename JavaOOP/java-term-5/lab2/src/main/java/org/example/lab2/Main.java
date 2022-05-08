package org.example.lab2;

import org.example.lab2.knife.Knife;
import org.example.lab2.parser.dom.MyDOMParser;
import org.example.lab2.parser.sax.MySAXParser;
import org.example.lab2.parser.stax.MyStAXParser;
import org.example.lab2.validator.ValidatorXML;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(ValidatorXML.validateAgainstXSD("knives.xml", "knife.xsd"));
            System.out.println("DOM parser");
            MyDOMParser p = new MyDOMParser( "xml/knives.xml", "knife.xsd");
            List<Knife> knives = p.parseXML();
            for (Knife k : knives){
                System.out.println(k);
            }
            System.out.println();
            System.out.println("SAX parser");
            MySAXParser p2 = new MySAXParser( "xml/knives.xml", "knife.xsd");
            knives = p2.parseXML();
            for (Knife k : knives){
                System.out.println(k);
            }

            System.out.println();
            System.out.println("StAX parser");
            MyStAXParser p3 = new MyStAXParser( "xml/knives.xml", "knife.xsd");
            knives = p3.parseXML();
            for (Knife k : knives){
                System.out.println(k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
