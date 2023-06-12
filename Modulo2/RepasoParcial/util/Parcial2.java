package Modulo2.RepasoParcial.util;

import Clases.Grafo.Arista;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Parcial2 {
    public ListaGenerica<Ciudad2> resolver(Grafo<Ciudad2> ciudades, String origen, String destino, int minFase) {
        int length = ciudades.listaDeVertices().tamanio();
        boolean marca[] = new boolean[length];
        ListaGenerica<Ciudad2> camino = new ListaGenericaEnlazada<>();
        Vertice<Ciudad2> verticeDestino = null;
        Vertice<Ciudad2> verticeOrigen = null;
        for (int i = 0; i < length; i++) {
            if (ciudades.listaDeVertices().elemento(i).dato().getNombre().equals(origen))
                verticeOrigen = ciudades.listaDeVertices().elemento(i);
            if (ciudades.listaDeVertices().elemento(i).dato().getNombre().equals(destino))
                verticeDestino = ciudades.listaDeVertices().elemento(i);
        }
        if (verticeOrigen != null && verticeDestino != null) {
            int i = verticeOrigen.posicion();
            this.resolver(i,ciudades, destino, minFase, camino, marca);
        }
        return camino;
    }

    private boolean resolver(int i, Grafo<Ciudad2> ciudades, String destino, int minFase, ListaGenerica<Ciudad2> camino, boolean[] marca) {
        marca[i] = true;
        Vertice<Ciudad2> v = ciudades.listaDeVertices().elemento(i);
        if (v.dato().getNombre().equals(destino)) {
            camino.agregarFinal(v.dato());
            return true;
        }
        ListaGenerica<Arista<Ciudad2>> ady = ciudades.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Ciudad2> arista = ady.proximo();
            Vertice<Ciudad2> vertice = arista.verticeDestino();
            int j = vertice.posicion();
            if ((!marca[j]) && (vertice.dato().getFase() > minFase) && (arista.peso() != 0)) {
                if (this.resolver(j, ciudades, destino, minFase, camino, marca)) {
                    camino.agregarInicio(v.dato());
                    return true;
                }
            }
        }
        return false;
    }
}
