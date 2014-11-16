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
 * Clase que controla la lógica de la funcionalidad XML del servidor
 * Comanda el parseo de los mensajes y la generación de la respuestas a ellos
 * @author Blanco - Matus - Herlein
 */
public class ParserXML implements Runnable {
    

    /**
     * Método que obtiene el tipo de mensaje 
     * @param entrada Mensaje XML
     * @return Tipo de mensaje
     */
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
    
    /**
     * Método que coordina la generación de la respuesta
     * @param datos Mensaje XML
     * @param ip Dirección IP del host que envía el mensaje
     * @param passAdmin Contraseña de administrador
     * @return Respuesta
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws XPathExpressionException
     * @throws SQLException 
     */
    public String respuesta(String datos, String ip, String passAdmin) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, SQLException{   
      String tipo=getTipo(datos);
      System.out.println(tipo);
        if (tipo.equals("ADD")){
            ArrayList<String> atributosAdd=new ParserAddXML().getAtributos(datos);
            ArrayList<String> resultadoAccion;
            if (!passAdmin.equals(atributosAdd.get(2))){
                ArrayList<String> error=new ArrayList<>();
                error.add("ERROR");
                error.add("Contraseña de administrador incorrecta");
                String respuesta = new RespuestaABMAXML().generarXmlABMA(error);
                return respuesta;
            }else{
                resultadoAccion = new Mapper().add(atributosAdd.get(0), atributosAdd.get(1));
                String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
                return respuesta;
            }
        }
        if (tipo.equals("REMOVE")){
            ArrayList<String> atributosAdd=new ParserRemoveXML().getAtributos(datos);
            if (!passAdmin.equals(atributosAdd.get(1))){
                ArrayList<String> error=new ArrayList<>();
                error.add("ERROR");
                error.add("Contraseña de administrador incorrecta");
                String respuesta = new RespuestaABMAXML().generarXmlABMA(error);
                return respuesta;
            }else{
                ArrayList<String> resultadoAccion=new Mapper().remove(atributosAdd.get(0));
                String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
                return respuesta;
            }
        }
        if (tipo.equals("MODIFY")){
            ArrayList<String> atributosAdd=new ParserModifyXML().getAtributos(datos);
            ArrayList<String> resultadoAccion=new Mapper().modify(atributosAdd.get(0),atributosAdd.get(1),atributosAdd.get(2));
            String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
            return respuesta;
        }
         if (tipo.equals("AUTHENTICATE")){
            ArrayList<String> atributosAdd=new ParserAutXML().getAtributos(datos);
            ArrayList<String> resultadoAccion=new Mapper().autenticar(atributosAdd.get(0), atributosAdd.get(1), ip);
            String respuesta = new RespuestaABMAXML().generarXmlABMA(resultadoAccion);
            return respuesta;
            
        }
         if (tipo.equals("LIST-USERS")){ //revisar
            ArrayList<String> atributosAdd=new ParserListUsersXML().getAtributos(datos);
            if (!passAdmin.equals(atributosAdd.get(0))){
                ArrayList<String> error=new ArrayList<>();
                error.add("ERROR");
                error.add("Contraseña de administrador incorrecta");
                String respuesta = new RespuestaABMAXML().generarXmlABMA(error);
                return respuesta;
            }else{
                ResultSet resultadoAccion=new Mapper().listUsers();
                String respuesta = RespuestaListUsersXML.generarXmlListUsers(resultadoAccion);
                return respuesta;
            }
            
        }
         if (tipo.equals("LIST-AUT")){
            ArrayList<String> atributosAdd=new ParserListAutXML().getAtributos(datos);
            if (!passAdmin.equals(atributosAdd.get(1))){
                ArrayList<String> error=new ArrayList<>();
                error.add("ERROR");
                error.add("Contraseña de administrador incorrecta");
                String respuesta = new RespuestaABMAXML().generarXmlABMA(error);
                return respuesta;
            }else{
                ResultSet resultadoAccion=new Mapper().listAut(atributosAdd.get(0));
                String respuesta = RespuestaListAutXml.generarXmlListAut(resultadoAccion);
                return respuesta;
            }
            
        }
        return null;
      
    }

    @Override
    /**
     * Convierte todos los métodos de la clase a abstractos
     */
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
    
   
    
   
   
    
   

        


