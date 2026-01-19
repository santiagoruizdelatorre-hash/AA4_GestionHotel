import java.time.LocalDate;
import java.util.Scanner;
public class Hotel {
    private String nombre;
    private Habitacion[] habitaciones;
    private Reserva[] reservas;

   
    public void agregarHabitacion(Habitacion h){

    }
    public void crearReserva(String nombre, String dni, double telefono, LocalDate salida, String tipo) {

    }
    public Reserva buscarReservaPorId(String id){
        return null;
    }
    public Reserva comprobarReserva(LocalDate dia, String id){
        return null;
    }
    public Reserva cancelarReserva(String id){
        return null;

    }
    public Ticket generarTicket(String idReserva){
        return null;

    }
}
