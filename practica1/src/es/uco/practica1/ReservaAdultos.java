package es.uco.practica1;

import java.util.Date;

public class ReservaAdultos extends Reserva
{
	//Parametros reserva adultos
	private int participantes;
		
	//Metodos reserva adultos
	public ReservaAdultos()
	{
		super();
		this.participantes=-1;
	}
	public ReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int participantes)
	{
		super(id,duracion,idpista,precio,descuento,fecha);
		this.participantes=participantes;
	}
	
	public int getParticipantes()
	{
		return participantes;
	}
	public void setParticipantes(int participantes)
	{
		this.participantes=participantes;
	}
		
	@Override
	public String toString() {
		return "ReservaAdultos [participantes=" + participantes + ", getParticipantes()=" + getParticipantes()
				+ ", getId()=" + getId() + ", getFecha()=" + getFecha() + ", getDuracion()=" + getDuracion()
				+ ", getIdPista()=" + getIdPista() + ", getPrecio()=" + getPrecio() + ", getDescuento()="
				+ getDescuento() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}
