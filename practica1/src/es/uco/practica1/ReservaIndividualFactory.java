package es.uco.practica1;

import java.util.Date;

/**
 * Clase concreta que extiende de {@link ReservaTypeFactory} y proporciona implementaciones
 * para crear diferentes tipos de reservas individuales: {@link ReservaInfantil}, {@link ReservaAdultos}, 
 * y {@link ReservaFamiliar}. 
 * 
 * Esta clase implementa el patrón Factory para la creación de instancias de reservas específicas.
 * 
 * @see ReservaTypeFactory
 * @see ReservaInfantil
 * @see ReservaAdultos
 * @see ReservaFamiliar
 * 
 * @author Juan Manuel Ramírez Hinojosa
 */
public class ReservaIndividualFactory extends ReservaTypeFactory 
{

    /**
     * Crea una instancia de {@link ReservaInfantil}.
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
    @Override
    public ReservaInfantil createReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int ninios)
    {
        return new ReservaInfantil(id, duracion, idpista, precio, descuento, fecha, ninios);
    }
    
    /**
     * Crea una instancia de {@link ReservaAdultos}.
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
    @Override
    public ReservaAdultos createReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int participantes)
    {
        return new ReservaAdultos(id, duracion, idpista, precio, descuento, fecha, participantes);
    }
    
    /**
     * Crea una instancia de {@link ReservaFamiliar}.
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
    @Override
    public ReservaFamiliar createReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int adultos, int ninios)
    {
        return new ReservaFamiliar(id, duracion, idpista, precio, descuento, fecha, adultos, ninios);
    }
}
