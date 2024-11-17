package es.uco.practica2.data.dao;

import java.sql.*;
//import com.mysql.jdbc.ResultSet;
import es.uco.practica2.business.*;
import es.uco.practica2.data.common.DBConnection;
import java.util.List;
import java.util.ArrayList;

public class PistaDAO {
	public int crearPista(PistaDTO pista)
	{
		int status = -1;
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			
			PreparedStatement stmt = con.prepareStatement("select * from pistas where nombre = ?");
			stmt.setString(1, pista.getNombre());
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.next())
			{
				PreparedStatement ps = con.prepareStatement("insert into pistas (nombre,estado,tipo,tamanio,jugadores_max) values(?,?,?,?,?)");
				ps.setString(1,pista.getNombre());	
				ps.setInt(2, pista.getEstado());
				ps.setInt(3, pista.getTipo());
				ps.setInt(4, pista.getTamanio());
				ps.setInt(5, pista.getJugadores_max());
				
				status = ps.executeUpdate();
			}
			
			return status;
			
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
			return -1; // CUIDADO
		}
	}
	
	public List<PistaDTO> ListarPistas()
	{
		List<PistaDTO> lista = new ArrayList<>();
		
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from pistas");
			
			while(rs.next())
			{
				String nombre = rs.getString("nombre");
				int estado = rs.getInt("estado");
				int tipo = rs.getInt("tipo");
				int tamanio = rs.getInt("tamanio");
				int jugadores = rs.getInt("jugadores_max");
				PistaDTO pista = new PistaDTO(nombre, estado, tipo, tamanio, jugadores);
				lista.add(pista);
			}
			if (stmt != null) {stmt.close();}
			
			return lista;
			
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
			return null; //CUIDADO
		}
	}
	
	public int borrarPista(PistaDTO pista)
	{
		try{
			int status = 0;
				
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
				
			PreparedStatement ps = con.prepareStatement("delete from pistas where nombre=?");
			ps.setString(1,pista.getNombre());
				
			status=ps.executeUpdate();
				
			return status;

		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
			return -1;
		}		
	}
}
