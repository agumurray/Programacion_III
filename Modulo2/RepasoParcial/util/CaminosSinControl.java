package Modulo2.RepasoParcial.util;

import Clases.Grafo.Arista;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class CaminosSinControl {
    private Grafo<String> mapa;
    public CaminosSinControl(Grafo<String> mapa) {
        this.mapa = mapa;
    }

    public ListaGenerica<ListaGenerica<String>> devolverCaminos(String origen, String destino) {
        //supongo que ambas ciudades existen en el mapa
        int length = mapa.listaDeVertices().tamanio();
        ListaGenerica<ListaGenerica<String>> caminos = new ListaGenericaEnlazada<ListaGenerica<String>>();
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        boolean marca[] = new boolean[length];
        Vertice<String> verticeOrigen = null;
        for (int i = 0; i < length; i++){
            if (mapa.listaDeVertices().elemento(i).dato().equals(origen))
                verticeOrigen = mapa.listaDeVertices().elemento(i);
        }
        int i = verticeOrigen.posicion();
        this.devolverCaminos(i, mapa, destino, marca, caminos, camino);
        return caminos;
    }

    private void devolverCaminos(int i, Grafo<String> mapa, String destino, boolean[] marca, ListaGenerica<ListaGenerica<String>> caminos, ListaGenerica<String> camino) {
        Vertice<String> v = this.mapa.listaDeVertices().elemento(i);
        camino.agregarFinal(v.dato());
        if (v.dato().equals(destino)) {
            caminos.agregarFinal(copia(camino));
            return;
        }
        marca[i] = true;
        ListaGenerica<Arista<String>> ady = mapa.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista = ady.proximo();
            Vertice<String> vertice = arista.verticeDestino();
            int j = vertice.posicion();
            if (!marca[j] && arista.peso() == 0) {
                this.devolverCaminos(j, mapa, destino, marca, caminos, camino);
                camino.eliminarEn(camino.tamanio() - 1);
                marca[j] = false;
            }
        }
    }

    private ListaGenerica<String> copia (ListaGenerica<String> lista) {
        ListaGenerica<String> copia = new ListaGenericaEnlazada<String>();
        lista.comenzar();
        while (!lista.fin()) {
            copia.agregarFinal(lista.proximo());
        }
        return copia;
    }
    
}
