import java.time.LocalDate;
import java.util.Scanner;

public class HotelView {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENU HOTEL =====");
        System.out.println("(1) Hacer reserva");
        System.out.println("(2) Comprobar reserva");
        System.out.println("(3) Cancelar reserva");
        System.out.println("(4) Sacar ticket");
        System.out.println("(5) Salir");
        System.out.print("Elige opción: ");

        String input = sc.nextLine();
        try {
            return Integer.parseInt(input.trim());
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

    public LocalDate pedirFecha(String texto) {
        System.out.print(texto + " (YYYY-MM-DD): ");
        String s = sc.nextLine();
        try {
            return LocalDate.parse(s.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public String pedirReservaId() {
        System.out.print("ID de reserva: ");
        return sc.nextLine();
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