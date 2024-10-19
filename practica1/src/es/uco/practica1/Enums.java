package es.uco.practica1;

public class Enums 
{

    /**
     * Enumeración que representa los diferentes tipos de materiales deportivos que pueden
     * estar disponibles en una pista.
     * 
     * <ul>
     * <li>{@code PELOTAS}: Representa el tipo de material "pelotas".</li>
     * <li>{@code CANASTAS}: Representa el tipo de material "canastas".</li>
     * <li>{@code CONOS}: Representa el tipo de material "conos".</li>
     * <li>{@code NONE}: Indica que no se ha definido ningún tipo de material.</li>
     * </ul>
     */
    public enum tipo 
    {
        PELOTAS,
        CANASTAS,
        CONOS,
        NONE
    }

    /**
     * Enumeración que representa los diferentes estados en los que puede estar un material.
     * 
     * <ul>
     * <li>{@code DISPONIBLE}: El material está disponible para su uso.</li>
     * <li>{@code RESERVADO}: El material está reservado y no está disponible.</li>
     * <li>{@code MALESTADO}: El material está en mal estado y no se puede utilizar.</li>
     * <li>{@code NONE}: Indica que no se ha definido el estado del material.</li>
     * </ul>
     */
    public enum estado 
    {
        DISPONIBLE,
        RESERVADO,
        MALESTADO,
        NONE
    }

    /**
     * Enumeración que representa los diferentes tamaños de una pista deportiva.
     * 
     * <ul>
     * <li>{@code MINIBASKET}: Una pista para el juego de minibasket.</li>
     * <li>{@code ADULTOS}: Una pista de tamaño completo para adultos.</li>
     * <li>{@code TRES_VS_TRES}: Una pista para juegos de tres contra tres.</li>
     * <li>{@code NONE}: Indica que no se ha definido el tamaño de la pista.</li>
     * </ul>
     */
    public enum tamanio 
    {
        MINIBASKET, 
        ADULTOS,
        TRES_VS_TRES,
        NONE
    }
}