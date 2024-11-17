package es.uco.practica2.data.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
//import com.mysql.jdbc.ResultSet;
import es.uco.practica2.business.*;
import es.uco.practica2.data.common.DBConnection;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

public class PistaDAO {
	
	private Properties propiedades = new Properties();
	
		public PistaDAO()
		{
			try (InputStream input = new FileInputStream("sql.properties")) 
			{
				this.propiedades.load(input);
			} catch (IOException ex) 
			{
				System.out.println("Error al cargar las propiedades: " + ex.getMessage());
				return;
		}
	}
	public int crearPista(PistaDTO pista)
	{
		int cont = 0, status = -1;
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(this.propiedades.getProperty("crearPistSelect"));
			stmt.setString(1, pista.getNombre());
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.next())
			{
				PreparedStatement ps = con.prepareStatement(this.propiedades.getProperty("crearPistInsert"));
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
			ResultSet rs = stmt.executeQuery(this.propiedades.getProperty("listPistSelect"));
			
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
				
			PreparedStatement ps = con.prepareStatement(this.propiedades.getProperty("borrarPistDelete"));
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
