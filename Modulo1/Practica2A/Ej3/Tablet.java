package Modulo1.Practica2A.Ej3;

public class Tablet {
    private String marca;
    private String sistemaOperativo;
    private String modelo;
    private double costo;
    private float pulgadas;

    public Tablet(String marca, String sistemaOperativo, String modelo, double costo, float pulgadas) {
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
        this.modelo = modelo;
        this.costo = costo;
        this.pulgadas = pulgadas;
    }

    public String getMarca() {
        return this.marca;
    }
    public String getSistemaOperativo() {
        return this.sistemaOperativo;
    }    
    public String getModelo() {
        return this.modelo;
    }    
    public double getCosto() {
        return this.costo;
    }    
    public float getPulgadas() {
        return this.pulgadas;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }    
    public void setCosto(double costo) {
        this.costo = costo;
    }    
    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    String devolverDatos() {
        return ("Modelo: " + this.modelo + "OS: " + this.sistemaOperativo + "Marca: " + this.marca + "Costo: " + this.costo + "Pulgadas: " + this.pulgadas);
    }
}