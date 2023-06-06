package Modulo1.Practica3B.Ej1;

import Clases.ListaGenerica.ListaGenericaEnlazada;

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