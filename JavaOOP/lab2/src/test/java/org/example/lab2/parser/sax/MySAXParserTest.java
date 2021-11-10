package org.example.lab2.parser.sax;

import org.example.lab2.knife.Knife;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySAXParserTest {
    private final static String xsd_path = "knife.xsd";
    private List<Knife> result_of_parsing = new ArrayList<>();

    @Test
    void parseXML(){

        assertFalse(catchException("xml/test1_false.xml"));
        assertFalse(catchException("xml/test2_false.xml"));
        assertFalse(catchException("xml/test3_false.xml"));
        assertFalse(catchException("xml/test4_false.xml"));
        assertFalse(catchException("xml/test5_false.xml"));
        {
            assertTrue(catchException("xml/test1_true.xml"));
            Knife k1 = new Knife(102930, "STRAIGHT_SWORD",
                    "SINGLE_HANDED", "Germany",
                    110,6,"Steel",
                    "Maple", true, 1000, false);
            Knife k2 = new Knife(102931, "STRAIGHT_SWORD",
                    "SINGLE_HANDED", "Germany",
                    110,6,"Steel",
                    "Maple", true, 1000, true);
            List<Knife> expected = List.of(k1, k2);
            for (int i = 0; i < expected.size(); i++){
                assertEquals(expected.get(i), result_of_parsing.get(i));
            }
        }
        {
            assertTrue(catchException("xml/test2_true.xml"));
            Knife k1 = new Knife(103040, "KNIFE",
                    "SINGLE_HANDED", "Ukraine",
                    20,2,"Steel",
                    "Plastic", false, 200, false);
            Knife k2 = new Knife(103041, "KNIFE",
                    "SINGLE_HANDED", "Ukraine",
                    20,2,"Steel",
                    "Plastic", false, 200, true);
            List<Knife> expected = List.of(k1, k2);
            for (int i = 0; i < expected.size(); i++){
                assertEquals(expected.get(i), result_of_parsing.get(i));
            }
        }
        {
            assertTrue(catchException("xml/test3_true.xml"));
            Knife k1 = new Knife(110022, "PIERCING_SWORD",
                    "SINGLE_HANDED", "England",
                    75,2,"Steel",
                    "Steel", false, 1000, false);
            Knife k2 = new Knife(110023, "PIERCING_SWORD",
                    "SINGLE_HANDED", "England",
                    75,2,"Steel",
                    "Steel", false, 1000, true);
            List<Knife> expected = List.of(k1, k2);
            for (int i = 0; i < expected.size(); i++){
                assertEquals(expected.get(i), result_of_parsing.get(i));
            }
        }
        {
            assertTrue(catchException("xml/test4_true.xml"));
            Knife k1 = new Knife(120930, "CURVED_GREAT_SWORD",
                    "DOUBLE_HANDED", "France",
                    200,10,"Dragon bone",
                    "Dragon bone", false, 10000, false);
            Knife k2 = new Knife(120931, "CURVED_GREAT_SWORD",
                    "DOUBLE_HANDED", "France",
                    200,10,"Dragon bone",
                    "Dragon bone", false, 10000, true);
            List<Knife> expected = List.of(k1, k2);
            for (int i = 0; i < expected.size(); i++){
                assertEquals(expected.get(i), result_of_parsing.get(i));
            }
        }
        {
            assertTrue(catchException("xml/test5_true.xml"));
            Knife k1 = new Knife(109382, "DAGGER",
                    "SINGLE_HANDED", "Italy",
                    50,3,"Steel",
                    "Oak", false, 500, false);
            Knife k2 = new Knife(109383, "DAGGER",
                    "SINGLE_HANDED", "Italy",
                    50,3,"Steel",
                    "Oak", false, 500, true);
            List<Knife> expected = List.of(k1, k2);
            for (int i = 0; i < expected.size(); i++){
                assertEquals(expected.get(i), result_of_parsing.get(i));
            }

        }
    }

    private boolean catchException(String xml_path){
        try {
            MySAXParser p = new MySAXParser(xml_path, xsd_path);
            result_of_parsing = p.parseXML();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}