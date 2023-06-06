package Clases.Grafo.utils;
public class Costo implements Comparable<Costo> {
    private int min;
    private int previo;

    public Costo() {
        this.min = Integer.MAX_VALUE;
        this.previo = 0;
    }

    public int getMin() {
        return this.min;
    }

    public int getPrevio() {
        return this.previo;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setPrevio(int previo) {
        this.previo = previo;
    }

    public String toString() {
        return ("Costo minimo: " + min + "\nVertice previo: " + previo);
    }

    public int compareTo(Costo otro) {
        return Integer.compare(min, otro.getMin());
    }
}
