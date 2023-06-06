package Modulo1.Practica2B.EJ5;

public abstract class Figura {
    private String color;
    private boolean relleno;

    public Figura() {
        this.color = "negro";
        this.relleno = false;
    }

    public Figura(String color, boolean relleno) {
        this.color = color;
        this.relleno = relleno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    @Override
    public String toString() {
        return "Figura{" + "color=" + color + ", relleno=" + relleno + '}';
    }

    public abstract double getArea();

    public abstract double getPerimetro();
}