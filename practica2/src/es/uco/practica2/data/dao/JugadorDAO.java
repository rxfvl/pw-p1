package es.uco.practica2.data.dao;

import es.uco.practica2.business.JugadorDTO;
import es.uco.practica2.data.common.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

public class JugadorDAO {
	
    public int addJugador(JugadorDTO jugador)
    {
        String sql = "INSERT INTO jugadores (nombre, apellidos, fecha_nacimiento, fecha_inscripcion, correo_electronico) VALUES (?, ?, ?, ?, ?)";
        try{
        	DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
			
			PreparedStatement stmtsel = con.prepareStatement("select * from jugadores where correo_electronico = ?");
			stmtsel.setString(1, jugador.getCorreo_electronico());
			ResultSet rs = stmtsel.executeQuery();
			
			if(!rs.next())
			{
				PreparedStatement stmt = con.prepareStatement(sql);
	        	
	            stmt.setString(1, jugador.getNombre());
	            stmt.setString(2, jugador.getApellidos());
	            stmt.setDate(3, new java.sql.Date(jugador.getFecha_nacimiento().getTime()));
	            stmt.setDate(4, java.sql.Date.valueOf(jugador.getFecha_inscripcion()));
	            stmt.setString(5, jugador.getCorreo_electronico());
	            return stmt.executeUpdate();
			}
			else {return 0;}
        	
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateJugador(JugadorDTO jugador) {
        String sql = "UPDATE jugadores SET nombre = ?, apellidos = ?, fecha_nacimiento = ? WHERE correo_electronico = ?";
        try{
        	DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, jugador.getNombre());
	        stmt.setString(2, jugador.getApellidos());
	        stmt.setDate(3, new java.sql.Date(jugador.getFecha_nacimiento().getTime()));
	        stmt.setString(4, jugador.getCorreo_electronico());
	        return stmt.executeUpdate();
			
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteJugador(JugadorDTO jugador) {
        try{
        	int status = 0;
			
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
				
			PreparedStatement ps = con.prepareStatement("delete from jugadores where correo_electronico = ?");
			ps.setString(1,jugador.getCorreo_electronico());
				
			status=ps.executeUpdate();
				
			return status;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<JugadorDTO> getAllJugadores() {
        List<JugadorDTO> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM jugadores";
        try {
        	DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
        	PreparedStatement stmt = con.prepareStatement(sql);
        	
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
			{
            	String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Date fechaN = rs.getDate("fecha_nacimiento");
                Date fechaI = rs.getDate("fecha_inscripcion");
                LocalDate fechaIns = fechaI.toLocalDate();
                String correo = rs.getString("correo_electronico");
                jugadores.add(new JugadorDTO(nombre, apellidos, fechaN, fechaIns, correo));
			}
			if (stmt != null) {stmt.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }
}
