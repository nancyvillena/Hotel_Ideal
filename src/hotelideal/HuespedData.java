/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nancy
 */
public class HuespedData {
    
     Connection con=null;

    public  HuespedData (Conexion conexion) {
         try {
             con= conexion.getConexion();//obtengo la conexion a la base de datos
         } catch (SQLException ex) {
             Logger.getLogger(HuespedData.class.getName()).log(Level.SEVERE, null, ex);
         }
    
}
    
  public void guardarHuesped(Huesped huesped){
        try {
            
            String sql = "INSERT INTO huesped ( nombre , dni , domicilio , correo , celular )"
                    + " VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4,huesped.getCorreo());
            statement.setLong(5, huesped.getCelular());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                huesped.setId_huesped(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un huesped");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
    }
    
   
    public List<Huesped> obtenerHuespedes(){
        List<Huesped> huespedes = new ArrayList<Huesped>();

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped")); 
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getLong("celular"));
    
                huespedes.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes: " + ex.getMessage());
        }
        return huespedes;
    }
    
    
    public void borrarHuespedXDni(int dni){
        try {
            
            String sql = "DELETE FROM huesped WHERE dni = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    }
    
     public void borrarHuesped(int id_huesped){
        try {
            
            String sql = "DELETE FROM huesped WHERE id_huesped = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_huesped);
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    }
    
   
    public void actualizarHuesped(Huesped huesped){
    
        try {
            
            String sql = "UPDATE huesped SET nombre = ?, dni = ? , domicilio = ? , correo = ? , celular = ? WHERE id_huesped = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4, huesped.getCorreo());
            statement.setLong(5, huesped.getCelular());
            statement.setInt(6, huesped.getId_huesped());
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
    }
    
   
    public Huesped buscarHuespedXDni(int dni){
    Huesped huesped=null;
    try {
            
            String sql = "SELECT * FROM huesped WHERE dni = ? ;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped"));
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getLong("celular"));
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
        return huesped;
    }
   
    
    public Huesped buscarIdHuesped(int id_huesped){
    Huesped huesped=null;
    try {
            
            String sql = "SELECT * FROM huesped WHERE id_huesped = ? ;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_huesped);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped"));
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getLong("celular"));
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
        return huesped;
    }  
    
}
