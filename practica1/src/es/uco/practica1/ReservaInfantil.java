package es.uco.practica1;

import java.util.Date;

/**
 * Clase que extiende de la clase abstracta {@link Reserva} y representa una reserva infantil.
 * Incluye el número de niños como atributo adicional.
 * 
 * @author Juan Manuel Ramírez Hinojosa
 */
public class ReservaInfantil extends Reserva
{
	
	/**
	 * Número de niños incluidos en la reserva infantil.
	 */
	private int ninios;
	
	// Métodos reserva infantil
	
	/**
	 * Constructor por defecto de la clase ReservaInfantil.
	 * Inicializa los atributos de la clase base y establece el número de niños a -1.
	 */
	public ReservaInfantil()
	{
		super();
		this.ninios = -1;
	}

	/**
	 * Constructor que permite inicializar todos los atributos de una reserva infantil.
	 * 
	 * @param id Identificador de la reserva.
	 * @param duracion Duración de la reserva en horas.
	 * @param idpista Identificador de la pista reservada.
	 * @param precio Precio total de la reserva.
	 * @param descuento Descuento aplicado a la reserva.
	 * @param fecha Fecha en la que se realiza la reserva.
	 * @param ninios Número de niños en la reserva infantil.
	 */
	public ReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha, int ninios)
	{
		super(id, duracion, idpista, precio, descuento, fecha);
		this.ninios = ninios;
	}

	/**
	 * Devuelve el número de niños en la reserva infantil.
	 * 
	 * @return El número de niños incluidos en la reserva.
	 */
	public int getNinios()
	{
		return ninios;
	}

	/**
	 * Establece el número de niños en la reserva infantil.
	 * 
	 * @param ninios El nuevo número de niños en la reserva.
	 */
	public void setNinios(int ninios)
	{
		this.ninios = ninios;
	}

	/**
	 * Devuelve una cadena con la información completa de la reserva infantil, incluyendo los atributos
	 * de la clase base {@link Reserva} y el número de niños.
	 * 
	 * @return Una cadena con la información de la reserva infantil.
	 */
	@Override
	public String toString() {
		return "ReservaInfantil [ninios=" + ninios + ", getNinios()=" + getNinios() + ", getId()=" + getId()
				+ ", getFecha()=" + getFecha() + ", getDuracion()=" + getDuracion() + ", getIdPista()=" + getIdPista()
				+ ", getPrecio()=" + getPrecio() + ", getDescuento()=" + getDescuento() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}

