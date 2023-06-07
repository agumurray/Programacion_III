package Clases.Grafo.utils;

import java.util.PriorityQueue;

import Clases.Grafo.Arista;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.ListaGenerica.ListaGenerica;

public class Dijkstra<T> {
    //O(|V|^2)
    public Costo[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> v) {
        if((!grafo.listaDeVertices().incluye(v)))
            return null;
        int length = grafo.listaDeVertices().tamanio();
        Costo[] costos = new Costo[length];
        boolean[] marca = new boolean[length];

        for (int i = 0; i < length; i++) {
            costos[i] = new Costo();
        }

        costos[v.posicion()].setMin(0);
        for (int i = 0; i < length; i++){
            int pos = verticeDesconocidoMenorDist(costos, marca);
            if(pos == -1)
                break;
            Vertice<T> U = grafo.listaDeVertices().elemento(pos);
            marca[pos] = true;
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> A = ady.proximo();
                Vertice<T> W = A.verticeDestino();
                if ((!marca[W.posicion()]) && (costos[W.posicion()].getMin() > costos[U.posicion()].getMin() + A.peso())) {
                    costos[W.posicion()].setMin(costos[U.posicion()].getMin() + A.peso());
                    costos[W.posicion()].setPrevio(U.posicion());
                }
            }
        }
        return costos;
    }
    
    private int verticeDesconocidoMenorDist(Costo[] costos, boolean[] marca) {
        int minDistancia = Integer.MAX_VALUE;
        int minPos = -1;

        for (int i = 0; i < costos.length; i++) {
            if ((!marca[i]) && (costos[i].getMin() < minDistancia)) {
                minDistancia = costos[i].getMin();
                minPos = i;
            }
        }
        return minPos;
    }


    public Costo[] dijkstraConHeap(Grafo<T> grafo, Vertice<T> v) {
        int length = grafo.listaDeVertices().tamanio();
        Costo[] costos = new Costo[length];
        if ((!grafo.listaDeVertices().incluye(v)))
            return null;
        boolean[] marca = new boolean[length];
        PriorityQueue<CostoHeap<T>> heap = new PriorityQueue<CostoHeap<T>>();
        for (int i = 0; i < length; i++) {
            costos[i] = new Costo();
        }

        costos[v.posicion()].setMin(0);
        heap.offer(new CostoHeap<T>(v.posicion(), 0));

        while (!heap.isEmpty()) {
            Vertice<T> U = grafo.listaDeVertices().elemento(heap.poll().getPos());
            if (marca[U.posicion()])
                continue;
            
            marca[U.posicion()] = true;

            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();

            while (!ady.fin()) {
                Arista<T> A = ady.proximo();
                Vertice<T> W = A.verticeDestino();
                if ((!marca[W.posicion()])
                        && (costos[W.posicion()].getMin() > costos[U.posicion()].getMin() + A.peso())) {
                    costos[W.posicion()].setMin(costos[U.posicion()].getMin() + A.peso());
                    costos[W.posicion()].setPrevio(U.posicion());
                    heap.offer(new CostoHeap<T>(W.posicion(), costos[W.posicion()].getMin()));
                }
            }
        }
        return costos;
    }
}