package Clases.Grafo.utils;

import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.Grafo.Arista;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;
import Clases.ListaGenerica.utils.Cola;

public class Algoritmos<T> {
    public ListaGenericaEnlazada<Vertice<T>> dfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenericaEnlazada<Vertice<T>> lis = new ListaGenericaEnlazada<Vertice<T>>();
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.dfs(i, grafo, lis, marca);
        }
        return lis;
    }

    private void dfs(int i, Grafo<T> grafo, ListaGenericaEnlazada<Vertice<T>> lis,boolean[] marca) {
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        lis.agregarFinal(v);
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            int j = adyacentes.proximo().verticeDestino().posicion();
            if (!marca[j])
                this.dfs(j, grafo,lis, marca);
        }
    }

    public void bfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.bfs(i, grafo, marca);
        }
    }

    private void bfs(int i, Grafo<T> grafo, boolean[] marca) {
        ListaGenerica<Arista<T>> ady = null;
        Cola<Vertice<T>> q = new Cola<Vertice<T>>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while (!q.esVacia()) {
            Vertice<T> v = q.desencolar();
            System.out.println(v.dato());
            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
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


    public boolean subgrafoCudrado(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < marca.length; i++) {
            boolean[] enRecursion = new boolean[grafo.listaDeVertices().tamanio()];
            if (subgrafoCuadrado(i, grafo, marca, enRecursion) == 4)
                return true;
        }
        return false;
    }

    private int subgrafoCuadrado(int i, Grafo<T> grafo, boolean[] marca, boolean[] enRecursion) {
        marca[i] = true;
        enRecursion[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
        adyacentes.comenzar();
        int cant = 0;
        while (!adyacentes.fin()) {
            int j = adyacentes.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                cant += subgrafoCuadrado(j, grafo, marca, enRecursion);
                if (cant > 0) 
                    return (cant+1);
            }
            else {
                if (enRecursion[j]) {
                    cant++;
                }
            }
        }
        enRecursion[i] = false;
        return cant;
    }

    public int getGrado(Grafo<T> grafo) {
        int grado = 0;
        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        while (!vertices.fin()) {
            Vertice<T> v = vertices.proximo();
            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
            if (adyacentes.tamanio() > grado) {
                grado = adyacentes.tamanio();
            }
        }
        return grado;
    }

    public boolean tieneCiclo(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i]) {
                boolean[] enRecursion = new boolean[grafo.listaDeVertices().tamanio()];
                if (this.tieneCiclo(i, grafo, marca, enRecursion)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tieneCiclo(int i, Grafo<T> grafo, boolean[] marca, boolean[] enRecursion) {
        marca[i] = true;
        enRecursion[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            int j = adyacentes.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                if (this.tieneCiclo(j, grafo, marca, enRecursion)) {
                    return true;
                }
            }
            else {
                if (enRecursion[j]) {
                    return true;
                }
            }
        }
        enRecursion[i] = false;
        return false;
    }

}
