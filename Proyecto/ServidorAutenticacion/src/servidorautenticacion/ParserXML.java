/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

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

/**
 *
 * @author JorgeLuis
 */
public abstract class ParserXML {
    ArrayList<String> atributosArrayList = new ArrayList<>();
    public String getAtributo(String entrada, String atributo) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
        InputSource is = new InputSource(new StringReader(entrada));
        org.w3c.dom.Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        XPath xpath = XPathFactory.newInstance().newXPath();
        return ((String)xpath.evaluate(atributo,xmlDoc.getDocumentElement(),XPathConstants.STRING));
    }
}
