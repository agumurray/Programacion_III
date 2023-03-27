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

        listaB.agregarFinal(2);
        listaB.agregarFinal(4);
        listaB.agregarFinal(6);
        listaB.agregarFinal(8);
        listaB.agregarFinal(10);
        listaB.agregarFinal(44);
        listaB.agregarFinal(55);

        ListaDeEnterosEnlazada listaC = new ListaDeEnterosEnlazada();
        listaC = listaB.combinarOrdenado(listaA);

        System.out.println(listaC.toString());
    }
}