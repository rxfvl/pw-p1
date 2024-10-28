package es.uco.practica1;

import java.util.Date;

/**
 * Clase abstracta que actúa como una fábrica para crear diferentes tipos de reservas: {@link ReservaInfantil}, 
 * {@link ReservaAdultos}, y {@link ReservaFamiliar}. Define métodos abstractos que deben ser implementados 
 * por las subclases para crear instancias de cada tipo de reserva.
 * 
 * Esta clase sigue el patrón Factory, proporcionando una interfaz para la creación de objetos sin especificar 
 * las clases exactas que serán instanciadas.
 */
public abstract class ReservaTypeFactory 
{
	// Métodos factory para cada reserva

	/**
	 * Crea una instancia de una reserva infantil.
	 * 
	 * @param id Identificador de la reserva.
	 * @param duracion Duración de la reserva en horas.
	 * @param idpista Identificador de la pista reservada.
	 * @param precio Precio total de la reserva.
	 * @param descuento Descuento aplicado a la reserva.
	 * @param fecha Fecha en la que se realiza la reserva.
	 * @param ninios Número de niños incluidos en la reserva infantil.
	 * @return Una nueva instancia de {@link ReservaInfantil}.
	 */
	public abstract ReservaInfantil createReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int ninios);
	
	/**
	 * Crea una instancia de una reserva para adultos.
	 * 
	 * @param id Identificador de la reserva.
	 * @param duracion Duración de la reserva en horas.
	 * @param idpista Identificador de la pista reservada.
	 * @param precio Precio total de la reserva.
	 * @param descuento Descuento aplicado a la reserva.
	 * @param fecha Fecha en la que se realiza la reserva.
	 * @param participantes Número de participantes en la reserva de adultos.
	 * @return Una nueva instancia de {@link ReservaAdultos}.
	 */
	public abstract ReservaAdultos createReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int participantes);

	/**
	 * Crea una instancia de una reserva familiar.
	 * 
	 * @param id Identificador de la reserva.
	 * @param duracion Duración de la reserva en horas.
	 * @param idpista Identificador de la pista reservada.
	 * @param precio Precio total de la reserva.
	 * @param descuento Descuento aplicado a la reserva.
	 * @param fecha Fecha en la que se realiza la reserva.
	 * @param adultos Número de adultos incluidos en la reserva familiar.
	 * @param ninios Número de niños incluidos en la reserva familiar.
	 * @return Una nueva instancia de {@link ReservaFamiliar}.
	 */
	public abstract ReservaFamiliar createReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int adultos, int ninios);
}
