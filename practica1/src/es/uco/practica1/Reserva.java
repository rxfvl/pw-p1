package es.uco.practica1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase abstracta que representa una Reserva genérica. Contiene información
 * básica sobre la reserva como id, fecha, duración, id de la pista, precio y descuento.
 * 
 * @author Juan Manuel Ramírez Hinojosa
 */
public abstract class Reserva 
{
	
	/**
	 * Identificador único de la reserva.
	 */
	private int id;
	
	/**
	 * Fecha en la que se realiza la reserva.
	 */
	private Date fecha;
	
	/**
	 * Duración de la reserva en horas.
	 */
	private int duracion;
	
	/**
	 * Identificador de la pista donde se realiza la reserva.
	 */
	private int idpista;
	
	/**
	 * Precio total de la reserva.
	 */
	private float precio;
	
	/**
	 * Descuento aplicado a la reserva.
	 */
	private float descuento;
	
	
	/**
	 * Constructor por defecto que inicializa los atributos con valores predeterminados.
	 * El id y el idpista se inicializan a -1, la fecha a la fecha actual,
	 * y los valores de duración, precio y descuento se inicializan a 0.
	 */
	public Reserva()
	{
		this.id=-1;
		this.fecha= new Date();
		this.duracion= 0;
		this.idpista=-1;
		this.precio= 0;
		this.descuento= 0;
	}
	
	/**
	 * Constructor que permite inicializar todos los atributos de la reserva.
	 * 
	 * @param id Identificador de la reserva.
	 * @param duracion Duración de la reserva en horas.
	 * @param idpista Identificador de la pista reservada.
	 * @param precio Precio total de la reserva.
	 * @param descuento Descuento aplicado a la reserva.
	 * @param fecha Fecha en la que se realiza la reserva.
	 */
	public Reserva(int id, int duracion, int idpista, float precio, float descuento, Date fecha)
	{
		this.id=id;
		this.fecha=fecha;
		this.duracion=duracion;
		this.idpista=idpista;
		this.precio=precio;
		this.descuento=descuento;
	}
	
	
	/**
	 * Devuelve el identificador de la reserva.
	 * 
	 * @return El identificador de la reserva.
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Establece el identificador de la reserva.
	 * 
	 * @param id El nuevo identificador de la reserva.
	 */
	public void setId(int id)
	{
		this.id=id;
	}
	
	/**
	 * Devuelve la fecha de la reserva.
	 * 
	 * @return La fecha de la reserva.
	 */
	public Date getFecha()
	{
		return fecha;
	}
	
	/**
	 * Establece la fecha de la reserva.
	 * 
	 * @param fecha La nueva fecha de la reserva.
	 */
	public void setFecha(Date fecha)
	{
		this.fecha=fecha;
	}
	
	/**
	 * Devuelve la duración de la reserva en horas.
	 * 
	 * @return La duración de la reserva en horas.
	 */
	public int getDuracion()
	{
		return duracion;
	}
	
	/**
	 * Establece la duración de la reserva en horas.
	 * 
	 * @param duracion La nueva duración de la reserva en horas.
	 */
	public void setDuracion(int duracion)
	{
		this.duracion=duracion;
	}
	
	/**
	 * Devuelve el identificador de la pista reservada.
	 * 
	 * @return El identificador de la pista reservada.
	 */
	public int getIdPista()
	{
		return idpista;
	}
	
	/**
	 * Establece el identificador de la pista reservada.
	 * 
	 * @param idpista El nuevo identificador de la pista reservada.
	 */
	public void setIdPista(int idpista)
	{
		this.idpista=idpista;
	}
	
	/**
	 * Devuelve el precio total de la reserva.
	 * 
	 * @return El precio total de la reserva.
	 */
	public float getPrecio()
	{
		return precio;
	}
	
	/**
	 * Establece el precio total de la reserva.
	 * 
	 * @param precio El nuevo precio total de la reserva.
	 */
	public void setPrecio(float precio)
	{
		this.precio=precio;
	}
	
	/**
	 * Devuelve el descuento aplicado a la reserva.
	 * 
	 * @return El descuento aplicado a la reserva.
	 */
	public float getDescuento()
	{
		return descuento;
	}
	
	/**
	 * Establece el descuento aplicado a la reserva.
	 * 
	 * @param descuento El nuevo descuento aplicado a la reserva.
	 */
	public void setDescuento(float descuento)
	{
		this.descuento=descuento;
	}
	
	
	/**
	 * Devuelve una cadena de texto con la información de la reserva,
	 * incluyendo el id, fecha, duración, id de la pista, precio y descuento.
	 * 
	 * @return Una cadena con la información detallada de la reserva.
	 */
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
