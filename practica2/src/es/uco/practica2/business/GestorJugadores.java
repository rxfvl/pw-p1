package es.uco.practica2.business;

import es.uco.practica2.data.dao.JugadorDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

public class GestorJugadores {
    private JugadorDAO jugadorDAO = new JugadorDAO();

    public int addJugador(String nombre, String apellidos, Date fechaNacimiento, Date fechaIns, String correo)
    {
    	JugadorDTO jugador = new JugadorDTO(nombre, apellidos, fechaNacimiento, fechaIns, correo);
        int res = jugadorDAO.addJugador(jugador);
        return res;
    }

    public void updateJugador(JugadorDTO jugador) throws SQLException {
        jugadorDAO.updateJugador(jugador);
    }

    public void deleteJugador(int id) {
        jugadorDAO.deleteJugador(id);
    }

    public JugadorDTO getJugador(int id) {
        return jugadorDAO.getJugador(id);
    }

    public List<JugadorDTO> getAllJugadores() {
        return jugadorDAO.getAllJugadores();
    }
}
