package Modulo2.Practica7.A.Ej8;

import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.Grafo.Arista;
import Clases.ListaGenerica.ListaGenerica;

public class Delta {
    public Delta() {

    }

    public int maxIslas(Grafo<String> grafo) {
        int aux, max = -1;
        Vertice<String> v = grafo.listaDeVertices().elemento(0);
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        marca[0] = true;
        grafo.listaDeAdyacentes(v).comenzar();
        while(!grafo.listaDeAdyacentes(v).fin()) {
            aux = maxIslas(grafo.listaDeAdyacentes(v).proximo().verticeDestino().posicion(),grafo ,marca);
            if(aux > max) {
                max = aux;
            }
        }
        return max;
    }

    private int maxIslas(int i, Grafo<String> grafo, boolean[] marca) {
        marca[i] = true;
        int cant = 0;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        cant++;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                cant += maxIslas(j, grafo, marca);
            }
        }
        return cant;
    }

    public RutaMinima<String> caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        RutaMinima<String> ruta = new RutaMinima<>();
        RutaMinima<String> rutaActual = new RutaMinima<>();
        rutaActual.setBoletos(1);
        Vertice<String> origen = null;
        Vertice<String> destino = null;
        for (int i = 0; i < marca.length; i++) {
            if (grafo.listaDeVertices().elemento(i).dato().equals(islaO)) {
                origen = grafo.listaDeVertices().elemento(i);
            }
            if (grafo.listaDeVertices().elemento(i).dato().equals(islaD)) {
                destino = grafo.listaDeVertices().elemento(i);
            }
        }
        if (origen != null && destino != null) {
            caminoMasCorto(grafo, origen, destino, ruta, rutaActual, marca);
        }
        return ruta;
    }

    private void caminoMasCorto(Grafo<String> grafo, Vertice<String> origen, Vertice<String> destino, RutaMinima<String> ruta, RutaMinima<String> rutaActual, boolean[] marca) {
        marca[origen.posicion()] = true;
        rutaActual.agregar(origen.dato());
        if (origen.dato().equals(destino.dato())) {
            if (rutaActual.getPeso() < ruta.getPeso() || ruta.getRuta().tamanio() == 0) {
                copiarRuta(ruta, rutaActual);
            }
            return;
        }
        if (origen.posicion() == 0 && !origen.dato().equals(destino.dato())) {
            rutaActual.agregarBoleto();
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista = ady.proximo();
            if (!marca[arista.verticeDestino().posicion()]) {
                rutaActual.agregarPeso(arista.peso());
                caminoMasCorto(grafo, arista.verticeDestino(), destino, ruta, rutaActual, marca);
                marca[arista.verticeDestino().posicion()] = false;
                rutaActual.eliminar(rutaActual.getRuta().tamanio() - 1);
                rutaActual.eliminarPeso(arista.peso());
                if (origen.posicion() == 0 && !origen.dato().equals(destino.dato())) {
                    rutaActual.eliminarBoleto();
                }
            }
        }
    }
    private void copiarRuta(RutaMinima<String> ruta, RutaMinima<String> rutaActual) {
        while (!ruta.getRuta().esVacia()) {
            ruta.eliminar(0);
        }
        rutaActual.getRuta().comenzar();
        while (!rutaActual.getRuta().fin()) {
            ruta.agregar(rutaActual.getRuta().proximo());
        }
        ruta.setPeso(rutaActual.getPeso());
        ruta.setBoletos(rutaActual.getBoletos());
    }
}
