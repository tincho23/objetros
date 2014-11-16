/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Clase que genera respuesta en formato XML a los mensajes del  tipo Listar Usuarios 
 * @author Blanco - Matus - Herlein
 */
public class RespuestaListUsersXML{
    /**
     * Método que genera las respuestas XML a los mensajes del tipo Listar Usuarios
     * @param tabla Lista de Usuarios
     * @return Mensaje XML
     * @throws SQLException 
     */
    
    public static String generarXmlListUsers(ResultSet tabla) throws SQLException{
      DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String mensaje="<LIST-USERS>";
        while(tabla.next()){
            System.out.println( tabla.getString("username"));
            mensaje=mensaje+"<USER><USERNAME>"+tabla.getString("username")+"</USERNAME><TIMESTAMP>"+format.format(tabla.getTimestamp("timestamp"))+"</TIMESTAMP>"+"</USER>";
        }
        mensaje = mensaje + "</LIST-USERS>"; 
        return mensaje;
  }
}


  
  
