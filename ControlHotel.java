import java.time.LocalDate;

public class ControlHotel {
    private Hotel hotel;
    private HotelView view;

    public ControlHotel() {
        this.hotel = new Hotel("Hotel MVC");
        this.view = new HotelView();

        // Habitaciones de ejemplo (para que el programa funcione al ejecutar)
        hotel.agregarHabitacion(new HabitacionSimple(101, 50));
        hotel.agregarHabitacion(new HabitacionSimple(102, 50));
        hotel.agregarHabitacion(new HabitacionDoble(201, 70, 15));
        hotel.agregarHabitacion(new HabitacionDoble(202, 70, 15));
        hotel.agregarHabitacion(new HabitacionSuite(301, 120, 40));
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            int op = view.mostrarMenu();

            switch (op) {
                case 1 -> opcionHacerReserva();
                case 2 -> opcionComprobarReserva();
                case 3 -> opcionCancelarReserva();
                case 4 -> opcionSacarTicket();
                case 5 -> {
                    view.mostrarMensaje("¡Hasta luego!");
                    salir = true;
                }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }

    public void opcionHacerReserva() {
        String nombre = view.pedirNombre();
        String dni = view.pedirDni();
        String telefono = view.pedirTelefono();
        String tipo = view.pedirTipoHabitacion();

        LocalDate entrada = view.pedirFecha("Fecha entrada");
        LocalDate salida = view.pedirFecha("Fecha salida");

        ResultadoOperacion res = hotel.crearReserva(nombre, dni, telefono, entrada, salida, tipo);
        view.mostrarMensaje(res.getMensaje());
    }

    public void opcionComprobarReserva() {
        LocalDate dia = view.pedirFecha("Día a comprobar");
        String id = view.pedirReservaId();

        ResultadoOperacion res = hotel.comprobarReserva(dia, id);
        view.mostrarMensaje(res.getMensaje());
    }

    public void opcionCancelarReserva() {
        String id = view.pedirReservaId();
        ResultadoOperacion res = hotel.cancelarReserva(id);
        view.mostrarMensaje(res.getMensaje());
    }

    public void opcionSacarTicket() {
        String id = view.pedirReservaId();
        Ticket t = hotel.generarTicket(id);
        view.mostrarTicket(t);
    }

    public static void main(String[] args) {
        new ControlHotel().mostrarMenu();
    }
}