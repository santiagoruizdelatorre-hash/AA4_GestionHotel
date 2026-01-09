import java.util.Scanner;

public class ControlHotel {
    private Hotel hotel;
    private Scanner sc;
    public void mostrarMenu(){
        System.out.println("==BIENVENIDO AL CONTROL DE HOTEL==");
        System.out.println("\nESTE ES NUESTRO MENU");
        System.out.println("1- Crear una reserva");
        System.out.println("2- Visualizar reservas");
        System.out.println("3-Cancelar reserva");
        System.err.println("4- Modificar reserva");

    }
}
