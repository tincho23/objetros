/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package cliente;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import servidorautenticacion.Mapper;
import servidorautenticacion.ParserMensaje;


/**
 *
 * @author Tincho
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       PrintWriter out;
       BufferedReader in;
        /*ParserMensaje d=new ParserMensaje();
        ArrayList<String> resultado = new ArrayList<>();
        System.out.println("resultado: "+resultado);
        
        
          
            ArrayList<String> parsermensaje=new 
                */
   //     resultado =d.Add("fsd", "dsa");
        
       
   //     ArrayList<String>resultado =new ArrayList<>();
   //     servidorautenticacion.Mapper d = new servidorautenticacion.Mapper();
        
   //     resultado=d.add("fds", "fdsfd");
        
  //192.168.0.2
        try{
           Socket socket = new Socket("localhost",3307);
           out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          //out.println("mensaje cliente");
            
  //          Path path = FileSystems.getDefault().getPath(filePath);
  //          Files.copy(path, socket.getOutputStream());
  //          socket.shutdownOutput();
            
            
                
            
 //           out.println("<MESSAGE TYPE=\"ADD\"><USERNAME>juan</USERNAME><PASSWORD>123456</PASSWORD><ADM-PASS>root</ADM-PASS></MESSAGE>");
           // out.println("<MESSAGE TYPE=\"REMOVE\"><USERNAME>juan</USERNAME><ADM-PASS>root</ADM-PASS></MESSAGE>");
            //out.println("<MESSAGE TYPE=\"MODIFY\"><USERNAME>juaan</USERNAME><PASSWORD>123456</PASSWORD><NEW-PASS>root</NEW-PASS></MESSAGE>");
        out.println("<MESSAGE TYPE=\"LIST-USERS\"><ADM-PASS>2</ADM-PASS></MESSAGE>");
     //       out.println("<MESSAGE TYPE=\"LIST-AUT\"><USERNAME>petiza</USERNAME><ADM-PASS></ADM-PASS></MESSAGE>");
       //  out.println("<MESSAGE TYPE=\"AUTHENTICATE\"><USERNAME>petiza</USERNAME><PASSWORD>tepartooalmedio</PASSWORD></MESSAGE>");
            System.out.println(in.readLine()); 
         
        }
        catch (Exception e){ 
            
            e.printStackTrace();
            System.out.println("error: "+e );
        }
    }
    
}
