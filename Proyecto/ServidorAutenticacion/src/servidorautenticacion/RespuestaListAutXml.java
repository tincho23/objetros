/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

/**
 * Clase que genera respuesta en formato XML a los mensajes del  tipo Listar Autenticaciones
 * @author Blanco - Matus - Herlein
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class RespuestaListAutXml {
    /**
     * Método que genera las respuestas XML a los mensajes del tipo Listar Usuarios
     * @param tabla Lista de Autenticaciones
     * @return Mensaje XML
     * @throws SQLException 
     */
    public static String generarXmlListAut(ResultSet tabla) throws SQLException{
      DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String mensaje="<LIST-AUT>";
        while(tabla.next()){
            System.out.println( tabla.getString("host"));
            mensaje=mensaje+"<AUT><HOST>"+tabla.getString("host")+"</HOST><TIMESTAMP>"+format.format(tabla.getTimestamp("timestamp"))+"</TIMESTAMP>"+"</AUT>";
        }
        mensaje = mensaje + "</LIST-AUT>"; 
        return mensaje;
  }
}
 