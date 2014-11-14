/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

/**
 *
 * @author JorgeLuis
 */
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ParserRemoveXML extends ParserRemove {
    public ArrayList<String> getAtributos(String entrada)throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
        InputSource is = new InputSource(new StringReader(entrada));
        org.w3c.dom.Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        XPath xpath = XPathFactory.newInstance().newXPath();
        ArrayList<String> atributosAdd = new ArrayList<String>();
        
        atributosAdd.add((String)xpath.evaluate("USERNAME",xmlDoc.getDocumentElement(),XPathConstants.STRING));
        atributosAdd.add((String)xpath.evaluate("ADM-PASS",xmlDoc.getDocumentElement(),XPathConstants.STRING)); 
       
        return atributosAdd;
    }
    
    
}
