package es.uco.practica2.business;

import es.uco.practica2.data.dao.ReservaDAO;

import java.util.Date;
import java.util.List;

public class GestorReservas {
	
	private List<ReservasDTO> reservas;
    private ReservaDAO reservaDAO = new ReservaDAO();
	
	public ReservasDTO crearReservaIndividual(Date fecha,int duracion,int id_pista,float precio,float descuento,int tipo_reserva,int num_ninios,int num_adultos, String correo)
	{
		ReservasDTO reserva = new ReservasDTO(fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,-1,-1);
		reservaDAO.crearReservaIndividual(reserva,correo);
		return reserva;
	}
	
	public ReservasDTO crearReservaBono(Date fecha,int duracion,int id_pista,float precio,float descuento,int tipo_reserva,int num_ninios,int num_adultos,int id_bono, String correo)
	{
		ReservasDTO reserva = new ReservasDTO(fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,-1);
		reservaDAO.crearReservaBono(reserva,correo);
		return reserva;
	}
	
	public boolean modificarReserva(Date fecha,int duracion,int id_pista,float precio,float descuento,int tipo_reserva,int num_ninios,int num_adultos)
	{
		if( duracion >= 1 && id_pista >= 0 && num_ninios >= 0 && num_adultos >= 0)
		{
			ReservasDTO reserva = new ReservasDTO(fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,-1,-1);
			reservaDAO.modificarReserva(reserva);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean cancelarReserva(int id_pista, Date fecha)
	{
		if(id_pista >= 0)
		{
			ReservasDTO reserva = new ReservasDTO(fecha,-1,id_pista,-1,-1,-1,-1,-1,-1,-1);
			reservaDAO.cancelarReserva(reserva);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int contarReservasFuturas()
	{
		reservas = reservaDAO.listarReservasFuturas();
		return reservas.size();
	}
	
	public List<ReservasDTO> consultarReservasFuturas()
	{
		reservas = reservaDAO.listarReservasFuturas();
		return reservas;
	}
	
	public ReservasDTO consultarReserva(int id_pista, Date fecha)
	{
		ReservasDTO reserva = new ReservasDTO(fecha,-1,id_pista,-1,-1,-1,-1,-1,-1,-1);
		reserva = reservaDAO.consultarReserva(reserva);
		return reserva;
	}
}
