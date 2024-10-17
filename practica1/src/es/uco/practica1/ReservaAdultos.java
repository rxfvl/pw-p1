package es.uco.practica1;

import java.util.Date;

/**
 * Clase que extiende de la clase abstracta {@link Reserva} y representa una reserva para adultos.
 * Incluye el número de participantes como atributo adicional.
 * 
 * @author Juan Manuel Ramírez Hinojosa
 */
public class ReservaAdultos extends Reserva
{
	
	/**
	 * Número de participantes incluidos en la reserva de adultos.
	 */
	private int participantes;
		
	
	/**
	 * Constructor por defecto de la clase ReservaAdultos.
	 * Inicializa los atributos de la clase base y establece el número de participantes a -1.
	 */
	public ReservaAdultos()
	{
		super();
		this.participantes = -1;
	}

	/**
	 * Constructor que permite inicializar todos los atributos de una reserva para adultos.
	 * 
	 * @param id Identificador de la reserva.
	 * @param duracion Duración de la reserva en horas.
	 * @param idpista Identificador de la pista reservada.
	 * @param precio Precio total de la reserva.
	 * @param descuento Descuento aplicado a la reserva.
	 * @param fecha Fecha en la que se realiza la reserva.
	 * @param participantes Número de participantes en la reserva de adultos.
	 */
	public ReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha, int participantes)
	{
		super(id, duracion, idpista, precio, descuento, fecha);
		this.participantes = participantes;
	}
	
	/**
	 * Devuelve el número de participantes en la reserva de adultos.
	 * 
	 * @return El número de participantes incluidos en la reserva.
	 */
	public int getParticipantes()
	{
		return participantes;
	}

	/**
	 * Establece el número de participantes en la reserva de adultos.
	 * 
	 * @param participantes El nuevo número de participantes en la reserva.
	 */
	public void setParticipantes(int participantes)
	{
		this.participantes = participantes;
	}
		
	/**
	 * Devuelve una cadena con la información completa de la reserva de adultos, incluyendo los atributos
	 * de la clase base {@link Reserva} y el número de participantes.
	 * 
	 * @return Una cadena con la información de la reserva de adultos.
	 */
	@Override
	public String toString() {
		return "ReservaAdultos [participantes=" + participantes + ", getParticipantes()=" + getParticipantes()
				+ ", getId()=" + getId() + ", getFecha()=" + getFecha() + ", getDuracion()=" + getDuracion()
				+ ", getIdPista()=" + getIdPista() + ", getPrecio()=" + getPrecio() + ", getDescuento()="
				+ getDescuento() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}
