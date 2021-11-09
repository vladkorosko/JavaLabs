package org.example.lab2.parser.sax;

import org.example.lab2.knife.Knife;
import org.example.lab2.validator.ValidatorXML;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MySAXParser extends DefaultHandler {
    private final String xml_path;
    private final String xsd_path;

    public MySAXParser(String xml_path, String xsd_path){
        this.xsd_path = xsd_path;
        this.xml_path = xml_path;
    }

    private boolean validateXMLByXSD() {
        return ValidatorXML.validateAgainstXSD(xml_path, xsd_path);
    }

    public List<Knife> parseXML() throws IOException {
        if (!validateXMLByXSD())
            throw new IOException();
        List<Knife> knives = new ArrayList<>();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File(xml_path), handler);
            knives = handler.getKnives();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return knives;
    }
}

