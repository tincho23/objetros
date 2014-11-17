/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author JorgeLuis
 */
public class ParserAutenticacion extends ParserXML{
    ArrayList<String> getAtributos(String entrada) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        atributosArrayList.add(getAtributo(entrada, "USERNAME"));
        atributosArrayList.add(getAtributo(entrada, "PASSWORD"));
        return atributosArrayList;
    }
}
