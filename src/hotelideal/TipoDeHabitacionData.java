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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nancy
 */
public class TipoDeHabitacionData {
   
    Connection con=null;

    public TipoDeHabitacionData (Conexion conexion) {
        try {
            con= conexion.getConexion();//obtengo la conexion a la base de datos 
        } catch (SQLException ex) {
            Logger.getLogger(TipoDeHabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void guardarTipoDeHabitacion(TipoDeHabitacion tipoDeHabitacion){
        try {
            
            String sql = "INSERT INTO tipodehabitacion ( codigo, tipo, precioxnoche, cantmaxpersonas, cantcamas, tipodecamas ) VALUES ( ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, tipoDeHabitacion.getCodigo());
            statement.setString(2, tipoDeHabitacion.getTipo());
            statement.setDouble(3, tipoDeHabitacion.getPrecioxnoche());
            statement.setInt(4, tipoDeHabitacion.getCantmaxpersonas());
            statement.setInt(5, tipoDeHabitacion.getCantcamas());
            statement.setString(6, tipoDeHabitacion.getTipodecama());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                tipoDeHabitacion.setId_tipodehabitacion(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un tipo de Habitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipo de Habitacion : " + ex.getMessage());
        }
    }
    
      
    
    
    public void borrarTipoDeHabitacionXCodigo(int codigo){
    try {
            
            String sql = "DELETE FROM tipodehabitacion WHERE codigo =?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, codigo);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un tipo de Habitacion: " + ex.getMessage());
        }
        
    
    }
    
     public void borrarTipoDeHabitacion(int id){
    try {
            
            String sql = "DELETE FROM tipodehabitacion WHERE id_tipodehabitacion =?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un tipo de Habitacion: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarTipoDeHabitacion(TipoDeHabitacion tipoDeHabitacion){
    
        try {
            
            String sql = "UPDATE tipodehabitacion SET codigo = ?, tipo = ?, precioxnoche = ? , cantmaxpersonas = ? , cantcamas = ? , tipodecamas = ? WHERE id_tipodehabitacion = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
             statement.setInt(1, tipoDeHabitacion.getCodigo());
            statement.setString(2, tipoDeHabitacion.getTipo());
            statement.setDouble(3, tipoDeHabitacion.getPrecioxnoche());
            statement.setInt(4, tipoDeHabitacion.getCantmaxpersonas());
            statement.setInt(5, tipoDeHabitacion.getCantcamas());
            statement.setString(6, tipoDeHabitacion.getTipodecama());
            statement.setInt(7, tipoDeHabitacion.getId_tipodehabitacion());
            statement.executeUpdate();
    
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar un tipo de Habitacion : " + ex.getMessage());
        }
    
    }
    
    public TipoDeHabitacion buscarTipoDeHabitacionXCodigo(int codigo){
    TipoDeHabitacion tipoDeHabitacion=null;
    try {
            
            String sql = "SELECT * FROM tipodehabitacion WHERE codigo =?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, codigo);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                tipoDeHabitacion = new TipoDeHabitacion();
                tipoDeHabitacion.setId_tipodehabitacion(resultSet.getInt("id_tipodehabitacion"));
                tipoDeHabitacion.setCodigo(resultSet.getInt("codigo"));
                tipoDeHabitacion.setTipo(resultSet.getString("tipo"));
                tipoDeHabitacion.setPrecioxnoche(resultSet.getDouble("precioxnoche"));
                tipoDeHabitacion.setCantmaxpersonas(resultSet.getInt("cantmaxpersonas"));
             tipoDeHabitacion.setCantcamas(resultSet.getInt("cantcamas"));
                tipoDeHabitacion.setTipodecama(resultSet.getString("tipodecamas"));
                
            }      
            statement.close();           
                     
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un tipo de Habitacion : " + ex.getMessage());
        }
        
        return tipoDeHabitacion;
    }
    
     public TipoDeHabitacion buscarTipoDeHabitacion(int id){
    TipoDeHabitacion tipoDeHabitacion=null;
    try {
            
            String sql = "SELECT * FROM tipodehabitacion WHERE id_tipodehabitacion =?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                tipoDeHabitacion = new TipoDeHabitacion();
                tipoDeHabitacion.setId_tipodehabitacion(resultSet.getInt("id_tipodehabitacion"));
                tipoDeHabitacion.setCodigo(resultSet.getInt("codigo"));
                tipoDeHabitacion.setTipo(resultSet.getString("tipo"));
                tipoDeHabitacion.setPrecioxnoche(resultSet.getDouble("precioxnoche"));
                tipoDeHabitacion.setCantmaxpersonas(resultSet.getInt("cantmaxpersonas"));
                tipoDeHabitacion.setCantcamas(resultSet.getInt("cantcamas"));
                tipoDeHabitacion.setTipodecama(resultSet.getString("tipodecamas"));
                
            }      
            statement.close();
                 
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un tipo de Habitacion : " + ex.getMessage());
        }
        
        return tipoDeHabitacion;
    }
    
     
    public List<TipoDeHabitacion> obtenerTipoDeHabitaciones(){
        List<TipoDeHabitacion> tipoDeHabitaciones = new ArrayList<TipoDeHabitacion>();
            

        try {
            String sql = "SELECT * FROM tipodehabitacion;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoDeHabitacion tipoDeHabitacion;
            while(resultSet.next()){
                tipoDeHabitacion = new TipoDeHabitacion();
                tipoDeHabitacion.setId_tipodehabitacion(resultSet.getInt("id_tipodehabitacion"));
                tipoDeHabitacion.setCodigo(resultSet.getInt("codigo"));
                tipoDeHabitacion.setTipo(resultSet.getString("tipo"));
                tipoDeHabitacion.setPrecioxnoche(resultSet.getDouble("precioxnoche"));
                tipoDeHabitacion.setCantmaxpersonas(resultSet.getInt("cantmaxpersonas"));
                tipoDeHabitacion.setCantcamas(resultSet.getInt("cantcamas"));
                tipoDeHabitacion.setTipodecama(resultSet.getString("tipodecamas"));
                
    
                tipoDeHabitaciones.add(tipoDeHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tipo de Habitacion: " + ex.getMessage());
        }
        
        
        return tipoDeHabitaciones;
    }
    
    
    
    
    
    
}