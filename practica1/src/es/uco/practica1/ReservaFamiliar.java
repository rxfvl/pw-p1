package es.uco.practica1;

import java.util.Date;

/**
 * Clase que extiende de la clase abstracta {@link Reserva} y representa una reserva familiar.
 * Incluye el número de adultos y niños como atributos adicionales.
 * 
 * @author Juan Manuel Ramírez Hinojosa
 */
public class ReservaFamiliar extends Reserva
{
	
	/**
	 * Número de adultos incluidos en la reserva familiar.
	 * Por defecto, siempre debe haber al menos un adulto.
	 */
	private int adultos;

	/**
	 * Número de niños incluidos en la reserva familiar.
	 */
	private int ninios;
			
	
	/**
	 * Constructor por defecto de la clase ReservaFamiliar.
	 * Inicializa los atributos de la clase base y establece el número de adultos a 1 y el número de niños a -1.
	 */
	public ReservaFamiliar()
	{
		super();
		this.adultos = 1;
		this.ninios = -1;
	}

	/**
	 * Constructor que permite inicializar todos los atributos de una reserva familiar.
	 * Si se proporciona un número de adultos menor a 1, se ajusta automáticamente a 1.
	 * 
	 * @param id Identificador de la reserva.
	 * @param duracion Duración de la reserva en horas.
	 * @param idpista Identificador de la pista reservada.
	 * @param precio Precio total de la reserva.
	 * @param descuento Descuento aplicado a la reserva.
	 * @param fecha Fecha en la que se realiza la reserva.
	 * @param adultos Número de adultos en la reserva familiar.
	 * @param ninios Número de niños en la reserva familiar.
	 */
	public ReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha, int adultos, int ninios)
	{
		super(id, duracion, idpista, precio, descuento, fecha);
		this.adultos = adultos;
		this.ninios = ninios;
		if(adultos < 1)
		{
			this.adultos = 1;
		}
	}
			
	/**
	 * Devuelve el número de adultos en la reserva familiar.
	 * 
	 * @return El número de adultos incluidos en la reserva.
	 */
	public int getAdultos()
	{
		return adultos;
	}

	/**
	 * Establece el número de adultos en la reserva familiar.
	 * Si el número de adultos es menor que 1, se muestra un mensaje de error y no se cambia el valor.
	 * 
	 * @param adultos El nuevo número de adultos en la reserva.
	 */
	public void setAdultos(int adultos)
	{
		if(adultos < 1)
		{
			System.out.println("Error. Debe registrarse como mínimo 1 adulto.");
		}
		else
		{
			this.adultos = adultos;
		}
	}

	/**
	 * Devuelve el número de niños en la reserva familiar.
	 * 
	 * @return El número de niños incluidos en la reserva.
	 */
	public int getNinios()
	{
		return ninios;
	}

	/**
	 * Establece el número de niños en la reserva familiar.
	 * 
	 * @param ninios El nuevo número de niños en la reserva.
	 */
	public void setNinios(int ninios)
	{
		this.ninios = ninios;
	}
			
	/**
	 * Devuelve una cadena con la información completa de la reserva familiar, incluyendo los atributos
	 * de la clase base {@link Reserva}, el número de adultos y el número de niños.
	 * 
	 * @return Una cadena con la información de la reserva familiar.
	 */
	@Override
	public String toString() {
		return "ReservaFamiliar [adultos=" + adultos + ", ninios=" + ninios + ", getAdultos()=" + getAdultos()
				+ ", getNinios()=" + getNinios() + ", getId()=" + getId() + ", getFecha()=" + getFecha()
				+ ", getDuracion()=" + getDuracion() + ", getIdPista()=" + getIdPista() + ", getPrecio()=" + getPrecio()
				+ ", getDescuento()=" + getDescuento() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
