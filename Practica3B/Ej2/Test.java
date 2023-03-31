
public class Test {
    public static void main(String[] args) {
        ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();

        lista.comenzar();
        lista.agregarFinal(1);
        lista.agregarFinal(2);
        lista.agregarFinal(3);
        lista.agregarFinal(4);

        System.out.println(lista);
        ListaGenericaEnlazada<Integer> listaInvertida = new ListaGenericaEnlazada<Integer>();
        listaInvertida = lista.invertir();

        System.out.println(listaInvertida);
    }
}