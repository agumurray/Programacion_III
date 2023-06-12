package Modulo2.RepasoParcial.util;

import Clases.Grafo.Arista;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Modulo2.RepasoParcial.util.Ciudad2;


public class Parcial3 {
    public int[] resolver(Grafo<Ciudad2> ciudades, String origen, String destino) {
        int length = ciudades.listaDeVertices().tamanio();
        boolean marca[] = new boolean[length];
        int fases[] = new int[5];
        Vertice<Ciudad2> verticeOrigen = null;
        Vertice<Ciudad2> verticeDestino = null;
        for (int i = 0; i < length; i++) {
            if (ciudades.listaDeVertices().elemento(i).dato().getNombre().equals(origen))
                verticeOrigen = ciudades.listaDeVertices().elemento(i);
            if (ciudades.listaDeVertices().elemento(i).dato().getNombre().equals(destino))
                verticeDestino = ciudades.listaDeVertices().elemento(i);
        }
        int i = verticeOrigen.posicion();
        if (verticeOrigen != null && verticeDestino != null) {
            boolean recorrido[] =  new boolean[length];
            this.resolver(i, ciudades, destino, marca, fases, recorrido);
        }
        return fases;
    }

    private boolean resolver(int i, Grafo<Ciudad2> ciudades, String destino, boolean[] marca, int[] fases, boolean[] recorrido) {
        boolean flag = false;
        marca[i] = true;
        Vertice<Ciudad2> v = ciudades.listaDeVertices().elemento(i);
        if (v.dato().getNombre().equals(destino)) {
            if (!recorrido[i]) {    
            fases[v.dato().getFase() - 1]++;
            }
            return true;
        }
        ListaGenerica<Arista<Ciudad2>> ady = ciudades.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Ciudad2> arista = ady.proximo();
            Vertice<Ciudad2> vertice = arista.verticeDestino();
            int j = vertice.posicion();
            if (!(marca[j]) && (arista.peso() != 0)) {
                if (this.resolver(j, ciudades, destino, marca, fases, recorrido)) {
                    if (!recorrido[j]) {
                        fases[vertice.dato().getFase() - 1]++;
                        recorrido[j] = true;
                    }
                    flag = true;
                }
                marca[j] = false;
            }
        }
        return flag;
    }

}
