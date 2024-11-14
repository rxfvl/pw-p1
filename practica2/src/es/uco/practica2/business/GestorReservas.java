package es.uco.practica2.business;

import es.uco.practica2.business.ReservasDTO;
import es.uco.practica2.data.dao.ReservaDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorReservas {
	
	private List<ReservasDTO> reservas;
    private ReservaDAO reservaDAO;
	
	public void crearReservaIndiviual(int id,Date fecha,int duracion,int id_pista,float precio,float descuento,int tipo_reserva,int num_ninios,int num_adultos,int id_bono)
	{
		
	}
	
	public void crearReservaBono()
	{
		
	}
}
