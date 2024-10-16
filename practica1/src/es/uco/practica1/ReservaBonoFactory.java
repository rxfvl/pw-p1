package es.uco.practica1;

import java.util.Date;

public class ReservaBonoFactory extends ReservaTypeFactory
{
	
	public ReservaInfantil createReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int ninios)
	{
		return new ReservaInfantil(id,duracion,idpista,precio,descuento,fecha,ninios);
	}
	
	public ReservaAdultos createReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int participantes)
	{
		return new ReservaAdultos(id,duracion,idpista,precio,descuento,fecha,participantes);
	}
	
	public ReservaFamiliar createReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int adultos, int ninios)
	{
		return new ReservaFamiliar(id,duracion,idpista,precio,descuento,fecha,adultos,ninios);
	}
}
