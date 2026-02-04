public class HabitacionDoble extends Habitacion {
    private double suplemento;

    public HabitacionDoble(int numero, double precioBase, double suplemento) {
        super(numero, precioBase);
        this.suplemento = suplemento;
    }

    @Override
    public double calcularPrecio(int noches) {
        return (getPrecioBase() + suplemento) * noches;
    }
}

