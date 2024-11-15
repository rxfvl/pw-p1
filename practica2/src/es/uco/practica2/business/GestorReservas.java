package es.uco.practica2.business;

import es.uco.practica2.business.ReservasDTO;
import es.uco.practica2.data.dao.ReservaDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorReservas {
	
	private List<ReservasDTO> reservas;
    private ReservaDAO reservaDAO;
	
	public ReservasDTO crearReservaIndiviual(Date fecha,int duracion,int id_pista,float precio,float descuento,int tipo_reserva,int num_ninios,int num_adultos, int id_jugador)
	{
		ReservasDTO reserva = new ReservasDTO(fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,-1,id_jugador);
		reservaDAO.crearReservaIndividual(reserva);
		return reserva;
	}
	
	public ReservasDTO crearReservaBono(Date fecha,int duracion,int id_pista,float precio,float descuento,int tipo_reserva,int num_ninios,int num_adultos,int id_bono, int id_jugador)
	{
		ReservasDTO reserva = new ReservasDTO(fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,id_bono,id_jugador);
		reservaDAO.crearReservaBono(reserva);
		return reserva;
	}
	
	public boolean modificarReserva(int id,Date fecha,int duracion,int id_pista,float precio,float descuento,int tipo_reserva,int num_ninios,int num_adultos)
	{
		if(id >= 0 && duracion >= 1 && id_pista >= 0 && precio > 0.0 && descuento > 0.0 && tipo_reserva >= 0 && tipo_reserva <= 2 && num_ninios >= 0 && num_adultos >= 0)
		{
			ReservasDTO reserva = new ReservasDTO(fecha,duracion,id_pista,precio,descuento,tipo_reserva,num_ninios,num_adultos,-1,-1);
			reservaDAO.modificarReserva(reserva,id);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean cancelarReserva(int id)
	{
		if(id >= 0)
		{
			reservaDAO.cancelarReserva(id);
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
	
	public ReservasDTO consultarReserva(int id_jugador)
	{
		JugadorDTO jugador = new JugadorDTO(id_jugador,"","",null,null,"");
		ReservasDTO reserva = new ReservasDTO();
		reserva = reservaDAO.consultarReserva(jugador);
		return reserva;
	}
}
