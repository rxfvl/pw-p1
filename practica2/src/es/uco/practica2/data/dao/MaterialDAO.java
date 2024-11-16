package es.uco.practica2.data.dao;

import java.sql.*;
import es.uco.practica2.business.*;
import es.uco.practica2.data.common.DBConnection;

public class MaterialDAO {
	
	public int crearMaterial(MaterialDTO material)
	{
		int status = -1;
		try{
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement ps = connection.prepareStatement("insert into Materiales (tipo, uso_material, estado, id_pista) values(?,?,?,?)");
			ps.setInt(1,material.getTipo());	
			ps.setInt(2, material.getUso_material());
			ps.setInt(3, material.getEstado());
			if (material.getId_pista() == -1)
				ps.setNull(4, Types.INTEGER);
			else
			{
				ps.setInt(4, material.getId_pista());
			}
			status = ps.executeUpdate();
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		return status;
	}
	
	public int borrarMaterial(int tipo)
	{
		ResultSet select;
		int status = -1;
		try {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
		
			String selectQuery = "select min(id) from materiales where id_pista is null and estado = 1 and tipo = ?";
			
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, tipo);
			select = ps.executeQuery();
			int idDelete = -1;
			
			if (select.next())
			{
				idDelete = select.getInt(1);
			}
			
			if (idDelete != -1)
			{
				PreparedStatement psDel = con.prepareStatement("delete from materiales where id = ?");
				psDel.setInt(1, idDelete);
				status = psDel.executeUpdate();
			}
			else
			{
				status = 0; // No se encontró registro
			}
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int asociarMaterialPista(PistaDTO pista, MaterialDTO mat)
	{
		try
		{		
			int pistaID, insertar = 0;
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
			
			PreparedStatement psPista = con.prepareStatement("SELECT * FROM pistas where nombre = ?");
			psPista.setString(1, pista.getNombre());
			
			ResultSet rsP = psPista.executeQuery();
			
			if(rsP.next())
			{
				pistaID = rsP.getInt("id");
				
				PreparedStatement psMat = con.prepareStatement("SELECT COUNT(*) as total FROM materiales where tipo = ? and id_pista = ?");
				psMat.setInt(1, mat.getTipo());
				psMat.setInt(2, pistaID);
				
				ResultSet rsM = psMat.executeQuery();
				
				if(rsP.next())
				{
					int filas = rsM.getInt("total");
					
					if(mat.getTipo() == 1 && filas < 2){insertar = 1;}
					else if(mat.getTipo() == 2 && filas < 20){insertar = 1;}
					else if(mat.getTipo() == 3 && filas < 12){insertar = 1;}
					
					if(insertar == 1)
					{
						
					}
					else {return -1;}
				}
			}
			else{return 0;}
			// TERMINAR
			
			
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
}
