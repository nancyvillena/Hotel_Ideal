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

/**
 *
 * @author nancy
 */
public class HabitacionData {
      
    Conexion conexion;
     Connection con=null;

    public HabitacionData (Conexion conexion) {
        this.conexion= conexion;
      con= conexion.getConexion();//obtengo la conexion a la base de datos 
      
    }
    
    public void guardarHabitacion(Habitacion habitacion){
        try {
            String sql = "INSERT INTO habitacion ( nro_habitacion , piso, estado , id_tipodehabitacion )"
                    + " VALUES ( ? , ? , ? , ? );";

           PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getNumHabitacion());
            statement.setInt(2, habitacion.getPiso());
            statement.setBoolean(3, habitacion.isEstado());
            statement.setInt(4, habitacion.getId_tipodehabitacion().getId_tipodehabitacion());
                       
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();//recorre la base de datos para dar el id

            if (rs.next()) {
                habitacion.setId_habitacion(rs.getInt(1)); //recupero el id
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un habitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una habitacion : " + ex.getMessage());
        }
    }
    
   
     public Habitacion buscarHabitacion(int numHabitacion){
    Habitacion habitacion=null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE nro_habitacion = ? ;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, numHabitacion);
                      
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNumHabitacion(resultSet.getInt("nro_habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
               //  TipoDeHabitacion th=buscarTipoDeHabitacion(resultSet.getInt("id_tipodehabitacion"));
               // habitacion.setId_tipodehabitacion(th);
            }      
            statement.close();
               
        } catch (SQLException ex) {
            System.out.println("Error al buscar una habitacion : " + ex.getMessage());
        }  
        return habitacion;
    }
    
    
    public Habitacion buscarIdHabitacion(int id){
    Habitacion habitacion=null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE id_habitacion = ? ;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
                      
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNumHabitacion(resultSet.getInt("nro_habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                TipoDeHabitacion th=buscarTipoDeHabitacion(resultSet.getInt("id_tipodehabitacion"));
                habitacion.setId_tipodehabitacion(th);
            }      
            statement.close();
               
        } catch (SQLException ex) {
            System.out.println("Error al buscar una habitacion : " + ex.getMessage());
        }  
        return habitacion;
    }
    
    
    
    
    public void borrarHabitacionXNumero(int numero){
        try {
            
            String sql = "DELETE FROM habitacion WHERE nro_habitacion = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, numero);
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una habitacion " + ex.getMessage());
        }
    }
     public void borrarHabitacion(int id){
        try {
            
            String sql = "DELETE FROM habitacion WHERE id_habitacion = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una habitacion " + ex.getMessage());
        }
    }
    
    public TipoDeHabitacion buscarTipoDeHabitacion(int id){
            
        TipoDeHabitacionData thd=new  TipoDeHabitacionData(conexion);
        
        return thd.buscarTipoDeHabitacion(id);
        
    }
    
     public List<Habitacion> obtenerHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
        
        try {
            String sql = "SELECT * FROM habitacion;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion")); 
                habitacion.setNumHabitacion(resultSet.getInt("nro_habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                TipoDeHabitacion th=buscarTipoDeHabitacion(resultSet.getInt("id_tipohabitacion"));
                habitacion.setId_tipodehabitacion(th);
                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }    
        return habitaciones;
    }
    
   
    public void actualizarHabitacion(Habitacion habitacion){
    
        try {
            
            String sql = "UPDATE habitacion SET nro_habitacion = ? , piso = ? , estado = ? , id_tipodehabitacion = ? "
                    + "WHERE id_habitacion = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getNumHabitacion());
            statement.setInt(2, habitacion.getPiso());
            statement.setBoolean(3, habitacion.isEstado());
            statement.setInt(4, habitacion.getId_tipodehabitacion().getId_tipodehabitacion());
            statement.setInt(5, habitacion.getId_habitacion());
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una habitacion : " + ex.getMessage());
        }
    }
    
    
    
    
}
