/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorautenticacion;

import java.io.IOException;
import java.io.StringReader;
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
 * @author Tincho
 */
public class ParserXML extends Parser {
  
    @Override
    public String getTipo (String entrada){
        try {
            InputSource is = new InputSource(new StringReader(entrada));
            org.w3c.dom.Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            XPath xpath = XPathFactory.newInstance().newXPath();
            String tipo = (String)xpath.evaluate("@TYPE",xmlDoc.getDocumentElement(),XPathConstants.STRING);
            System.out.println(tipo);
            return tipo;
      } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
      }
        return null;
        
        
    }

        
}

