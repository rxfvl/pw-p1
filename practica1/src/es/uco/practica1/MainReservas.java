package es.uco.practica1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MainReservas {
    
    private static GestorReservas gestorReservas;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        gestorReservas = new GestorReservas(); // Inicia el gestor de reservas

        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- Gestión de Reservas ---");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Modificar Reserva");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Listar Reservas Futuras");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearReserva();
                    break;
                case 2:
                    modificarReserva();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                case 4:
                    listarReservasFuturas();
                    break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }

    private static void crearReserva() {
        System.out.print("Duración (horas): ");
        int duracion = scanner.nextInt();
        
        System.out.print("ID de pista: ");
        int idPista = scanner.nextInt();
        
        System.out.print("Precio: ");
        float precio = scanner.nextFloat();
        
        System.out.print("Descuento: ");
        float descuento = scanner.nextFloat();
        
        System.out.print("Fecha (dd/MM/yyyy): ");
        String fechaInput = scanner.nextLine(); // Limpiar buffer
        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInput);

        // Sumar lógica para capturar el tipo de reserva y participantes o niños, adultos, etc.
        // Suponiendo una reserva de adultos
        System.out.print("Número de participantes: ");
        int participantes = scanner.nextInt();
        
        Reserva reserva = gestorReservas.crearReservaIndividual(duracion, idPista, precio, descuento, fecha, participantes, new Jugador());
        
        if (reserva != null) {
            System.out.println("Reserva creada con éxito: " + reserva);
        } else {
            System.out.println("Error al crear la reserva.");
        }
    }

    private static void modificarReserva() {
        System.out.print("ID de la reserva a modificar: ");
        int idReserva = scanner.nextInt();
        
        // Cambiar la lógica según tus requisitos
        System.out.print("Nueva fecha (dd/MM/yyyy): ");
        String fechaNuevaInput = scanner.nextLine(); // Limpiar buffer
        Date nuevaFecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNuevaInput);

        System.out.print("Nueva duración: ");
        int nuevaDuracion = scanner.nextInt();
        
        System.out.print("Nuevo ID de pista: ");
        int nuevaIdPista = scanner.nextInt();
        
        if (gestorReservas.modReserva(idReserva, nuevaFecha, nuevaDuracion, nuevaIdPista)) {
            System.out.println("Reserva modificada con éxito.");
        } else {
            System.out.println("Error al modificar la reserva.");
        }
    }

    private static void cancelarReserva() {
        System.out.print("ID de la reserva a cancelar: ");
        int idReserva = scanner.nextInt();
        
        if (gestorReservas.cancelarReserva(idReserva)) {
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("Error al cancelar la reserva.");
        }
    }

    private static void listarReservasFuturas() {
        int count = gestorReservas.contarReservasFuturas();
        System.out.println("Número de reservas futuras: " + count);
        List<Reserva> reservas = gestorReservas.consultarReservasPorDiaYPista(new Date(), 1); // Ejemplo con fecha y pista
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas futuras.");
        } else {
            System.out.println("Reservas futuras:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
}
