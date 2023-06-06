package Modulo1.PracticasParcial.parcial2021;

import Clases.ArbolBinario.ArbolBinario;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Procesador { 
    private ArbolBinario<Integer> arbol;

    public Procesador(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ListaGenerica<ArbolBinario<Integer>> procesarArbol() {
        ListaGenerica<ArbolBinario<Integer>> lista = new ListaGenericaEnlazada<>();
        if (arbol.esHoja()) {
            if (arbol.getDato() <= 0)
                lista.agregarFinal(arbol);
            return lista;
        }
        
        ListaGenerica<ArbolBinario<Integer>> lista2 = new ListaGenericaEnlazada<>();
        if (arbol.tieneHijoIzquierdo()) {
            Procesador auxIzq = new Procesador(arbol.getHijoIzquierdo());
            lista = auxIzq.procesarArbol();
        }

        if (arbol.tieneHijoDerecho()) {
            Procesador auxDer = new Procesador(arbol.getHijoDerecho());
            lista2 = auxDer.procesarArbol();
        }
        lista2.comenzar();
        while (!lista2.fin()) {
            lista.agregarFinal(lista2.proximo());
        }
        if (!arbol.tieneHijoIzquierdo()) {
            if (arbol.getHijoDerecho().getDato() >= arbol.getDato())
                lista.agregarFinal(arbol);
        }
        else if (!arbol.tieneHijoDerecho()) {
            if (arbol.getHijoIzquierdo().getDato() >= arbol.getDato())
                lista.agregarFinal(arbol);
        }
        else {
            if ((arbol.getHijoDerecho().getDato() + arbol.getHijoIzquierdo().getDato()) >= arbol.getDato())
                lista.agregarFinal(arbol);
        
    }
    return lista;
}
}