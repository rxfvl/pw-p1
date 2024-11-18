package es.uco.practica2.display;

// Importación de clases necesarias
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import es.uco.practica2.business.*;

// Clase principal para la gestión de reservas
public class MainReservas {
    private static GestorReservas gestorReservas; // Gestor de reservas
    private static Scanner scanner; // Escáner para entrada de datos

    // Método principal de ejecución
    public static void main(String[] args) {
        scanner = new Scanner(System.in); // Inicializa el escáner
        gestorReservas = new GestorReservas(); // Inicia el gestor de reservas

        boolean salir = false; // Bandera para controlar la salida del menú
        
        // Bucle principal para el menú de gestión de reservas
        while (!salir) {
            System.out.println("\n--- Gestión de Reservas ---");
            // Opciones del menú
            System.out.println("1. Crear Reserva Individual");
            System.out.println("2. Crear Reserva con Bono");
            System.out.println("3. Modificar Reserva");
            System.out.println("4. Cancelar Reserva");
            System.out.println("5. Listar Reservas Futuras");
            System.out.println("6. Consultar Reserva");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt(); // Lee la opción seleccionada
            scanner.nextLine(); // Limpiar el buffer

            // Selección de acción según la opción elegida
            switch (opcion) {
                case 1:
                    crearReservaIndivual(); // Crear reserva individual
                    break;
                case 2:
                    crearReservaBono(); // Crear reserva con bono
                    break;
                case 3:
                    modificarReserva(); // Modificar reserva existente
                    break;
                case 4:
                    cancelarReserva(); // Cancelar una reserva
                    break;
                case 5:
                    listarReservasFuturas(); // Listar reservas futuras
                    break;
                case 6:
                    consultarReserva(); // Consultar detalles de una reserva
                    break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo."); // Manejo de opciones inválidas
            }
        }
    }

