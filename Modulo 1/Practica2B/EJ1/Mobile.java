public class Mobile {
    private String marca;
    private String OS;
    private String modelo;
    private int costo;

    public Mobile(String marca, String OS, String modelo, int costo) {
        this.marca = marca;
        this.OS = OS;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "marca='" + marca + '\'' +
                ", OS='" + OS + '\'' +
                ", modelo='" + modelo + '\'' +
                ", costo=" + costo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mobile mobile = (Mobile) o;

        if (costo != mobile.costo) return false;
        if (marca != null ? !marca.equals(mobile.marca) : mobile.marca != null) return false;
        if (OS != null ? !OS.equals(mobile.OS) : mobile.OS != null) return false;
        return modelo != null ? modelo.equals(mobile.modelo) : mobile.modelo == null;
    }
}
