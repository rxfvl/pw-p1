package es.uco.practica2.data.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
	
	protected Connection connection = null;
	
	// Important: This configuration is hard-coded here for illustrative purposes only
	
	//protected String url = "jdbc:mysql://oraclepr.uco.es:3306/i22tagrd";

	//protected String user = "i22tagrd";

	//protected String password = "BBDDPW24";
	
	private String url;
	private String user;
	private String password;
	
	public DBConnection()
	{
		Properties propiedades = new Properties();
        
        // Cargar propiedades del fichero
        try (InputStream input = new FileInputStream("config.properties")) 
        {
            propiedades.load(input);
        } catch (IOException ex) 
        {
            System.out.println("Error al cargar las propiedades: " + ex.getMessage());
            return;
        }
        
        this.url = propiedades.getProperty("url");
        this.user = propiedades.getProperty("user");
        this.password = propiedades.getProperty("password");
	}
	
	public Connection getConnection(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection successfully opened!");
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}

	// We can include here other methods to encapsulate CRUD commands...

	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}

	
	
}
