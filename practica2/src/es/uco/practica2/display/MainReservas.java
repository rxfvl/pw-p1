package es.uco.practica2.display;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import es.uco.practica2.business.*;

public class MainReservas {
	private static GestorReservas gestorReservas;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        gestorReservas = new GestorReservas(); // Inicia el gestor de reservas

        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- Gestión de Reservas ---");
            System.out.println("1. Crear Reserva Individual");
            System.out.println("2. Crear Reserva con Bono");
            System.out.println("3. Modificar Reserva");
            System.out.println("4. Cancelar Reserva");
            System.out.println("5. Listar Reservas Futuras");
            System.out.println("6. Consultar Reserva");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearReservaIndivual();
                    break;
                case 2:
                    crearReservaBono();
                    break;
                case 3:
                    modificarReserva();
                    break;
                case 4:
                    cancelarReserva();
                    break;
                case 5:
                    listarReservasFuturas();
                    break;
                case 6:
                    consultarReserva();
                    break;
                case 0:
                    salir = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }

    private static void crearReservaIndivual() {
    	System.out.print("Fecha (dd/MM/yyyy): ");
        String fechaInput = scanner.nextLine(); // Limpiar buffer
        Date fecha;
        float precio, descuento;
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
        
        System.out.print("Duración (horas): ");
        int duracion = scanner.nextInt();
        
        System.out.print("ID de pista: ");
        int idPista = scanner.nextInt();
        
        System.out.print("Tipo de reserva (0=adultos; 1=infantil; 2=familiar): ");
        int tipo_reserva = scanner.nextInt();
        if(tipo_reserva < 0 || tipo_reserva > 2)
        {
        	System.out.println("Valor incorrecto. ");
        	return;
        }
        if(tipo_reserva==0)
        {
        	precio=10;
        	descuento=0;
        }
        else if(tipo_reserva==1)
        {
        	precio=5;
        	descuento=5;
        }
        else
        {
        	precio=15;
        	descuento=5;
        }
        
        System.out.print("Número de niños: ");
        int num_ninios = scanner.nextInt();
        
        System.out.print("Número de adultos: ");
        int num_adultos = scanner.nextInt();
        
        System.out.print("Correo electrónico: ");
        scanner.nextLine();
        String correo = scanner.nextLine();
        
        ReservasDTO reserva = gestorReservas.crearReservaIndividual(fecha, duracion, idPista, precio, descuento, tipo_reserva, num_ninios, num_adultos, correo);
        
        if (reserva.getId_jugador() != -1) {
            System.out.println("Reserva creada con éxito: " + reserva);
        } else {
            System.out.println("Error al crear la reserva.");
        }
    }
    
    private static void crearReservaBono() {
    	System.out.print("Fecha (dd/MM/yyyy): ");
        String fechaInput = scanner.nextLine(); // Limpiar buffer
        Date fecha;
        float precio,descuento;
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
        
        System.out.print("Duración (horas): ");
        int duracion = scanner.nextInt();
        
        System.out.print("ID de pista: ");
        int idPista = scanner.nextInt();
        
        System.out.print("Tipo de reserva (0=adultos; 1=infantil; 2=familiar): ");
        int tipo_reserva = scanner.nextInt();
        if(tipo_reserva < 0 || tipo_reserva > 2)
        {
        	System.out.println("Valor incorrecto. ");
        	return;
        }
        if(tipo_reserva==0)
        {
        	precio=10;
        	descuento=0;
        }
        else if(tipo_reserva==1)
        {
        	precio=5;
        	descuento=5;
        }
        else
        {
        	precio=15;
        	descuento=5;
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
        
        ReservasDTO reserva = gestorReservas.crearReservaBono(fecha, duracion, idPista, precio, descuento, tipo_reserva, num_ninios, num_adultos, id_bono, correo);
        
        if (reserva.getId_jugador() != -1) {
            System.out.println("Reserva creada con éxito: " + reserva);
        } else {
            System.out.println("Error al crear la reserva.");
        }
    }

    private static void modificarReserva() {
    	float precio,descuento;
        
    	System.out.print("ID de pista asignada a la reserva a modificar: ");
        int IdPista = scanner.nextInt();
        scanner.nextLine();//limpiar buffer
        // Cambiar la lógica según tus requisitos
        System.out.print("Fecha de la reserva a modificar (dd/MM/yyyy): ");
        String fechaNuevaInput = scanner.nextLine(); 
        Date Fecha;
		try {
			Fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNuevaInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

        System.out.print("Nueva duración: ");
        int nuevaDuracion = scanner.nextInt();
        
        System.out.print("Tipo de reserva (0=adultos; 1=infantil; 2=familiar): ");
        int tipo_reserva = scanner.nextInt();
        if(tipo_reserva < 0 || tipo_reserva > 2)
        {
        	System.out.println("Valor incorrecto. ");
        	return;
        }
        if(tipo_reserva==0)
        {
        	precio=10;
        	descuento=0;
        }
        else if(tipo_reserva==1)
        {
        	precio=5;
        	descuento=5;
        }
        else
        {
        	precio=15;
        	descuento=5;
        }
        
        System.out.print("Nuevo número de niños: ");
        int num_ninios = scanner.nextInt();
        
        System.out.print("Nuevo número de adultos: ");
        int num_adultos = scanner.nextInt();
        
        if (gestorReservas.modificarReserva(Fecha, nuevaDuracion, IdPista, precio, descuento, tipo_reserva, num_ninios, num_adultos)) {
            System.out.println("Reserva modificada con éxito.");
        } else {
            System.out.println("Error al modificar la reserva.");
        }
    }

    private static void cancelarReserva() {
    	System.out.print("ID de pista asignada a la reserva a cancelar: ");
        int IdPista = scanner.nextInt();
        scanner.nextLine();//limpiar buffer
        // Cambiar la lógica según tus requisitos
        System.out.print("Fecha de la reserva a cancelar (dd/MM/yyyy): ");
        String fechaNuevaInput = scanner.nextLine(); // Limpiar buffer
        Date Fecha;
		try {
			Fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNuevaInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

        if (gestorReservas.cancelarReserva(IdPista,Fecha)) {
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("Error al cancelar la reserva.");
        }
    }

    private static void listarReservasFuturas() {
        int count = gestorReservas.contarReservasFuturas();
        System.out.println("Número de reservas futuras: " + count);
        List<ReservasDTO> reservas = gestorReservas.consultarReservasFuturas(); // Ejemplo con fecha y pista
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas futuras.");
        } else {
            System.out.println("Reservas futuras:");
            for (ReservasDTO reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
    
    private static void consultarReserva()
    {
    	System.out.print("ID de pista asignada a la reserva a consultar: ");
        int IdPista = scanner.nextInt();
        // Cambiar la lógica según tus requisitos
        scanner.nextLine();
        System.out.print("Fecha de la reserva a consultar (dd/MM/yyyy): ");
        String fechaNuevaInput = scanner.nextLine();
        Date Fecha;
		try {
			Fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNuevaInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

        ReservasDTO reserva = gestorReservas.consultarReserva(IdPista,Fecha);
        reserva.toString();
    }
}
