package es.uco.practica1;

import java.util.Date;

public class ReservaIndividualFactory extends ReservaTypeFactory 
{
	@Override
	public ReservaInfantil createReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int ninios)
	{
		ReservaInfantil reserva = new ReservaInfantil(id,duracion,idpista,precio,descuento,fecha,ninios);
		return reserva;
	}
	
	@Override
	public ReservaAdultos createReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int participantes)
	{
		ReservaAdultos reserva = new ReservaAdultos(id,duracion,idpista,precio,descuento,fecha,participantes);
		return reserva;
	}
	
	@Override
	public ReservaFamiliar createReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int adultos, int ninios)
	{
		ReservaFamiliar reserva = new ReservaFamiliar(id,duracion,idpista,precio,descuento,fecha,adultos,ninios);
		return reserva;
	}
}
