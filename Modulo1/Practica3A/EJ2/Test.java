package Modulo1.Practica3A.EJ2;

import Clases.ListaDeEnteros.ListaDeEnterosEnlazada;


public class Test{
    public static void main(String[] args) {
        ListaDeEnterosEnlazada listaDesordenada = new ListaDeEnterosEnlazada();
        listaDesordenada.comenzar();
        ListaDeEnterosEnlazada listaOrdenada = new ListaDeEnterosEnlazada();


        listaDesordenada.agregarFinal(4);
        listaDesordenada.agregarFinal(2);
        listaDesordenada.agregarFinal(8);
        listaDesordenada.agregarFinal(424);
        listaDesordenada.agregarFinal(1);
        listaDesordenada.agregarFinal(99);
        listaDesordenada.agregarFinal(22);
        listaDesordenada.agregarFinal(54);
        listaDesordenada.agregarFinal(10);
        listaDesordenada.agregarFinal(40);
        listaDesordenada.agregarFinal(44);

        System.out.println(listaDesordenada.toString());
        listaOrdenada = listaDesordenada.ordernar();
       
        System.out.println(listaOrdenada.toString());
    }
}