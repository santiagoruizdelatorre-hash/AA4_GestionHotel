public class HabitacionSimple extends Habitacion {
    public HabitacionSimple(int numero, double precioBase) {
        super(numero, precioBase);
    }

    @Override
    public double calcularPrecio(int noches) {
        return getPrecioBase() * noches;
    }
}