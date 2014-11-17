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
 * Clase que parsea los mensajes XML de modificar usuario
 * @author Blanco - Matus - Herlein
 */
public class ParserModifyXML extends ParserXML{
    /**
     * Método que obtiene los atributos de los mensajes XML de modificar usuario
     * @param entrada Mensaje XML
     * @return Nombre de Usuario, Contraseña y Nueva Contraseña
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws XPathExpressionException 
     */
    public ArrayList<String> getAtributos(String entrada)throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
        atributosArrayList.add(getAtributo(entrada, "USERNAME"));
        atributosArrayList.add(getAtributo(entrada, "PASSWORD"));
        atributosArrayList.add(getAtributo(entrada, "NEW-PASS"));
        return atributosArrayList;
    }
}
