package Modulo1.Practica5B.Ej3;

import Clases.ArbolGeneral.ArbolGeneral;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Trie{
    private ArbolGeneral<Character> a;

    public Trie() {
        a = new ArbolGeneral<Character>(null);
    }

    public void agregarPalabra(String palabra) {
        int len = palabra.length();
        ArbolGeneral<Character> arbol = a;
        for (int i = 0; i<len; i++) {
            ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
            char c = palabra.charAt(i);
            if (!hijos.esVacia()) {
                hijos.comenzar();
                int j = 0;
                for (j = 0; j<hijos.tamanio(); j++) {
                    if (hijos.elemento(j).getDato() >= c) {
                        break;
                    }
                }
                if ((j != hijos.tamanio()) && (hijos.elemento(j).getDato() ==c)) {
                    arbol = hijos.elemento(j);
                } else {
                    ArbolGeneral<Character> aux = new ArbolGeneral<Character>(c);
                    hijos.agregarEn(aux, j);
                    arbol = aux;
                }
            }
            else {
                ArbolGeneral<Character> aux = new ArbolGeneral<Character>(c);
                hijos.agregarInicio(aux);
                arbol = aux;
            }
        }
    }

    public ListaGenericaEnlazada<StringBuilder> palabrasQueEmpiezanCon(String prefijo) {
        ListaGenericaEnlazada<StringBuilder> lista = new ListaGenericaEnlazada<StringBuilder>();
        ArbolGeneral<Character> arbol = this.a;
        for (int i = 0; i<prefijo.length(); i++) {
            char car = prefijo.charAt(i);
            ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
            hijos.comenzar();
            int j = 0;
            while (!hijos.fin()) {
                ArbolGeneral<Character> act = hijos.proximo();
                if (act.getDato() >= car) {
                    break;
                }
                j++;
            }
            if(hijos.elemento(j) != null && hijos.elemento(j).getDato() == car) {
                arbol = hijos.elemento(j);
            } else {
                return null;
            }
        }
        StringBuilder palabra = new StringBuilder(prefijo);
        recorrerArbol(arbol, palabra, lista);
        return lista;
    }

    private void recorrerArbol(ArbolGeneral<Character> nodo, StringBuilder palabra, ListaGenerica<StringBuilder> lista) {
        if (nodo.esHoja()) {
            lista.agregarFinal(new StringBuilder(palabra));
            return;
        }
        ListaGenerica<ArbolGeneral<Character>> hijos = nodo.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
            ArbolGeneral<Character> hijo = hijos.proximo();
            recorrerArbol(hijo, palabra.append(hijo.getDato()), lista);
            palabra.deleteCharAt(palabra.length() - 1);
        }
    }

    public void ImprimirPorNiveles() {
        a.ImprimirPorNiveles();
    }
}