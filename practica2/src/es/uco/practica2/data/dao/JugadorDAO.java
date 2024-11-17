package es.uco.practica2.data.dao;

import es.uco.practica2.business.JugadorDTO;
import es.uco.practica2.data.common.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {
    private Connection connection;

    public JugadorDAO(Connection connection) {
        this.connection = connection;
    }

    public void addJugador(JugadorDTO jugador) throws SQLException {
        String sql = "INSERT INTO jugadores (nombre, apellidos, fecha_nacimiento, fecha_inscripcion, correo_electronico) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getApellidos());
            stmt.setDate(3, new java.sql.Date(jugador.getFecha_nacimiento().getTime()));
            stmt.setDate(4, new java.sql.Date(jugador.getFecha_inscripcion().getTime()));
            stmt.setString(5, jugador.getCorreo_electronico());
            stmt.executeUpdate();
        }
    }

    public void updateJugador(JugadorDTO jugador) throws SQLException {
        String sql = "UPDATE jugadores SET nombre = ?, apellidos = ?, fecha_nacimiento = ?, fecha_inscripcion = ?, correo_electronico = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getApellidos());
            stmt.setDate(3, new java.sql.Date(jugador.getFecha_nacimiento().getTime()));
            stmt.setDate(4, new java.sql.Date(jugador.getFecha_inscripcion().getTime()));
            stmt.setString(5, jugador.getCorreo_electronico());
            stmt.setInt(6, jugador.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteJugador(int id) throws SQLException {
        String sql = "DELETE FROM jugadores WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public JugadorDTO getJugador(int id) throws SQLException {
        String sql = "SELECT * FROM jugadores WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new JugadorDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getDate("fecha_inscripcion"),
                        rs.getString("correo_electronico")
                );
            }
        }
        return null;
    }

    public List<JugadorDTO> getAllJugadores() throws SQLException {
        List<JugadorDTO> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM jugadores";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                jugadores.add(new JugadorDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getDate("fecha_inscripcion"),
                        rs.getString("correo_electronico")
                ));
            }
        }
        return jugadores;
    }
}
