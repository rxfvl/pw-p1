package es.uco.practica1;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Reserva 
{
	//Atributos:
	private int id;
	private Date fecha;
	private int duracion;
	private int idpista;
	private float precio;
	private float descuento;
	
	//Constructores:
	public Reserva()
	{
		this.id=-1;
		this.fecha= new Date();
		this.duracion= 0;
		this.idpista=-1;
		this.precio= 0;
		this.descuento= 0;
	}
	public Reserva(int id, int duracion, int idpista, float precio, float descuento, Date fecha)
	{
		this.id=id;
		this.fecha=fecha;
		this.duracion=duracion;
		this.idpista=idpista;
		this.precio=precio;
		this.descuento=descuento;
	}
	
	//Metodos get/set:
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public Date getFecha()
	{
		return fecha;
	}
	public void setfecha(Date fecha)
	{
		this.fecha=fecha;
	}
	public int getDuracion()
	{
		return duracion;
	}
	public void setDuracion(int duracion)
	{
		this.duracion=duracion;
	}
	public int getIdPista()
	{
		return idpista;
	}
	public void setIdPista(int idpista)
	{
		this.idpista=idpista;
	}
	public float getPrecio()
	{
		return precio;
	}
	public void setPrecio(float precio)
	{
		this.precio=precio;
	}
	public float getDescuento()
	{
		return descuento;
	}
	public void setDescuento(float descuento)
	{
		this.descuento=descuento;
	}
	
	//Metodo toString para imprimir la informacion de la reserva:
	public String toString()
	{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        return "Id: "+ this.id +
        		" Fecha: "+ dateFormat.format(fecha) + 
        		" Duración: " + this.duracion + 
        		" IdPista: " + this.idpista +
        		" Precio: " + this.precio + 
        		" Descuento: " + this.descuento;
	}
}
