package es.uco.practica1;

import java.util.Date;

public class ReservaInfantil extends Reserva
{
	//Parametros reserva infantil
	private int ninios;
	
	//Metodos reserva infantil
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
	public ReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , String idbono, int sesionbono, int ninios)
	{
		super(id,duracion,idpista,precio,descuento,fecha,idbono,sesionbono);
		this.ninios=ninios;
	}
	
	public int getNinios()
	{
		return ninios;
	}
	public void setNinios(int ninios)
	{
		this.ninios=ninios;
	}
	
	@Override
	public String toString() {
		return "ReservaInfantil [ninios=" + ninios + ", getNinios()=" + getNinios() + ", getId()=" + getId()
				+ ", getFecha()=" + getFecha() + ", getDuracion()=" + getDuracion() + ", getIdPista()=" + getIdPista()
				+ ", getPrecio()=" + getPrecio() + ", getDescuento()=" + getDescuento() + ", getIdbono()=" + getIdbono()
				+ ", getSesionBono()=" + getSesionBono() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
