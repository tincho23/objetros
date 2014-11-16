/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * @author JorgeLuis
 */
public class ServidorXML implements Runnable{
    private Socket socket;
    private String passAdmin;
   public ServidorXML(Socket socket, String passAdmin){
       this.socket=socket;
       this.passAdmin=passAdmin;
       
   }
    @Override
    public void run() {
        //Obtener direccion IP del host que se conecta al servidor
            SocketAddress remoteaddress = socket.getRemoteSocketAddress();
            String iphost = remoteaddress.toString();
            iphost = iphost.substring(1,iphost.indexOf(":"));
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String datosEntrada = in.readLine();
                String respuesta= new ControlXML().respuesta(datosEntrada,iphost,passAdmin);
                out.println(respuesta);
                in.close();
                out.close();
            
            }catch (Exception e) { e.printStackTrace(); 
            } 
    }
}
        
    
    

