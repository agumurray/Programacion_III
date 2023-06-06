package Clases.Grafo.utils;

import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.Grafo.Arista;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.utils.Cola;

public class GradosDeSeparacion {
    public int maximoGradoDeSeparacion(Grafo<String> grafo) {
        int len = grafo.listaDeVertices().tamanio();
        int max = -1;
        int aux;
        for (int i = 0; i < len; i++) {
            aux = maximoGradoDeSeparacion(i, grafo);
            if (aux>max)
                max = aux;
        }
        return max;
    }

    private int maximoGradoDeSeparacion(int i, Grafo<String> grafo) {
        ListaGenerica<Arista<String>> ady = null;
        Cola<Vertice<String>> cola = new Cola<Vertice<String>>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int[] distancias = new int[grafo.listaDeVertices().tamanio()];
        cola.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while(!cola.esVacia()) {
            Vertice<String> v = cola.desencolar();
            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]) {
                    marca[j] = true;
                    cola.encolar(arista.verticeDestino());
                    distancias[arista.verticeDestino().posicion()] = distancias[v.posicion()] + 1;

                }
            }
        }
        int distanciaMaxima = -1;
        for (int k = 0; k < distancias.length; k++) {
            if (distancias[k] > distanciaMaxima)
                distanciaMaxima = distancias[k];
        }
        return distanciaMaxima;
    }
}
