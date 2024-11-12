package es.uco.practica2.gestores;

import es.uco.practica2.business.JugadorDTO;
import es.uco.practica2.dao.JugadoresDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GestorJugadores {

    private JugadoresDAO jugadoresDAO;

    public GestorJugadores(Connection connection) {
        this.jugadoresDAO = new JugadoresDAO(connection);
    }

    public void addJugador(JugadorDTO jugador) throws SQLException {
        jugadoresDAO.addJugador(jugador);
    }

    public void updateJugador(JugadorDTO jugador) throws SQLException {
        jugadoresDAO.updateJugador(jugador);
    }

    public void deleteJugador(int dni) throws SQLException {
        jugadoresDAO.deleteJugador(dni);
    }

    public JugadorDTO getJugador(int dni) throws SQLException {
        return jugadoresDAO.getJugador(dni);
    }

    public List<JugadorDTO> getAllJugadores() throws SQLException {
        return jugadoresDAO.getAllJugadores();
    }
}
