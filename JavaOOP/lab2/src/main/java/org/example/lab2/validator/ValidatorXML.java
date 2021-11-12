package org.example.lab2.validator;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public interface ValidatorXML {
    static boolean validateAgainstXSD(String path_xml, String path_xsd)
    {
        InputStream xml = null;
        InputStream xsd = null;
        try {
            xml = new FileInputStream(path_xml);
            xsd = new FileInputStream(path_xsd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        try
        {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}
