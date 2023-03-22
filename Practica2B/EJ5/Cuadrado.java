public class Cuadrado extends Rectangulo{
   public Cuadrado() {

   }

    public Cuadrado(double lado) {
         super(lado, lado);
    }

    public Cuadrado(double lado, String color, boolean relleno) {
        super(lado, lado, color, relleno);
    }

    public double getLado() {
        return super.getAncho();
    }

    public void setLado(double lado) {
        super.setAncho(lado);
        super.setLargo(lado);
    }

    @Override
    public void setAncho(double ancho) {
        setLado(ancho);
    }

    @Override
    public void setLargo(double largo) {
        setLado(largo);
    }
}
