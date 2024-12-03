package es.uco.practica2.business;

import es.uco.practica2.data.dao.JugadorDAO;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;

public class GestorJugadores {
    private JugadorDAO jugadorDAO = new JugadorDAO();

    public int addJugador(String nombre, String apellidos, Date fechaNacimiento, LocalDate fechaIns, String correo)
    {
    	JugadorDTO jugador = new JugadorDTO(nombre, apellidos, fechaNacimiento, fechaIns, correo);
        return jugadorDAO.addJugador(jugador); 
    }

    public int updateJugador(String nombre, String apellidos, Date fechaN, String correo)
    {
    	JugadorDTO jugador = new JugadorDTO(nombre, apellidos, fechaN, LocalDate.now(), correo);
        return jugadorDAO.updateJugador(jugador);
    }
    
    public List<JugadorDTO> getAllJugadores() 
    {
        return jugadorDAO.getAllJugadores();
    }
    
    public int deleteJugador(String correo) 
    {
    	JugadorDTO jugador = new JugadorDTO("n", "a", new Date(), LocalDate.now(), correo);
        return jugadorDAO.deleteJugador(jugador);
    }
}
