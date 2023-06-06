package Modulo1.Practica4B.Ej4;

import Clases.ArbolBinario.ArbolBinario;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Test {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
        ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        arbolBinarioB.printPreorden();
        System.out.println("Fin arbol");

        ListaGenericaEnlazada<Integer> trayectoriasPesadas = new ListaGenericaEnlazada<Integer>();

        trayectoriasPesadas = ArbolBinario.trayectoriaPesada(arbolBinarioB);

        System.out.println(trayectoriasPesadas);
    }
}