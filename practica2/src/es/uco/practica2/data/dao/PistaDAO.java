package es.uco.practica2.data.dao;

import java.sql.*;
import com.mysql.jdbc.ResultSet;
import es.uco.practica2.business.*;
import es.uco.practica2.data.common.DBConnection;
import java.util.List;
import java.util.ArrayList;

public class PistaDAO {
	public void crearPista(PistaDTO pista)
	{
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into Pistas (nombre,estado,tipo,tamanio,jugadores_max) values(?,?,?,?,?)");
			ps.setString(1,pista.getNombre());	
			ps.setInt(2, pista.getEstado());
			ps.setInt(3, pista.getTipo());
			ps.setInt(4, pista.getTamanio());
			ps.setInt(5, pista.getJugadores_max());
			
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public List<PistaDTO> ListarPistas()
	{
		List<PistaDTO> lista = new ArrayList<>();
		
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Pistas");
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int estado = rs.getInt("estado");
				int tipo = rs.getInt("tipo");
				int tamanio = rs.getInt("tamanio");
				int jugadores = rs.getInt("jugadores_max");
				PistaDTO pista = new PistaDTO();
				lista.add(pista);
			}
			if (stmt != null) {stmt.close();}
			
			return lista;
			
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public int borrarPista(PistaDTO pista)
	{
		int status = 0;
		
		if(pista.getId() == -1)
		{
			try{
				DBConnection dbConnection = new DBConnection();
				Connection con = dbConnection.getConnection();
				
				PreparedStatement ps = con.prepareStatement("delete from Pistas where nombre=?");
				ps.setString(1,pista.getNombre());
				
				status=ps.executeUpdate();

			}catch(Exception e)
			{
				System.err.println(e);
				e.printStackTrace();
			}
		}
		else
		{
			try{
				DBConnection dbConnection = new DBConnection();
				Connection con = dbConnection.getConnection();
				
				PreparedStatement ps = con.prepareStatement("delete from Pistas where id=?");
				ps.setInt(1,pista.getId());
				
				status=ps.executeUpdate();
				
			}catch(Exception e)
			{
				System.err.println(e);
				e.printStackTrace();
			}
		}
		
		return status;
	}
}
