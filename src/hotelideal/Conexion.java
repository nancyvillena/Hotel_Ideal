/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nancy
 */
public class Conexion {
   
   
     private String url= "jdbc:mysql://localhost/hotelideal";
    private String usuario= "root";
    private String password= "";
    private Connection con = null;
    
    public Conexion(){
        
        try {    
            Class.forName("org.mariadb.jdbc.Driver");
             
           } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
}

    public Conexion(String jdbcmysqllocalhosthotelideal, String root, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection getConexion(){
        //DriverManager es el objeto permite cargar el driver del gestor de BD 
      try {
             if (con == null){
             con = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
          System.out.println("Conexion Exitosa!!!!");
             }
         } catch (SQLException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
       return con;}
}


