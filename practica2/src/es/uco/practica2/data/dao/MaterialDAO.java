package es.uco.practica2.data.dao;

import java.sql.*;
import com.mysql.jdbc.ResultSet;
import es.uco.practica2.business.MaterialDTO;
import es.uco.practica2.data.common.DBConnection;

public class MaterialDAO{
	try{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		
				
	}catch(Exception e)
	{
		System.err.println(e);
		e.printStackTrace();
	}
}
