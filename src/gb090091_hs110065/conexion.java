/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb090091_hs110065;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class conexion {
    
    private Connection con;
    
    public conexion()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/GB090091_HS110065","root",""); 
        
       }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar realizar la conexion a la base de datos.\n\nError:" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public boolean loginDoc(String nombre, String pass)
    {
        String query = "select * from usuario where User = '"+nombre +"' AND Password ='"+pass+"' AND IsDocente =1";
        try
        {
            
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                return true;
            }
            con.close();           
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error al intentar insertar los datos.\n\nError:" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);            
        }
        return false;
    }

}   