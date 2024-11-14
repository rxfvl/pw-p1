package es.uco.practica2.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import es.uco.practica2.business.ReservasDTO;
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
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono) values(?,?,?,?,?,?,?,?,?,?)");
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
				break;
				
				case 1:	//infantil
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono) values(?,?,?,?,?,?,?,?,?,?)");
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
				break;
				
				case 2:	//familiar
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono) values(?,?,?,?,?,?,?,?,?,?)");
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
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono) values(?,?,?,?,?,?,?,?,?,?)");
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
				break;
				
				case 1:	//infantil
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono) values(?,?,?,?,?,?,?,?,?,?)");
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
				break;
				
				case 2:	//familiar
					ps = con.prepareStatement("insert into Reservas (id,fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono) values(?,?,?,?,?,?,?,?,?,?)");
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
	
	public void modificarReserva(ReservasDTO reserva)
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
			ps.setInt(9, reserva.getId());
			ps.executeUpdate();
				
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
