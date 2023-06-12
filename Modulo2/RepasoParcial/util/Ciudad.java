package Modulo2.RepasoParcial.util;

public class Ciudad {
    private String nombre;
    private int limite;

    public Ciudad(String nombre, int limite) {
        this.nombre = nombre;
        this.limite = limite;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getLimite() {
        return this.limite;
    }
}
