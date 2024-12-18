package es.uco.practica2.data.dao;

import es.uco.practica2.business.BonoDTO;
import es.uco.practica2.data.common.DBConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BonoDAO {
    
    private DBConnection dbConnection;
    private Properties propiedades = new Properties();

    public BonoDAO() {
        this.dbConnection = new DBConnection();
    	
    	try (InputStream input = new FileInputStream("sql.properties")) 
    	{
   			this.propiedades.load(input);
    	}catch (IOException ex) 
    	{
    		System.out.println("Error al cargar las propiedades: " + ex.getMessage());
    		return;
    	}
    }
    

    // Método para crear un nuevo bono
    public boolean createBono(BonoDTO bono) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean created = false;

        try {
            connection = dbConnection.getConnection();
            String sql = this.propiedades.getProperty("crearBonoInsert");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bono.getTamanio_pista());
            preparedStatement.setInt(2, bono.getId_jugador());
            preparedStatement.setInt(3, bono.getSesiones());
            preparedStatement.setDate(4, new java.sql.Date(bono.getFecha_cad().getTime()));

            created = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement);
        }
        return created;
    }

    // Método para obtener un bono por ID
    public BonoDTO getBonoById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BonoDTO bono = null;

        try {
            connection = dbConnection.getConnection();
            String sql = this.propiedades.getProperty("getBonoISelect");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bono = new BonoDTO();
                bono.setId(resultSet.getInt("id"));
                bono.setTamanio_pista(resultSet.getInt("tamanio_pista"));
                bono.setId_jugador(resultSet.getInt("id_jugador"));
                bono.setSesiones(resultSet.getInt("sesiones"));
                bono.setFecha_cad(resultSet.getDate("fecha_cad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
        return bono;
    }

    // Método para obtener todos los bonos asociadas a un jugador
    public List<BonoDTO> getBonosByJugadorId(int id_jugador) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BonoDTO> bonos = new ArrayList<>();

        try {
            connection = dbConnection.getConnection();
            String sql = this.propiedades.getProperty("getBonoJSelect");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_jugador);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BonoDTO bono = new BonoDTO();
                bono.setId(resultSet.getInt("id"));
                bono.setTamanio_pista(resultSet.getInt("tamanio_pista"));
                bono.setId_jugador(resultSet.getInt("id_jugador"));
                bono.setSesiones(resultSet.getInt("sesiones"));
                bono.setFecha_cad(resultSet.getDate("fecha_cad"));
                bonos.add(bono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
        return bonos;
    }

    // Método para actualizar un bono
    public boolean updateBono(BonoDTO bono) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean updated = false;

        try {
            connection = dbConnection.getConnection();
            String sql = this.propiedades.getProperty("updBonoUpdate");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bono.getTamanio_pista());
            preparedStatement.setInt(2, bono.getId_jugador());
            preparedStatement.setInt(3, bono.getSesiones());
            preparedStatement.setDate(4, new java.sql.Date(bono.getFecha_cad().getTime()));
            preparedStatement.setInt(5, bono.getId());

            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement);
        }
        return updated;
    }

    // Método para eliminar un bono
    public boolean deleteBono(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean deleted = false;

        try {
            connection = dbConnection.getConnection();
            String sql = this.propiedades.getProperty("delBonoDelete");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement);
        }
        return deleted;
    }

    // Método auxiliar para cerrar recursos
    private void closeResources(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) dbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para cerrar recursos con ResultSet
    private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            closeResources(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
