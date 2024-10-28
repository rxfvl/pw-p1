package es.uco.practica1;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class FileManager {
    private Properties properties;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha esperado

    public FileManager() {
        properties = new Properties();
        try (FileReader reader = new FileReader("config.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero de propiedades: " + e.getMessage());
        }
    }

    public String getFilePath(String key) {
        return properties.getProperty(key);
    }
    
    // Leer el contenido de un archivo
    public String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return content.toString();
    }

    public boolean findLine(String filePath, String targetLine) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(targetLine)) {
                    return true; // Devuelve la línea si coincide con targetLine
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false; // Devuelve null si no se encontró la línea
    }

    
    // Escribir en un archivo (sobrescribe el contenido existente)
    public void writeFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Archivo escrito exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Añadir contenido a un archivo (sin sobrescribir)
    public void appendToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(content);
            System.out.println("Contenido añadido exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al añadir contenido al archivo: " + e.getMessage());
        }
    }

    // Borrar un archivo
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo borrado exitosamente.");
                return true;
            } else {
                System.out.println("No se pudo borrar el archivo.");
                return false;
            }
        } else {
            System.out.println("El archivo no existe.");
            return false;
        }
    }

    // Comprobar si un archivo existe
    public boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
    
    public List<Jugador> cargarJugadoresDesdeArchivo(String filePath) {
        List<Jugador> jugadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");

                if (datos.length == 6) { // Verifica que la línea tenga todos los datos necesarios
                    String nombre = datos[0];
                    String apellidos = datos[1];
                    Date fechaNacimiento = dateFormat.parse(datos[2]);
                    Date fechaInscripcion = dateFormat.parse(datos[3]);
                    String correoElectronico = datos[4];
                    String dni = datos[5];

                    Jugador jugador = new Jugador(nombre, apellidos, fechaNacimiento, fechaInscripcion, correoElectronico, dni);
                    jugadores.add(jugador);
                } else {
                    System.out.println("Línea con formato incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error al parsear una fecha: " + e.getMessage());
        }

        return jugadores;
    }
    
    public void guardarJugadoresEnArchivo(String filePath, List<Jugador> jugadores) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Jugador jugador : jugadores) {
                // Convierte cada jugador a una línea en formato CSV
                String line = String.format("%s,%s,%s,%s,%s,%s\n",
                        jugador.getNombre(),
                        jugador.getApellidos(),
                        dateFormat.format(jugador.getFechaNacimiento()),
                        dateFormat.format(jugador.getFechaInscripcion()),
                        jugador.getCorreoElectronico(),
                        jugador.getDni());
                
                writer.write(line);
            }
            System.out.println("Jugadores guardados exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar jugadores en el archivo: " + e.getMessage());
        }
    }



	public List<Pista> cargarPistasDesdeArchivo(String filePath) 
	{
	    List<Pista> pistas = new ArrayList<>();
	
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
	    {
	        String line;
	        while ((line = br.readLine()) != null) 
	        {
	            String[] datos = line.split(",");
	
	            if (datos.length == 6) { // Verifica que la línea tenga todos los datos necesarios
	                String nombre = datos[0];
	                boolean estado = Boolean.parseBoolean(datos[1]);
	                boolean tipo = Boolean.parseBoolean(datos[2]);
	                Enums.tamanio tam;
	                try {
	                    tam = Enums.tamanio.valueOf(datos[3].toUpperCase());
	                } catch (IllegalArgumentException e) 
	                {
	                    tam = Enums.tamanio.NONE;
	                    System.out.println("Valor inválido para tamanio. Estableciendo a NONE.");
	                }
	                int jugadores = Integer.parseInt(datos[4]);
	                
	                String[] materialesArray = datos[5].split(" ");
	                List<Material> materialesList = new ArrayList<>();
	                for (String materialStr : materialesArray) 
	                {
	                    // Dividir cada material por "/"
	                    String[] campos = materialStr.split("/");
	
	                    // Convertir los campos apropiadamente
	                    int id = Integer.parseInt(campos[0]);
	                    Enums.tipo tipoMat = Enums.tipo.valueOf(campos[1]);
	                    boolean usoMaterial = Boolean.parseBoolean(campos[2]);
	                    Enums.estado estadoMat = Enums.estado.valueOf(campos[3]);
	
	                    // Crear una nueva instancia de Material
	                    Material material = new Material(id, tipoMat, usoMaterial, estadoMat);
	                    materialesList.add(material);
	                }
	
	                Pista pista = new Pista(nombre, estado, tipo, tam, jugadores);
	                for(Material mat : materialesList)
	                {
	                	pista.asociarMaterialAPista(mat);
	                }
	                pistas.add(pista);
	            } else {
	                System.out.println("Línea con formato incorrecto: " + line);
	            }
	        }
	    } catch (IOException e) 
	    {
	        System.out.println("Error al leer el archivo: " + e.getMessage());
	    }
	
	    return pistas;
	}
	
	public void guardarPistasEnArchivo(String filePath, List<Pista> pistas) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Pista pista : pistas) {
                // Convierte cada jugador a una línea en formato CSV
                String materiales = formatoMat(pista.getMateriales());
                String line = String.format("%s,%b,%b,%s,%d,%s\n",
                        pista.getNombre(),
                        pista.getEstado(),
                        pista.getTipo(),
                        pista.getPista().name(),
                        pista.getJugadores_max(),
                        materiales);
                writer.write(line);
            }
            System.out.println("Pistas guardadas exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar pistas en el archivo: " + e.getMessage());
        }
    }
	
	private static String formatoMat(List<Material> materiales)
	{
		StringBuilder materialesBuilder = new StringBuilder();
        for (Material m : materiales) {
            if (materialesBuilder.length() > 0) {
                materialesBuilder.append(" "); // Separador de materiales
            }
            // Formatear cada material como "id/tipo/usoMaterial/estado"
            String materialStr = String.format("%d/%s/%b/%s",
                    m.getId(),
                    m.getType().name(),
                    m.getMaterialUse(),
                    m.getStatus().name());
            materialesBuilder.append(materialStr);
        }
        return materialesBuilder.toString();
	}
	
	public List<Material> cargarMaterialesDesdeArchivo(String filePath) {
        List<Material> materiales = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");

                if (datos.length == 4) { // Verifica que la línea tenga todos los datos necesarios
                    int id = Integer.parseInt(datos[0]);
                    Enums.tipo tipo;
	                try {
	                    tipo = Enums.tipo.valueOf(datos[1].toUpperCase());
	                } catch (IllegalArgumentException e) 
	                {
	                    tipo = Enums.tipo.NONE;
	                    System.out.println("Valor inválido para tipo. Estableciendo a NONE.");
	                }
	                boolean uso = Boolean.parseBoolean(datos[3]);
	                Enums.estado estado;
	                try {
	                    estado = Enums.estado.valueOf(datos[2].toUpperCase());
	                } catch (IllegalArgumentException e) 
	                {
	                    estado = Enums.estado.NONE;
	                    System.out.println("Valor inválido para estado. Estableciendo a NONE.");
	                }

                    Material material = new Material(id, tipo, uso, estado);
                    materiales.add(material);
                } else {
                    System.out.println("Línea con formato incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return materiales;
    }
	
	public void guardarMaterialesEnArchivo(String filePath, List<Material> materiales) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Material material : materiales) {
                // Convierte cada jugador a una línea en formato CSV
                String line = String.format("%d,%s,%b,%s\n",
                        material.getId(),
                        material.getType().name(),
                        material.getMaterialUse(),
                        material.getStatus().name());
                
                writer.write(line);
            }
            System.out.println("Materiales guardados exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar Materiales en el archivo: " + e.getMessage());
        }
    }
	
	public List<Reserva> cargarReservasDesdeArchivo(String filePath) {
        List<Reserva> reservas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");

                if (datos.length == 6) { // Verifica que la línea tenga todos los datos necesarios
                    int id = Integer.parseInt(datos[0]);
                    int duracion = Integer.parseInt(datos[1]);
                    int idpista = Integer.parseInt(datos[2]);
                    float precio = Float.parseFloat(datos[3]);
                    float descuento = Float.parseFloat(datos[4]);
                    Date fecha = dateFormat.parse(datos[5]);

                    Reserva reserva = new Reserva(id, duracion, idpista, precio, descuento, fecha);
                    reservas.add(reserva);
                } else {
                    System.out.println("Línea con formato incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error al parsear una fecha: " + e.getMessage());
        }

        return reservas;
    }
	
	public void guardarReservasEnArchivo(String filePath, List<Reserva> reservas) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Reserva reserva : reservas) {
                // Convierte cada reserva a una línea en formato CSV
                String line = String.format("%d,%d,%d,%f,%f,%s\n",
                        reserva.getId(),
                        reserva.getDuracion(),
                        reserva.getIdPista(),
                        reserva.getPrecio(),
                        reserva.getDescuento(),
                        dateFormat.format(reserva.getFecha()));              
                writer.write(line);
            }
            System.out.println("Reservas guardados exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar jugadores en el archivo: " + e.getMessage());
        }
    }
}
	

