/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorautenticacion;

import java.io.IOException;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            
      //      System.out.println(tipo);
            return tipo;
      } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
          System.out.println("Error: " + e);
          return null;
      }
    }
    public String respuesta(String datos) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, SQLException{   
      String tipo=getTipo(datos);
      System.out.println(tipo);
        if (tipo.equals("ADD")){
            ArrayList<String> atributosAdd=new ParserAddXML().getAtributos(datos);
            boolean resultadoAccion=new Mapper().add(atributosAdd.get(0), atributosAdd.get(1));
            String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
            return respuesta;
        }
        if (tipo.equals("REMOVE")){
            ArrayList<String> atributosAdd=new ParserRemoveXML().getAtributos(datos);
            boolean resultadoAccion=new Mapper().remove(atributosAdd.get(0));
            String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
            return respuesta; 
        }
        if (tipo.equals("MODIFY")){
            ArrayList<String> atributosAdd=new ParserModifyXML().getAtributos(datos);
            boolean resultadoAccion=new Mapper().modify(atributosAdd.get(0),atributosAdd.get(1),atributosAdd.get(2));
            String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
            return respuesta;
        }
         if (tipo.equals("AUTHENTICATE")){
            ArrayList<String> atributosAdd=new ParserAutXML().getAtributos(datos);
            boolean resultadoAccion=new Mapper().autenticar(atributosAdd.get(0), atributosAdd.get(1), "ip");
            String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
            System.out.println("hola");
            return respuesta;
            
        }
         if (tipo.equals("LIST-USERS")){ //revisar
     //       ArrayList<String> atributosAdd=new ParserListUsersXML().getAtributos(datos);
            ResultSet resultadoAccion=new Mapper().listUsers();
            String respuesta = new RespuestaListUsersXML().generarXmlListUsers(resultadoAccion);
            return respuesta;
            
        }
         if (tipo.equals("LIST-AUT")){
            
        }
        return null;
      
    }
}
    
   
    
   
   
    
   

        