    // Método para crear una reserva individual
    private static void crearReservaIndivual() {
        // Solicitud de datos para la reserva
        System.out.print("Fecha (dd/MM/yyyy): ");
        String fechaInput = scanner.nextLine();
        Date fecha;
        float precio, descuento;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInput); // Parseo de la fecha
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de excepciones
            return; // Salida del método en caso de error
        }
        
        System.out.print("Duración (horas): ");
        int duracion = scanner.nextInt();
        
        System.out.print("ID de pista: ");
        int idPista = scanner.nextInt();
        
        System.out.print("Tipo de reserva (0=adultos; 1=infantil; 2=familiar): ");
        int tipo_reserva = scanner.nextInt();
        if (tipo_reserva < 0 || tipo_reserva > 2) {
            System.out.println("Valor incorrecto. ");
            return; // Salida del método si el tipo es inválido
        }
        
        // Asignación de precios y descuentos según el tipo de reserva
        if (tipo_reserva == 0) {
            precio = 10;
            descuento = 0;
        } else if (tipo_reserva == 1) {
            precio = 5;
            descuento = 5;
        } else {
            precio = 15;
            descuento = 5;
        }
        
        System.out.print("Número de niños: ");
        int num_ninios = scanner.nextInt();
        
        System.out.print("Número de adultos: ");
        int num_adultos = scanner.nextInt();
        
        System.out.print("Correo electrónico: ");
        scanner.nextLine();
        String correo = scanner.nextLine();
        
        // Creación de la reserva
        ReservasDTO reserva = gestorReservas.crearReservaIndividual(fecha, duracion, idPista, precio, descuento, tipo_reserva, num_ninios, num_adultos, correo);
        
        if (reserva.getId_jugador() != -1) {
            System.out.println("Reserva creada con éxito: " + reserva); // Confirmación de éxito
        } else {
            System.out.println("Error al crear la reserva."); // Mensaje de error
        }
    }
    
    // Método para crear una reserva utilizando un bono
    private static void crearReservaBono() {
        // Solicitud de datos para la reserva
        System.out.print("Fecha (dd/MM/yyyy): ");
        String fechaInput = scanner.nextLine();
        Date fecha;
        float precio, descuento;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInput); // Parseo de la fecha
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de excepciones
            return; // Salida del método en caso de error
        }
        
        System.out.print("Duración (horas): ");
        int duracion = scanner.nextInt();
        
        System.out.print("ID de pista: ");
        int idPista = scanner.nextInt();
        
        System.out.print("Tipo de reserva (0=adultos; 1=infantil; 2=familiar): ");
        int tipo_reserva = scanner.nextInt();
        if (tipo_reserva < 0 || tipo_reserva > 2) {
            System.out.println("Valor incorrecto. ");
            return; // Salida del método si el tipo es inválido
        }
        
        // Asignación de precios y descuentos según el tipo de reserva
        if (tipo_reserva == 0) {
            precio = 10;
            descuento = 0;
        } else if (tipo_reserva == 1) {
            precio = 5;
            descuento = 5;
        } else {
            precio = 15;
            descuento = 5;
        }
        
        System.out.print("Número de niños: ");
        int num_ninios = scanner.nextInt();
        
        System.out.print("Número de adultos: ");
        int num_adultos = scanner.nextInt();
        
        System.out.print("Identificador de su bono: ");
        int id_bono = scanner.nextInt();
        
        System.out.print("Correo electrónico: ");
        scanner.nextLine();
        String correo = scanner.nextLine();
        
        // Creación de la reserva con bono
        ReservasDTO reserva = gestorReservas.crearReservaBono(fecha, duracion, idPista, precio, descuento, tipo_reserva, num_ninios, num_adultos, id_bono, correo);
        
        if (reserva.getId_jugador() != -1) {
            System.out.println("Reserva creada con éxito: " + reserva); // Confirmación de éxito
        } else {
            System.out.println("Error al crear la reserva."); // Mensaje de error
        }
    }

    // Método para modificar una reserva existente
    private static void modificarReserva() {
        float precio, descuento;
        
        System.out.print("ID de pista asignada a la reserva a modificar: ");
        int IdPista = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        // Solicitud de nueva fecha para la reserva
        System.out.print("Fecha de la reserva a modificar (dd/MM/yyyy): ");
        String fechaNuevaInput = scanner.nextLine();
        Date Fecha;
        try {
            Fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNuevaInput); // Parseo de la nueva fecha
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de excepciones
            return; // Salida del método en caso de error
        }

        System.out.print("Nueva duración: ");
        int nuevaDuracion = scanner.nextInt();
        
        System.out.print("Tipo de reserva (0=adultos; 1=infantil; 2=familiar): ");
        int tipo_reserva = scanner.nextInt();
        if (tipo_reserva < 0 || tipo_reserva > 2) {
            System.out.println("Valor incorrecto. ");
            return; // Salida del método si el tipo es inválido
        }
        
        // Asignación de precios y descuentos según el nuevo tipo de reserva
        if (tipo_reserva == 0) {
            precio = 10;
            descuento = 0;
        } else if (tipo_reserva == 1) {
            precio = 5;
            descuento = 5;
        } else {
            precio = 15;
            descuento = 5;
        }
        
        System.out.print("Nuevo número de niños: ");
        int num_ninios = scanner.nextInt();
        
        System.out.print("Nuevo número de adultos: ");
        int num_adultos = scanner.nextInt();
        
        // Modificación de la reserva
        if (gestorReservas.modificarReserva(Fecha, nuevaDuracion, IdPista, precio, descuento, tipo_reserva, num_ninios, num_adultos)) {
            System.out.println("Reserva modificada con éxito."); // Confirmación de éxito
        } else {
            System.out.println("Error al modificar la reserva."); // Mensaje de error
        }
    }

    // Método para cancelar una reserva existente
    private static void cancelarReserva() {
        System.out.print("ID de pista asignada a la reserva a cancelar: ");
        int IdPista = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        // Solicitud de fecha de la reserva a cancelar
        System.out.print("Fecha de la reserva a cancelar (dd/MM/yyyy): ");
        String fechaNuevaInput = scanner.nextLine();
        Date Fecha;
        try {
            Fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNuevaInput); // Parseo de la fecha
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de excepciones
            return; // Salida del método en caso de error
        }

        // Cancelación de la reserva
        if (gestorReservas.cancelarReserva(IdPista, Fecha)) {
            System.out.println("Reserva cancelada con éxito."); // Confirmación de éxito
        } else {
            System.out.println("Error al cancelar la reserva."); // Mensaje de error
        }
    }

    // Método para listar las reservas futuras
    private static void listarReservasFuturas() {
        int count = gestorReservas.contarReservasFuturas(); // Contar reservas
        System.out.println("Número de reservas futuras: " + count);
        List<ReservasDTO> reservas = gestorReservas.consultarReservasFuturas(); // Consultar reservas futuras
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas futuras."); // Mensaje si no hay reservas
        } else {
            System.out.println("Reservas futuras:");
            for (ReservasDTO reserva : reservas) {
                System.out.println(reserva); // Listar reservas
            }
        }
    }
    
    // Método para consultar una reserva
    private static void consultarReserva() {
        System.out.print("ID de pista asignada a la reserva a consultar: ");
        int IdPista = scanner.nextInt(); // Leer ID de pista
        scanner.nextLine();
        
        // Solicitud de fecha de la reserva a consultar
        System.out.print("Fecha de la reserva a consultar (dd/MM/yyyy): ");
        String fechaNuevaInput = scanner.nextLine();
        Date Fecha;
        try {
            Fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNuevaInput); // Parseo de la fecha
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de excepciones
            return; // Salida del método en caso de error
        }

        // Consultar la reserva
        ReservasDTO reserva = gestorReservas.consultarReserva(IdPista, Fecha);
        reserva.toString(); // Convertir registro a cadena
    }
}
