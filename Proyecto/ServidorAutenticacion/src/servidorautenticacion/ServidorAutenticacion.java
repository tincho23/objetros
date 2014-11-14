/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorautenticacion;
import java.io.*;
import java.net.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;
/**
 *
 * @author Blanco-Matus-Herlein
 */
public class ServidorAutenticacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       ServerSocket servidor = null;
       Socket socket = null;
       PrintWriter out = null;
       BufferedReader in;
       try {
            servidor = new ServerSocket(3307);
            socket = servidor.accept();
            String ip=socket.getRemoteSocketAddress().toString();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String datosEntrada = in.readLine();
            String respuesta=new ParserXML().respuesta(datosEntrada);
            out.println(respuesta);
       } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
