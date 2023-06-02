public class Test {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();

        lista.agregarFinal(10);
        lista.agregarFinal(2);
        lista.agregarFinal(1);
        lista.agregarFinal(4);
        lista.agregarFinal(7);
        lista.agregarFinal(5);

        System.out.println(lista.toString());

        lista = lista.mergeSort(lista);

        System.out.println(lista.toString());
    }
}