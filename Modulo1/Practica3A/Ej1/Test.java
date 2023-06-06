package Modulo1.Practica3A.Ej1;

import java.util.Scanner;
import Clases.ListaDeEnteros.ListaDeEnterosEnlazada;

public class Test {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese un valor para agregarlo a la lista: ");
        n = in.nextInt();
        while (n != -1) {
            lista.agregarFinal(n);
            System.out.println("Ingrese un valor para agregarlo a la lista: ");
            n = in.nextInt();
        }
        System.out.println(lista.toString());
        in.close();

        imprimirInvertido(lista, lista.tamanio() -1);
    }

    public static void imprimirInvertido(ListaDeEnterosEnlazada lista, int tamanio) {
        System.out.println(lista.elemento(tamanio));
        if (tamanio!=0) {
           imprimirInvertido(lista, tamanio - 1); 
        }
    }
}