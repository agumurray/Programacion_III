package Modulo1.Practica3B.Ej5;

import Clases.ListaGenerica.utils.Cola;

public class TestCola {
   public static void main(String[] args) {
    Cola<Integer> cola = new Cola<Integer>();

    cola.encolar(1);
    cola.encolar(2);
    cola.encolar(3);
    cola.encolar(4);

    int aux;
    aux = cola.desencolar();
    aux = cola.desencolar();
    aux = cola.desencolar();

    System.out.println(aux);
    System.out.println(cola.getTope());
   } 
}
