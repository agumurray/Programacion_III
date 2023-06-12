package Modulo2.RepasoParcial.util;

import Clases.Grafo.Arista;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.ListaGenerica.ListaGenerica;

public class Parcial1 {
     public int resolver(Grafo<Ciudad> ciudades, String origen, String destino, int maxControles) {
        int length = ciudades.listaDeVertices().tamanio();
        boolean marca[] = new boolean[length];
        ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
        Vertice<Ciudad> verticeOrigen = null;
        Vertice<Ciudad> verticeDestino = null;
        for (int i = 0; i < length; i++) {
            if (vertices.elemento(i).dato().getNombre().equals(origen)) {
                verticeOrigen = vertices.elemento(i);
            }
            if (vertices.elemento(i).dato().getNombre().equals(destino)) {
                verticeDestino = vertices.elemento(i);
            }
        }
        int max = 0, maxActual = 0;
        if (verticeOrigen != null && verticeDestino != null) {
                int i = verticeOrigen.posicion();
                max = this.resolver(i, ciudades, destino,marca, maxControles, max, maxActual);
            }
            return max;
        }

    private int resolver(int i, Grafo<Ciudad> ciudades, String destino,boolean[] marca, int maxControles, int max, int maxActual) {
        marca[i] = true;
        Vertice<Ciudad> v = ciudades.listaDeVertices().elemento(i);
        maxActual += v.dato().getLimite();
        if (v.dato().getNombre().equals(destino)) {
            if (maxActual>max)
                return maxActual;
            return max;
        }
        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(v);
        ady.comenzar();
        while(!ady.fin()) {
            Arista<Ciudad> arista = ady.proximo();
            Vertice<Ciudad> vertice = arista.verticeDestino();
            int j = vertice.posicion();
            if ((!marca[j]) && !(arista.peso() > maxControles)) {
                max = resolver(j, ciudades, destino, marca, maxControles, max, maxActual);
                marca[j] = false;
                maxActual -= v.dato().getLimite();
            }
        }
        return max;
    }
}
