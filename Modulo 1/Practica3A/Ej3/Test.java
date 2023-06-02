public class Test {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada listaA = new ListaDeEnterosEnlazada();
        listaA.comenzar();
        ListaDeEnterosEnlazada listaB = new ListaDeEnterosEnlazada();
        listaB.comenzar();

        listaA.agregarFinal(1);
        listaA.agregarFinal(3);
        listaA.agregarFinal(5);
        listaA.agregarFinal(7);
        listaA.agregarFinal(9);

        listaB.agregarFinal(20);
        listaB.agregarFinal(40);
        listaB.agregarFinal(60);
        listaB.agregarFinal(80);

        ListaDeEnterosEnlazada listaC = new ListaDeEnterosEnlazada();
        listaC = listaB.combinarOrdenado(listaA);

        System.out.println(listaC.toString());
    }
}