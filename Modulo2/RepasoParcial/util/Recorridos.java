package Modulo2.RepasoParcial.util;

import Clases.Grafo.Arista;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;
import Clases.ListaGenerica.utils.Cola;

public class Recorridos<T> {
    public ListaGenerica<T> dfs(Grafo<T> grafo) {
        int length = grafo.listaDeVertices().tamanio();
        boolean[] marca = new boolean[length];
        ListaGenerica<T> lista = new ListaGenericaEnlazada<>();
        for (int i = 0; i < length; i++) {
            if (!marca[i]) {
                this.dfs(i, grafo, lista, marca);
            }
        }
        return lista;
    }

    private void dfs(int i, Grafo<T> grafo, ListaGenerica<T> lista, boolean[] marca) {
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        lista.agregarFinal(v.dato());
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                this.dfs(j, grafo, lista, marca);
            }
        }
    }

    public ListaGenerica<T> bfs(Grafo<T> grafo) {
        int length = grafo.listaDeVertices().tamanio();
        boolean[] marca = new boolean[length];
        ListaGenerica<T> lista = new ListaGenericaEnlazada<>();
        for (int i = 0; i < length; i++) {
            if (!marca[i])
                this.bfs(i, grafo, lista, marca);
        }
        return lista;
    }

    private void bfs(int i, Grafo<T> grafo, ListaGenerica<T> lista, boolean[] marca) {
        ListaGenerica<Arista<T>> ady = null;
        Cola<Vertice<T>> q = new Cola<Vertice<T>>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while (!q.esVacia()) {
            Vertice<T> v = q.desencolar();
            lista.agregarFinal(v.dato());
            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while(!ady.fin()) {
                Arista<T> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]) {
                    Vertice<T> w = arista.verticeDestino();
                    marca[j] = true;
                    q.encolar(w);
                }
            }
        }
    }

    public ListaGenerica<ListaGenerica<Vertice<T>>> dfsConCosto(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenerica<Vertice<T>> lista;
        ListaGenerica<ListaGenerica<Vertice<T>>> recorridos = new ListaGenericaEnlazada<ListaGenerica<Vertice<T>>>();
        int costo = 0;
        for (int i = 0; i < marca.length; i++) {
            lista = new ListaGenericaEnlazada<Vertice<T>>();
            lista.agregarFinal(grafo.listaDeVertices().elemento(i));
            marca[i] = true;
            this.dfsConCosto(i, grafo, lista, marca, costo, recorridos);
            marca[i] = false;
        }
        return recorridos;
    }

    private void dfsConCosto(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> lista, boolean[] marca, int costo, ListaGenerica<ListaGenerica<Vertice<T>>> recorridos) {
        Vertice<T> vDestino = null;
        int p=0, j=0;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<T> arista = ady.proximo();
            j = arista.verticeDestino().posicion();
            if (!marca[j]) {
                p = arista.peso();
                if ((costo+p) >= 10) {
                    vDestino = arista.verticeDestino();
                    lista.agregarFinal(vDestino);
                    marca[j] = true;
                    if ((costo+p)==10) {
                        recorridos.agregarFinal(lista);
                    }
                    else {
                        this.dfsConCosto(j, grafo, lista, marca, (costo+p), recorridos);
                        lista.eliminar(vDestino);
                        marca[j] = false;
                    }
                }
            }
        }
    }
}
