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

}

