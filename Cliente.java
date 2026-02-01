public class Cliente {
    
    private String dni;
    private String nombre;
    private double telefono;

    public Cliente(String dni, String nombre, double telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
    public double getTelefono(){
        return telefono;
    }
}
