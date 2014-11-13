/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autentificacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Autentificacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
             String username= "eco",
                    password= "eco123",
                    newpassword="123eco";
             
             ARMAU armau=new ARMAU();
             
             ///INSERTAR
             //armau.add(username, password);
             
             //BORRAR
             //armau.remove(username);
             
             //MODIFICAR
             //armau.modify(username, password, newpassword);
             
             //LISTAR
             armau.list();
             
             
             
        
        
        
        
        
        
        
    }
    
}
