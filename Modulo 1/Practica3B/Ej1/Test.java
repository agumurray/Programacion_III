public class Test {
    public static void main(String[] args) {
        ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();

        lista.comenzar();
        lista.agregarFinal(1);
        lista.agregarFinal(1);
        lista.agregarFinal(1);
        lista.agregarFinal(1);

        System.out.println(lista);
    }
}