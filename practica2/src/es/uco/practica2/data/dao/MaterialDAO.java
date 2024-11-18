package es.uco.practica2.data.dao;

// Importación de clases necesarias
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import es.uco.practica2.business.*;
import es.uco.practica2.data.common.DBConnection;

/**
 * Clase DAO que gestiona las operaciones de acceso a datos para los materiales.
 * Proporciona métodos para crear, borrar, asociar materiales a pistas y listar materiales.
 */
public class MaterialDAO {
	
	private Properties propiedades = new Properties();
	
	/**
	 * Constructor de la clase MaterialDAO.
	 * Inicializa el objeto Properties cargando las configuraciones de la conexión a la base de datos
	 * desde el archivo sql.properties.
	 */
	public MaterialDAO()
	{
		try (InputStream input = new FileInputStream("sql.properties")) 
        {
            this.propiedades.load(input);
        } catch (IOException ex) 
        {
            System.out.println("Error al cargar las propiedades: " + ex.getMessage());
            return;
        }
	}
	
	/**
	 * Crea un nuevo material en la base de datos.
	 * 
	 * @param material objeto MaterialDTO que contiene los datos del material a crear.
	 * @return un entero que indica el estado de la operación (1 para éxito, -1 para error).
	 */
	public int crearMaterial(MaterialDTO material)
	{
		int status = -1;
		try{
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(this.propiedades.getProperty("crearMatInsert"));
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
	
	/**
	 * Borra un material de la base de datos.
	 * 
	 * @param material objeto MaterialDTO cuyo material se va a borrar.
	 * @return un entero que indica el estado de la operación (1 para éxito, 0 si no se encontró el registro, -1 para error).
	 */
	public int borrarMaterial(MaterialDTO material)
	{
		ResultSet select;
		int status = -1;
		try {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
		
			String selectQuery = this.propiedades.getProperty("borrarMatSelect");
			
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, material.getTipo());
			select = ps.executeQuery();
			int idDelete = -1;
			
			if (select.next())
			{
				idDelete = select.getInt(1);
			}
			
			if (idDelete != -1)
			{
				PreparedStatement psDel = con.prepareStatement(this.propiedades.getProperty("borrarMatDelete"));
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
	
	/**
	 * Asocia un material a una pista en la base de datos. 
	 * Se verifica si la pista tiene capacidad suficiente para el tipo de material.
	 * 
	 * @param pista objeto PistaDTO que representa la pista a la que se va a asociar el material.
	 * @param mat objeto MaterialDTO que representa el material a asociar.
	 * @return un entero que indica el estado de la operación (1 para éxito, -1 si la pista no se encontró, 0 para otros errores).
	 */
	public int asociarMaterialPista(PistaDTO pista, MaterialDTO mat)
	{
		try
		{		
			int pistaID, insertar = 0;
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getConnection();
			
			PreparedStatement psPista = con.prepareStatement(this.propiedades.getProperty("asMatSelect1"));
			psPista.setString(1, pista.getNombre());
			
			ResultSet rsP = psPista.executeQuery();
			
			if(rsP.next())
			{
				pistaID = rsP.getInt("id");
				
				PreparedStatement psMat = con.prepareStatement(this.propiedades.getProperty("asMatSelect2"));
				psMat.setInt(1, mat.getTipo());
				psMat.setInt(2, pistaID);
				
				ResultSet rsM = psMat.executeQuery();
				
				if(rsP.next())
				{
					int filas = rsM.getInt("total");
					
					if(mat.getTipo() == 1 && filas < 2){insertar = 1;}
					else if(mat.getTipo() == 2 && filas < 20){insertar = 1;}
					else if(mat.getTipo() == 3 && filas < 12){insertar = 1;}
				}
				else {insertar = 1;}
				
				if(insertar == 1)
				{
					mat.setId_pista(pistaID);
					int res = crearMaterial(mat);
					return res;
				}
			}		
			else {return -1;}
			
		}catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * Lista todos los materiales presentes en la base de datos.
	 * 
	 * @return una lista de objetos MaterialDTO que representan los materiales, o null si ocurre un error.
	 */
	public List<MaterialDTO> listarMateriales()
	{
		try
		{
			List<MaterialDTO> lista = new ArrayList<>();
			DBConnection dbConnection = new DBConnection();
			Connection con = dbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(this.propiedades.getProperty("listMatSelect"));
			
			while(rs.next())
			{
				//int id = rs.getInt("id");
				int tipo = rs.getInt("tipo");
				int uso_material = rs.getInt("uso_material");
				int estado = rs.getInt("estado");
				int id_pista = rs.getInt("id_pista");
				MaterialDTO material = new MaterialDTO(tipo, uso_material, estado, id_pista);
				lista.add(material);
			}
			if (stmt != null) stmt.close();
			
			return lista;
			
		}
		catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
			return null; //CUIDADO
		}
	}
}
