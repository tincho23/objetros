/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package cliente;
import java.net.*;
import java.io.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import org.w3c.dom.*;
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
        
        try{
            Socket socket = new Socket("localhost",3307);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("mensaje cliente");
            System.out.println(in.readLine());     
            
         //   out.println("<MESSAGE TYPE=\"ADD\"><USERNAME>juan</USERNAME><PASSWORD>123456</PASSWORD></MESSAGE>");
         
            
         
        }
        catch (Exception e){ e.printStackTrace(); }
    }
    
}
