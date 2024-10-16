package es.uco.practica1;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileManager {

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

}

