package Modulo2.Practica7.A.Ej9;

import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.Grafo.Arista;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class GuiaDeTurismo {

    public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String puntoInteresDestino) {
    ListaGenerica<Viajes> viajes = new ListaGenericaEnlazada<Viajes>();
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    boolean[] marca = new boolean[vertices.tamanio()];
    Vertice<String> verticeOrigen = null;
    Vertice<String> verticeDestino = null;
    for (int i = 0; i < marca.length; i++) {
      if(vertices.elemento(i).dato().equals(puntoInteresOrigen)) {
        verticeOrigen = vertices.elemento(i);
      }
      if(vertices.elemento(i).dato().equals(puntoInteresDestino)) {
        verticeDestino = vertices.elemento(i);
      }
    }
    if (verticeOrigen != null && verticeDestino != null) {
      caminoConMenorNrodeViajes(grafo, verticeOrigen, verticeDestino, viajes, new Viajes(), marca);
    }
    Viajes camino = new Viajes();
    int mayorPeso = 0;
    viajes.comenzar();
    while (!viajes.fin()) {
      Viajes actual = viajes.proximo();
      if (actual.getMenorPeso() > mayorPeso) {
        mayorPeso = actual.getMenorPeso();
        camino = actual;
      }
    } 
    return camino.getCamino();
  }

    private void caminoConMenorNrodeViajes(Grafo<String> grafo, Vertice<String> vOrigen, Vertice<String> vDestino,
      ListaGenerica<Viajes> viajes, Viajes camino, boolean[] marca) {
    marca[vOrigen.posicion()] = true;
    camino.agregarPuntoDeInteres(vOrigen.dato());
    if (vOrigen.dato().equals(vDestino.dato())) {
      agregarViaje(viajes, camino);
    }
    ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vOrigen);
    adyacentes.comenzar();
    while (!adyacentes.fin()) {
      Arista<String> arista = adyacentes.proximo();
      int j = arista.verticeDestino().posicion();
      if (!marca[j]) {
        int minimo = camino.getMenorPeso();
        if (minimo > arista.peso()) {
          camino.setMenorPeso(arista.peso());
        }
        caminoConMenorNrodeViajes(grafo, arista.verticeDestino(), vDestino, viajes, camino, marca);
        marca[j] = false;
        camino.eliminarPuntoDeInteres(camino.getCamino().tamanio() - 1);
        camino.setMenorPeso(minimo);
      }
    }
  }

  public void agregarViaje(ListaGenerica<Viajes> viajes, Viajes actual){
    Viajes copia = new Viajes();
    ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
    for (int i = 0; i < actual.getCamino().tamanio(); i++) {
      camino.agregarFinal(actual.getCamino().elemento(i));
    }
    copia.setCamino(camino);
    copia.setMenorPeso(actual.getMenorPeso());
    viajes.agregarFinal(copia);
  }

}
