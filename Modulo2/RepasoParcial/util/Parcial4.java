package Modulo2.RepasoParcial.util;

import Clases.Grafo.Arista;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Parcial4 {
    public ListaGenerica<Ciudad2> resolver(Grafo<Ciudad2> ciudades, String origen, String destino) {
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
        ListaGenerica<Ciudad2> resultado = new ListaGenericaEnlazada<>();
        if (verticeOrigen!=null && verticeDestino!=null) {
            boolean recorrido[] = new boolean[length];
            this.resolver(i, ciudades, destino, marca, resultado, recorrido);
        }
        return resultado;
    }

    private boolean resolver(int i, Grafo<Ciudad2> ciudades, String destino, boolean[] marca, ListaGenerica<Ciudad2> resultado, boolean[] recorrido) {
        boolean flag = false;
        marca[i] = true;
        Vertice<Ciudad2> v = ciudades.listaDeVertices().elemento(i);
        resultado.agregarFinal(v.dato());
        if (v.dato().getNombre().equals(destino)) {
            if (!recorrido[i]) {
            recorrido[i] = true;
            }
            else {
                resultado.eliminarEn(resultado.tamanio() - 1);
            }
            return true;
        }
        ListaGenerica<Arista<Ciudad2>> ady = ciudades.listaDeAdyacentes(v);
        ady.comenzar();
        while(!ady.fin()) {
            Arista<Ciudad2> arista= ady.proximo();
            Vertice<Ciudad2> vertice = arista.verticeDestino();
            int j = vertice.posicion();
            if ((!marca[j]) && (arista.peso() != 0) && (vertice.dato().getFase() > 1)) {
                if (this.resolver(j, ciudades, destino, marca, resultado,recorrido)) {
                    if (!recorrido[j]) {
                        recorrido[j] = true;
                    }
                    flag = true;
                }
                else {
                    resultado.eliminarEn(resultado.tamanio() - 1);
                }
                marca[j] = false;
            }
    }
        return flag;
    }
}
