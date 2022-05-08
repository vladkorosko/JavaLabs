package org.example.lab2.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorXMLTest {
    @Test
    void validateAgainstXSD(){
        assertFalse(ValidatorXML.validateAgainstXSD("xml/test1_false.xml", "knife.xsd"));
        assertFalse(ValidatorXML.validateAgainstXSD("xml/test2_false.xml", "knife.xsd"));
        assertFalse(ValidatorXML.validateAgainstXSD("xml/test3_false.xml", "knife.xsd"));
        assertFalse(ValidatorXML.validateAgainstXSD("xml/test4_false.xml", "knife.xsd"));
        assertFalse(ValidatorXML.validateAgainstXSD("xml/test5_false.xml", "knife.xsd"));
        assertTrue(ValidatorXML.validateAgainstXSD("xml/test1_true.xml", "knife.xsd"));
        assertTrue(ValidatorXML.validateAgainstXSD("xml/test2_true.xml", "knife.xsd"));
        assertTrue(ValidatorXML.validateAgainstXSD("xml/test3_true.xml", "knife.xsd"));
        assertTrue(ValidatorXML.validateAgainstXSD("xml/test4_true.xml", "knife.xsd"));
        assertTrue(ValidatorXML.validateAgainstXSD("xml/test5_true.xml", "knife.xsd"));
        assertTrue(ValidatorXML.validateAgainstXSD("xml/knives.xml", "knife.xsd"));
    }
}
