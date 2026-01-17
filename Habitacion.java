public class Habitacion{
    private int numero;
    private double precioNoche;
    private EstadoHabitacion estado;

    public Habitacion(int numero, double precioNoche) {
        this.numero = numero;
        this.precioNoche = precioNoche;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }  

    public double getPrecioNoche() {
        return precioNoche;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void ocupar() {
        estado = EstadoHabitacion.OCUPADA;
    }

    public void liberar() {
        estado = EstadoHabitacion.DISPONIBLE;
    }

}
