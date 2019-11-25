/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nancy
 */
public class ReservaData {
     
    Conexion conexion;
     Connection con=null;

    public ReservaData (Conexion conexion) {
        this.conexion= conexion;
      con= conexion.getConexion();//obtengo la conexion a la base de datos
    
}
    
    
      public void guardarReserva(Reserva reserva){
        try {
            
            String sql = "INSERT INTO reservas ( cantpersonas , fechaentrada , fechasalida , importetotal , estado_reserva ,"
                    + "	fechadereserva, id_habitacion , id_huesped ) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getCantPersonas());
            statement.setDate(2, Date.valueOf(reserva.getFechaEntrada()));
            statement.setDate(3, Date.valueOf(reserva.getFechaSalida()));
            statement.setDouble(4, reserva.getImporteTotal());
            statement.setBoolean(5, reserva.isEstado_reserva()); 
            statement.setDate(6, Date.valueOf(reserva.getFechaDeReserva()));
            statement.setInt (7, reserva.getHabitacion().getId_habitacion());
            statement.setInt (8, reserva.getHuesped().getId_huesped());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                reserva.setId_reserva(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un reserva");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un reserva : " + ex.getMessage());
        }
    }
    
    public void actualizarEstado(boolean estado, int num){
        try {
            
            String sql = "UPDATE habitacion SET estado = ? WHERE nro_habitacion = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, estado);
            statement.setInt(2, num);
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al ACTUALIZAR EL ESTADO DE HABITACION: " + ex.getMessage());
        }
    
    }

    public List<Reserva> obtenerResevas(){
        List<Reserva> reservas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reservas;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva")); 
                reserva.setCantPersonas(resultSet.getInt("cantpersonas"));
                reserva.setFechaEntrada(resultSet.getDate("fechaentrada").toLocalDate());
                reserva.setFechaSalida(resultSet.getDate("fechasalida").toLocalDate());
                reserva.setImporteTotal(resultSet.getDouble("importetotal"));
                reserva.setEstado_reserva(resultSet.getBoolean("estado_reserva"));
                reserva.setFechaDeReserva(resultSet.getDate("fechadereserva").toLocalDate());
                
                Habitacion hab=buscarIdHabitacion(resultSet.getInt("id_habitacion"));
                Huesped hus=buscarHuesped(resultSet.getInt("id_huesped"));
                
                reserva.setHabitacion(hab);
                reserva.setHuesped(hus);
    
                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las Reservas: " + ex.getMessage());
        }
        return reservas;
    }    
    
    public void cancelarReserva(LocalDate numero){
        try {
            
            String sql = "DELETE FROM reservas WHERE  fechaentrada = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(numero));
                        
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al cancelar una Reserva " + ex.getMessage());
        }
    }
    
    public void actualizaReserva(Reserva reserva){
    
        try {
            
            String sql = "UPDATE reservas SET cantpersonas = ? , fechaentrada = ?, fechasalida = ? , importetotal = ?, estado_reserva = ? ,"
                    + " id_habitacion = ? , id_huesped = ? WHERE id_reserva = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getCantPersonas());
            statement.setDate(2, Date.valueOf(reserva.getFechaEntrada()));
            statement.setDate(3, Date.valueOf(reserva.getFechaSalida()));
            statement.setDouble(4, reserva.getImporteTotal());
            statement.setBoolean(5, reserva.isEstado_reserva()); 
            statement.setInt (6, reserva.getHabitacion().getId_habitacion());
            statement.setInt (7, reserva.getHuesped().getId_huesped());
            statement.setInt(8, reserva.getId_reserva());
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un reserva : " + ex.getMessage());
        }
    }
    
    
    public Habitacion buscarIdHabitacion(int id){
            
        HabitacionData hd=new HabitacionData(conexion);
        
        return hd.buscarIdHabitacion(id);
        
    }
    
    public Huesped buscarHuesped(int id_huesped){
            
        HuespedData hud=new HuespedData(conexion);
        
        return hud.buscarIdHuesped(id_huesped);
        
    }
    
    
    
}
