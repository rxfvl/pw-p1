package es.uco.practica2.data.dao;

import es.uco.practica2.business.BonoDTO;
import es.uco.practica2.data.common.DBConnection;

// Importaciones necesarias:
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * La clase BonoDAO es responsable de gestionar las operaciones de acceso a datos relacionadas
 * con los bonos en la base de datos. Proporciona métodos para crear, obtener, actualizar y eliminar bonos.
 */
public class BonoDAO {
    
    private DBConnection dbConnection; // Instancia de conexión a la base de datos.
    private Properties propiedades = new Properties(); // Propiedades para consultar SQL.

    /**
     * Constructor de la clase BonoDAO. Inicializa la conexión a la base de datos y carga
     * las propiedades desde el archivo "sql.properties".
     */
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
    
    /**
     * Crea un nuevo bono en la base de datos.
     *
     * @param bono El objeto BonoDTO que contiene la información del bono a crear.
     * @return true si el bono se creó con éxito, false en caso contrario.
     */
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

    /**
     * Obtiene un bono de la base de datos basado en su ID.
     *
     * @param id El identificador del bono a recuperar.
     * @return Un objeto BonoDTO que representa el bono, o null si no se encuentra.
     */
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

    /**
     * Obtiene una lista de todos los bonos asociados a un jugador específico.
     *
     * @param id_jugador El identificador del jugador cuyo bonos se desean recuperar.
     * @return Una lista de objetos BonoDTO que representan los bonos asociados al jugador.
     */
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

    /**
     * Actualiza la información de un bono existente en la base de datos.
     *
     * @param bono El objeto BonoDTO que contiene la nueva información del bono.
     * @return true si el bono se actualizó con éxito, false en caso contrario.
     */
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

    /**
     * Elimina un bono de la base de datos basado en su ID.
     *
     * @param id El identificador del bono a eliminar.
     * @return true si el bono se eliminó con éxito, false en caso contrario.
     */
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

    /**
     * Método auxiliar para cerrar los recursos utilizados para la conexión y la declaración.
     *
     * @param connection La conexión a cerrar.
     * @param preparedStatement La declaración preparara a cerrar.
     */
    private void closeResources(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) dbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar para cerrar los recursos, incluyendo el ResultSet.
     *
     * @param connection La conexión a cerrar.
     * @param preparedStatement La declaración preparara a cerrar.
     * @param resultSet El conjunto de resultados a cerrar.
     */
    private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            closeResources(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
