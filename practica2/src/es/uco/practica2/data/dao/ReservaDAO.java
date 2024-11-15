package es.uco.practica2.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uco.practica2.business.*;
import es.uco.practica2.data.common.DBConnection;

public class ReservaDAO {
	public void crearReservaIndividual(ReservasDTO reserva)
	{
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = null;
			switch(reserva.getTipo_reserva())
			{
				case 0:	//adultos
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador) values(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, reserva.getId());	
					ps.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
					ps.setInt(3, reserva.getDuracion());
					ps.setInt(4, reserva.getId_pista());
					ps.setFloat(5, reserva.getPrecio());
					ps.setFloat(6, reserva.getDescuento());	
					ps.setInt(7, reserva.getTipo_reserva());
					ps.setInt(8, 0);
					ps.setInt(9, reserva.getNum_adultos());
					ps.setNull(10, Types.INTEGER);
					ps.setInt(11, reserva.getId_jugador());
					ps.executeUpdate();
				break;
				
				case 1:	//infantil
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador) values(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, reserva.getId());	
					ps.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
					ps.setInt(3, reserva.getDuracion());
					ps.setInt(4, reserva.getId_pista());
					ps.setFloat(5, reserva.getPrecio());
					ps.setFloat(6, reserva.getDescuento());	
					ps.setInt(7, reserva.getTipo_reserva());
					ps.setInt(8, reserva.getNum_ninios());
					ps.setInt(9, 0);
					ps.setNull(10, Types.INTEGER);
					ps.setInt(11, reserva.getId_jugador());
					ps.executeUpdate();
				break;
				
				case 2:	//familiar
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador) values(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, reserva.getId());	
					ps.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
					ps.setInt(3, reserva.getDuracion());
					ps.setInt(4, reserva.getId_pista());
					ps.setFloat(5, reserva.getPrecio());
					ps.setFloat(6, reserva.getDescuento());	
					ps.setInt(7, reserva.getTipo_reserva());
					ps.setInt(8, reserva.getNum_ninios());
					ps.setInt(9, reserva.getNum_adultos());
					ps.setNull(10, Types.INTEGER);
					ps.setInt(11, reserva.getId_jugador());
					ps.executeUpdate();
				break;
				
				default:
					System.out.println("Opción no válida.");
			}	
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void crearReservaBono(ReservasDTO reserva)
	{
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = null;
			switch(reserva.getTipo_reserva())
			{
				case 0:	//adultos
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador) values(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, reserva.getId());	
					ps.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
					ps.setInt(3, reserva.getDuracion());
					ps.setInt(4, reserva.getId_pista());
					ps.setFloat(5, reserva.getPrecio());
					ps.setFloat(6, reserva.getDescuento());	
					ps.setInt(7, reserva.getTipo_reserva());
					ps.setInt(8, 0);
					ps.setInt(9, reserva.getNum_adultos());
					ps.setInt(10, reserva.getId_bono());
					ps.setInt(11, reserva.getId_jugador());
					ps.executeUpdate();
				break;
				
				case 1:	//infantil
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador) values(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, reserva.getId());	
					ps.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
					ps.setInt(3, reserva.getDuracion());
					ps.setInt(4, reserva.getId_pista());
					ps.setFloat(5, reserva.getPrecio());
					ps.setFloat(6, reserva.getDescuento());	
					ps.setInt(7, reserva.getTipo_reserva());
					ps.setInt(8, reserva.getNum_ninios());
					ps.setInt(9, 0);
					ps.setInt(10, reserva.getId_bono());
					ps.setInt(11, reserva.getId_jugador());
					ps.executeUpdate();
				break;
				
				case 2:	//familiar
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador) values(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, reserva.getId());	
					ps.setDate(2, new java.sql.Date(reserva.getFecha().getTime()));
					ps.setInt(3, reserva.getDuracion());
					ps.setInt(4, reserva.getId_pista());
					ps.setFloat(5, reserva.getPrecio());
					ps.setFloat(6, reserva.getDescuento());	
					ps.setInt(7, reserva.getTipo_reserva());
					ps.setInt(8, reserva.getNum_ninios());
					ps.setInt(9, reserva.getNum_adultos());
					ps.setInt(10, reserva.getId_bono());
					ps.setInt(11, reserva.getId_jugador());
					ps.executeUpdate();
				break;
				
				default:
					System.out.println("Opción no válida.");
			}	
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void modificarReserva(ReservasDTO reserva, int id)
	{
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement("UPDATE reservas SET fecha = ?, duracion = ?, id_pista = ?, precio = ?, descuento = ?, tipo_reserva = ?, num_ninios = ?, num_adultos = ?, WHERE id = ?");
			ps.setDate(1, new java.sql.Date(reserva.getFecha().getTime()));
			ps.setInt(2, reserva.getDuracion());
			ps.setInt(3, reserva.getId_pista());
			ps.setFloat(4, reserva.getPrecio());
			ps.setFloat(5, reserva.getDescuento());	
			ps.setInt(6, reserva.getTipo_reserva());
			ps.setInt(7, reserva.getNum_ninios());
			ps.setInt(8, reserva.getNum_adultos());
			ps.setInt(9, id);
			ps.executeUpdate();
				
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void cancelarReserva(int id)
	{
		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement("DELETE FROM reservas WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
				
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public List<ReservasDTO> listarReservasFuturas()
	{
		List<ReservasDTO> reservas = new ArrayList<>();

		try{
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reservas WHERE fecha > "+ LocalDate.now());
			
			while(rs.next())
			{
				Date fecha = rs.getDate("fecha");
				int duracion = rs.getInt("duracion");
				int id_pista = rs.getInt("id_pista");
				float precio = rs.getFloat("precio");
				float descuento = rs.getFloat("descuento");
				int tipo_reserva = rs.getInt("tipo_reserva");
				int num_ninios = rs.getInt("num_ninios");
				int num_adultos = rs.getInt("num_adultos");
				int id_bono = rs.getInt("id_bono");
				int id_jugador = rs.getInt("id_jugador");
				ReservasDTO reserva = new ReservasDTO(fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador);
				reservas.add(reserva);
			}
			if (stmt != null) {stmt.close();}
			
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		
		return reservas;
	}
	
	public ReservasDTO consultarReserva(JugadorDTO jugador)
	{
		ReservasDTO reserva = new ReservasDTO();
		ResultSet select;
		try {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
		
			String selectQuery = "select * from reservas where id_jugador = ?";
			
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, jugador.getId());
			select = ps.executeQuery();
			
			if (select.next())
			{
				reserva.setFecha(select.getDate("fecha"));
				reserva.setDuracion(select.getInt("duracion"));
				reserva.setId_pista(select.getInt("id_pista"));
				reserva.setPrecio(select.getFloat("precio"));
				reserva.setDescuento(select.getFloat("descuento"));
				reserva.setTipo_reserva(select.getInt("tipo_reserva"));
				reserva.setNum_ninios(select.getInt("nun_ninios"));
				reserva.setNum_adultos(select.getInt("num_adutlos"));
				reserva.setId_bono(select.getInt("id_bono"));
				reserva.setId_jugador(select.getInt("id_jugador"));
			}
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		return reserva;
	}
}
