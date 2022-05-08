package org.example.lab2.parser.sax;

import org.example.lab2.knife.Knife;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

class MyHandler extends DefaultHandler {

    private final List<Knife> knives = new ArrayList<>();
    private StringBuilder data = null;

    private Integer id = null;
    private String type = null;
    private String handy = null;
    private String origin = null;
    private Integer length = null;
    private Integer width = null;
    private String mob = null;
    private String moh = null;
    private Boolean fuller = null;
    private Integer weight = null;
    private Boolean value = null;

    private String tag = "no tag";

    public List<Knife> getKnives() {
        return knives;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("id")) {
            tag = "id";
        } else if (qName.equalsIgnoreCase("type")) {
            tag = "type";
        } else if (qName.equalsIgnoreCase("handy")) {
            tag = "handy";
        } else if (qName.equalsIgnoreCase("origin")) {
            tag = "origin";
        } else if (qName.equalsIgnoreCase("length")) {
            tag = "length";
        } else if (qName.equalsIgnoreCase("width")) {
            tag = "width";
        } else if (qName.equalsIgnoreCase("material_of_blade")) {
            tag = "mob";
        } else if (qName.equalsIgnoreCase("material_of_handle")) {
            tag = "moh";
        } else if (qName.equalsIgnoreCase("fuller")) {
            tag = "fuller";
        } else if (qName.equalsIgnoreCase("weight")) {
            tag = "weight";
        } else if (qName.equalsIgnoreCase("value")) {
            tag = "value";
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (tag){
            case "id" -> this.id = Integer.parseInt(data.toString());
            case "type" -> this.type = data.toString();
            case "handy" -> this.handy = data.toString();
            case "origin" -> this.origin = data.toString();
            case "length" -> this.length = Integer.parseInt(data.toString());
            case "width" -> this.width = Integer.parseInt(data.toString());
            case "mob" -> this.mob = data.toString();
            case "moh" -> this.moh = data.toString();
            case "fuller" -> this.fuller = Boolean.parseBoolean(data.toString());
            case "weight" -> this.weight = Integer.parseInt(data.toString());
            case "value" -> this.value = Boolean.parseBoolean(data.toString());
        }
        tag = "no tag";

        if (qName.equalsIgnoreCase("knife")) {
            knives.add(new Knife(id, type, handy, origin, length, width,
                    mob, moh, fuller, weight, value));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
