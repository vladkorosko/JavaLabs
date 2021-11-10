package org.example.lab2.parser.dom;

import org.example.lab2.knife.Knife;
import org.example.lab2.parser.MyParser;
import org.example.lab2.validator.ValidatorXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDOMParser extends MyParser {
    public MyDOMParser(String xml_path, String xsd_path) {
        super(xml_path,xsd_path);
    }

    public List<Knife> parseXML() throws IOException {
        if (!validateXMLByXSD())
            throw new IOException();
        List<Knife> knives = new ArrayList<>();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = builderFactory.newDocumentBuilder();
            Document document;
            document = builder.parse(new File(xml_path));
            Element rootElement = document.getDocumentElement();
            NodeList nodes = rootElement.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node instanceof Element knife) {
                    int id = Integer.parseInt(knife.getElementsByTagName("id")
                            .item(0)
                            .getTextContent());
                    String type = knife.getElementsByTagName("type")
                            .item(0)
                            .getTextContent();
                    String handy = knife.getElementsByTagName("handy")
                            .item(0)
                            .getTextContent();
                    String origin = knife.getElementsByTagName("origin")
                            .item(0)
                            .getTextContent();
                    int length = Integer.parseInt(knife.getElementsByTagName("length")
                            .item(0)
                            .getTextContent());
                    int width = Integer.parseInt(knife.getElementsByTagName("width")
                            .item(0)
                            .getTextContent());
                    String mob = knife.getElementsByTagName("material_of_blade")
                            .item(0)
                            .getTextContent();
                    String moh = knife.getElementsByTagName("material_of_handle")
                            .item(0)
                            .getTextContent();
                    boolean fuller = Boolean.parseBoolean(knife.getElementsByTagName("fuller")
                            .item(0)
                            .getTextContent());
                    int weight = Integer.parseInt(knife.getElementsByTagName("weight")
                            .item(0)
                            .getTextContent());
                    boolean value = Boolean.parseBoolean(knife.getElementsByTagName("value")
                            .item(0)
                            .getTextContent());
                    knives.add(new Knife(id,type,handy,origin,length,width,mob,moh,fuller,weight,value));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return knives;
    }
}
