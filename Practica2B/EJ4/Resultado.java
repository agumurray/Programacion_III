public class Resultado {
    private int min;
    private int max;
    private double promedio;

    public Resultado(int max, int min, double promedio) {
        this.max = max;
        this.min = min;
        this.promedio = promedio;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String toString() {
        return "El maximo es: " + max + " El minimo es: " + min + " El promedio es: " + promedio;
    }
}
