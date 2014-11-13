package autentificacion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Clase de acceso
 * @author Tincho
 */
public class clase_Acceso {
    /**
     * Para el acceso a la base de datos
     * >
     * 
     * @param username Este es el usuario de la base de datos
     * @param password 1Esta es la contraseña del usuario
     */
    public void acceso(String username, String password){
         System.out.println("juancho te cago la petiza");
        Connection conexion;
        Statement consulta;
        ResultSet tabla;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
           
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/autenticaciones","root","");
            System.out.println("a la rubia la parto por 2"); 
            consulta=conexion.createStatement();
            tabla=consulta.executeQuery("select username, password FROM usuarios WHERE username='"+username+"'AND password='"+password+"'");
            
            if(tabla.next()){
                 System.out.println("a la rubia la parto");
                JOptionPane.showMessageDialog(null,"Login Correcto");
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrectos");
            }
        }catch(ClassNotFoundException |SQLException e){}
        
    }
}
