package es.uco.practica1;

public class GestorUsuarios {
	
	private boolean userExists(String filePath)
	{
		FileManager fileMan = new FileManager();
		
		if (!fileMan.fileExists(filePath))
		{
			System.out.println("ERR: Fichero usuarios.txt no existe, cree el archivo\n");
		}
		
		else
		{
			
		}
	}
	
}
