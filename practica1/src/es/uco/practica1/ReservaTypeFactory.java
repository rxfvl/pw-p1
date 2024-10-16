package es.uco.practica1;

import java.util.Date;

public abstract class ReservaTypeFactory 
{
	//Metodos factory para cada reserva
	public abstract ReservaInfantil createReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int ninios);
	
	public abstract ReservaInfantil createReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int participantes);

	public abstract ReservaInfantil createReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int adultos, int ninios);
}
