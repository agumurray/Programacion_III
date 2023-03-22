public class TestDeFigurasGeometricas {
    public static void main(String[] args) {
        Figura figuras[] = new Figura[3];

        figuras[0] = new Circulo(5, "rojo", true);
        figuras[1] = new Rectangulo(2, 3, "verde", false);
        figuras[2] = new Cuadrado(4, "azul", true);

        for(Figura figura : figuras){
            System.out.println(figura.toString());
        }
    }
}
