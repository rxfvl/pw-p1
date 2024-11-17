package es.uco.practica2.business;

import es.uco.practica2.data.dao.JugadorDAO;

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

    public void deleteJugador(int id) throws SQLException {
        jugadorDAO.deleteJugador(id);
    }

    public JugadorDTO getJugador(int id) throws SQLException {
        return jugadorDAO.getJugador(id);
    }

    public List<JugadorDTO> getAllJugadores() throws SQLException {
        return jugadorDAO.getAllJugadores();
    }
}
