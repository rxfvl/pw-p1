package es.uco.practica1;

import java.util.Date;

public class ReservaFamiliar extends Reserva
{
	//Parametros reserva familiar
	private int adultos;
	private int ninios;
			
	//Metodos reserva familiar
	public ReservaFamiliar()
	{
		super();
		this.adultos=1;
		this.ninios=-1;
	}
	public ReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int adultos, int ninios)
	{
		super(id,duracion,idpista,precio,descuento,fecha);
		this.adultos=adultos;
		this.ninios=ninios;
		if(adultos<1)
		{
			this.adultos=1;
		}
	}
			
	public int getAdultos()
	{
		return adultos;
	}
	public void setAdultos(int adultos)
	{
		if(adultos<1)
		{
			System.out.println("Error. Debe registrarse como mínimo 1 adulto.");
		}
		else
		{
			this.adultos=adultos;
		}
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
		return "ReservaFamiliar [adultos=" + adultos + ", ninios=" + ninios + ", getAdultos()=" + getAdultos()
				+ ", getNinios()=" + getNinios() + ", getId()=" + getId() + ", getFecha()=" + getFecha()
				+ ", getDuracion()=" + getDuracion() + ", getIdPista()=" + getIdPista() + ", getPrecio()=" + getPrecio()
				+ ", getDescuento()=" + getDescuento() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
