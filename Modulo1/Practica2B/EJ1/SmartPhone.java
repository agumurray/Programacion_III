package Modulo1.Practica2B.EJ1;

public class SmartPhone extends Mobile {
   private int numero;   

    public SmartPhone(String marca, String OS, String modelo, int costo, int numero) {
         super(marca, OS, modelo, costo);
         this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "numero=" + numero +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;   
        if (!(o instanceof SmartPhone)) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return numero == that.numero; 
    }

}
