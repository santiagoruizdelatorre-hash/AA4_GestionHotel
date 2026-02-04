package vista;

import modelo.*;

import java.util.Date;
import java.util.Scanner;

public class MenuHotel {

    private Scanner sc;

    public MenuHotel() {
        sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n===== MENU HOTEL =====");
        System.out.println("1) Hacer reserva");
        System.out.println("2) Comprobar reserva");
        System.out.println("3) Cancelar reserva");
        System.out.println("4) Sacar ticket");
        System.out.println("5) Salir");
        System.out.print("Elige opción: ");

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public String pedirNombre() {
        System.out.print("Nombre: ");
        return sc.nextLine();
    }

    public String pedirDni() {
        System.out.print("DNI: ");
        return sc.nextLine();
    }

    public String pedirTelefono() {
        System.out.print("Teléfono: ");
        return sc.nextLine();
    }

    public String pedirTipoHabitacion() {
        System.out.print("Tipo (simple/doble/suite): ");
        return sc.nextLine();
    }

    public String pedirReservaId() {
        System.out.print("ID de reserva: ");
        return sc.nextLine();
    }

    // 👉 SOLO Date + Scanner (dd/MM/yyyy)
    public Date pedirFecha(String texto) {
        System.out.print(texto + " (dd/MM/yyyy): ");
        String fecha = sc.nextLine();

        try {
            String[] partes = fecha.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]) - 1;
            int anio = Integer.parseInt(partes[2]) - 1900;

            return new Date(anio, mes, dia);
        } catch (Exception e) {
            return null;
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarTicket(Ticket t) {
        if (t == null) {
            System.out.println("No se pudo generar el ticket.");
        } else {
            System.out.println(t.generarTexto());
        }
    }
}
