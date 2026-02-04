package modelo;


public class ResultadoOperacion {
    private boolean ok;
    private String mensaje;

    public ResultadoOperacion(boolean ok, String mensaje) {
        this.ok = ok;
        this.mensaje = mensaje;
    }

    public boolean isOK() {
        return ok;
    }

    public String getMensaje() {
        return mensaje;
    }
}

