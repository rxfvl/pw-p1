package es.uco.practica2.data;

import es.uco.practica2.business.BonoDTO;
import es.uco.practica2.data.common.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BonoDAO {

    private DBConnection dbConnection;

    public BonoDAO() {
        dbConnection = new DBConnection();
    }

    public void createBono(BonoDTO bono) {
        String query = "INSERT INTO bonos (tamanio_pista, id_jugador, sesiones, fecha_cad) VALUES (?, ?, ?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bono.getTamanio_pista());
            preparedStatement.setInt(2, bono.getId_jugador());
            preparedStatement.setInt(3, bono.getSesiones());
            preparedStatement.setDate(4, new java.sql.Date(bono.getFecha_cad().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error while creating bono: " + e.getMessage());
        }
    }

    public BonoDTO getBonoById(int id) {
        String query = "SELECT * FROM bonos WHERE id = ?";
        BonoDTO bono = null;
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bono = new BonoDTO(
                        resultSet.getInt("id"),
                        resultSet.getInt("tamanio_pista"),
                        resultSet.getInt("id_jugador"),
                        resultSet.getInt("sesiones"),
                        resultSet.getDate("fecha_cad")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while retrieving bono: " + e.getMessage());
        }
        return bono;
    }

    public List<BonoDTO> getAllBonos() {
        String query = "SELECT * FROM bonos";
        List<BonoDTO> bonos = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                bonos.add(new BonoDTO(
                        resultSet.getInt("id"),
                        resultSet.getInt("tamanio_pista"),
                        resultSet.getInt("id_jugador"),
                        resultSet.getInt("sesiones"),
                        resultSet.getDate("fecha_cad")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error while retrieving all bonos: " + e.getMessage());
        }
        return bonos;
    }

    public void updateBono(BonoDTO bono) {
        String query = "UPDATE bonos SET tamanio_pista = ?, id_jugador = ?, sesiones = ?, fecha_cad = ? WHERE id = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bono.getTamanio_pista());
            preparedStatement.setInt(2, bono.getId_jugador());
            preparedStatement.setInt(3, bono.getSesiones());
            preparedStatement.setDate(4, new java.sql.Date(bono.getFecha_cad().getTime()));
            preparedStatement.setInt(5, bono.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error while updating bono: " + e.getMessage());
        }
    }

    public void deleteBono(int id) {
        String query = "DELETE FROM bonos WHERE id = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error while deleting bono: " + e.getMessage());
        }
    }
}
