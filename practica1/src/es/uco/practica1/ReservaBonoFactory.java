package es.uco.practica1;

import java.util.Date;
import java.util.ArrayList;

/**
 * Clase concreta que extiende de {@link ReservaTypeFactory} y proporciona implementaciones
 * para crear diferentes tipos de reservas con un sistema de bono, limitado a 5 reservas. 
 * Las reservas permitidas incluyen {@link ReservaInfantil}, {@link ReservaAdultos}, y {@link ReservaFamiliar}.
 * 
 * Esta clase implementa el patrón Factory con la funcionalidad adicional de controlar un límite de 5 reservas.
 * Una vez alcanzado este límite, no se pueden realizar más reservas.
 * 
 * @see ReservaTypeFactory
 * @see ReservaInfantil
 * @see ReservaAdultos
 * @see ReservaFamiliar
 */
public class ReservaBonoFactory extends ReservaTypeFactory
{
    /**
     * Lista que almacena las reservas realizadas.
     * Está limitada a un máximo de 5 reservas.
     */
    private ArrayList<Reserva> reservasHechas;
    
    /**
     * Constructor que inicializa la lista de reservas.
     */
    public ReservaBonoFactory()
    {
        this.reservasHechas = new ArrayList<Reserva>();
    }
    
    /**
     * Crea una instancia de {@link ReservaInfantil}, siempre que no se haya alcanzado el límite de 5 reservas.
     * Si se han realizado 5 reservas, devuelve {@code null}.
     * 
     * @param id Identificador de la reserva.
     * @param duracion Duración de la reserva en horas.
     * @param idpista Identificador de la pista reservada.
     * @param precio Precio total de la reserva.
     * @param descuento Descuento aplicado a la reserva.
     * @param fecha Fecha en la que se realiza la reserva.
     * @param ninios Número de niños incluidos en la reserva infantil.
     * @return Una nueva instancia de {@link ReservaInfantil} o {@code null} si se alcanzó el límite de reservas.
     */
    @Override
    public ReservaInfantil createReservaInfantil(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int ninios)
    {
        if(this.reservasHechas.size() == 5)
        {
            return null;
        }
        Reserva reserva = new ReservaInfantil(id, duracion, idpista, precio, descuento, fecha, ninios);
        this.reservasHechas.add(reserva);
        return (ReservaInfantil) this.reservasHechas.get(0);
    }
    
    /**
     * Crea una instancia de {@link ReservaAdultos}, siempre que no se haya alcanzado el límite de 5 reservas.
     * Si se han realizado 5 reservas, devuelve {@code null}.
     * 
     * @param id Identificador de la reserva.
     * @param duracion Duración de la reserva en horas.
     * @param idpista Identificador de la pista reservada.
     * @param precio Precio total de la reserva.
     * @param descuento Descuento aplicado a la reserva.
     * @param fecha Fecha en la que se realiza la reserva.
     * @param participantes Número de participantes en la reserva de adultos.
     * @return Una nueva instancia de {@link ReservaAdultos} o {@code null} si se alcanzó el límite de reservas.
     */
    @Override
    public ReservaAdultos createReservaAdultos(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int participantes)
    {
        if(this.reservasHechas.size() == 5)
        {
            return null;
        }
        Reserva reserva = new ReservaAdultos(id, duracion, idpista, precio, descuento, fecha, participantes);
        this.reservasHechas.add(reserva);
        return (ReservaAdultos) this.reservasHechas.get(0);
    }
    
    /**
     * Crea una instancia de {@link ReservaFamiliar}, siempre que no se haya alcanzado el límite de 5 reservas.
     * Si se han realizado 5 reservas, devuelve {@code null}.
     * 
     * @param id Identificador de la reserva.
     * @param duracion Duración de la reserva en horas.
     * @param idpista Identificador de la pista reservada.
     * @param precio Precio total de la reserva.
     * @param descuento Descuento aplicado a la reserva.
     * @param fecha Fecha en la que se realiza la reserva.
     * @param adultos Número de adultos incluidos en la reserva familiar.
     * @param ninios Número de niños incluidos en la reserva familiar.
     * @return Una nueva instancia de {@link ReservaFamiliar} o {@code null} si se alcanzó el límite de reservas.
     */
    @Override
    public ReservaFamiliar createReservaFamiliar(int id, int duracion, int idpista, float precio, float descuento, Date fecha , int adultos, int ninios)
    {
        if(this.reservasHechas.size() == 5)
        {
            return null;
        }
        Reserva reserva = new ReservaFamiliar(id, duracion, idpista, precio, descuento, fecha, adultos, ninios);
        this.reservasHechas.add(reserva);
        return (ReservaFamiliar) this.reservasHechas.get(0);
    }
}
