/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

import static com.sun.deploy.uitoolkit.impl.fx.DeployPerfLogger.timestamp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author JorgeLuis
 */
public class RespuestaListUsersXML extends RespuestaListUsers{
    public static String generarXmlListUsers(ResultSet tabla) throws SQLException{
      DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String mensaje="<LIST-USERS>";
        while(tabla.next()){
            System.out.println( tabla.getString("username"));
            mensaje=mensaje+"<USER><USERNAME>"+tabla.getString("username")+"</USERNAME><TIMESTAMP>"+format.format(tabla.getTimestamp("timestamp"));
        }
        mensaje = mensaje + "</LIST-USERS>"; 
        return mensaje;
  }
}


  
  
