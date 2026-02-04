package modelo;


public abstract class Habitacion implements Facturable {
    
    private int numero;
    private double precioBase;
    private EstadoHabitacion estado;

    public Habitacion(int numero, double precioBase) {
        this.numero = numero;
        this.precioBase = precioBase;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    public int getNumero() {
        return numero;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    protected double getPrecioBase() {
        return precioBase;
    }

    @Override
    public double calcularPrecio(int noches) {
        return precioBase * noches;
    }
}

