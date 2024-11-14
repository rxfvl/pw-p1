package es.uco.practica2.gestores;

import es.uco.practica2.business.JugadorDTO;
import es.uco.practica2.dao.JugadorDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GestorJugadores {

    private JugadorDAO jugadorDAO;

    public GestorJugadores(Connection connection) {
        this.jugadorDAO = new JugadorDAO(connection);
    }

    public void addJugador(JugadorDTO jugador) throws SQLException {
        jugadorDAO.addJugador(jugador);
    }

    public void updateJugador(JugadorDTO jugador) throws SQLException {
        jugadorDAO.updateJugador(jugador);
    }

    public void deleteJugador(int dni) throws SQLException {
        jugadorDAO.deleteJugador(dni);
    }

    public JugadorDTO getJugador(int dni) throws SQLException {
        return jugadorDAO.getJugador(dni);
    }

    public List<JugadorDTO> getAllJugadores() throws SQLException {
        return jugadorDAO.getAllJugadores();
    }
}
