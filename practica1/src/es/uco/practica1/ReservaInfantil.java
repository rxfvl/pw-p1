package es.uco.practica1;

import java.util.Date;

public class ReservaInfantil extends Reserva
{
	//Parametros reserva infantil
	private int ninios;
	
	//Metodos reserva infantil
	public int getNinios()
	{
		return ninios;
	}
	public void setNinios(int ninios)
	{
		this.ninios=ninios;
	}
	
	public ReservaInfantil()
	{
		super();
		this.ninios=-1;
	}
	public ReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int ninios)
	{
		super(id,duracion,idpista,precio,descuento,fecha);
		this.ninios=ninios;
	}
	
}
