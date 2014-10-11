package autentificacion;

import java.sql.*;
import javax.swing.JOptionPane;

public class clase_Acceso {
    public void acceso(String username, String password){
        Connection conexion;
        Statement consulta;
        ResultSet tabla;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/autenticacion_matus","root","root");
            consulta=conexion.createStatement();
            tabla=consulta.executeQuery("select username, password FROM usuarios WHERE username='"+username+"'AND password='"+password+"'");
            if(tabla.next()){
                JOptionPane.showMessageDialog(null,"Login Correcto");
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrectos");
            }
        }catch(ClassNotFoundException |SQLException e){}
        
    }
}
