public class Tablet extends Mobile {
    private int pulgadas;
    
    public Tablet(String marca, String OS, String modelo, int costo, int pulgadas) {
        super(marca, OS, modelo, costo);
        this.pulgadas = pulgadas;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "pulgadas=" + pulgadas +
                "} " + super.toString();
    }
}
