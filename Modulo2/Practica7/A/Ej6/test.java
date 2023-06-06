package Modulo2.Practica7.A.Ej6;

import Clases.Grafo.Grafo;
import Clases.Grafo.GrafoImplListAdy;
import Clases.Grafo.Vertice;
import Clases.Grafo.VerticeImplListAdy;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;


public class test {
  public static void main(String args[]) {
    Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
    Vertice<String> v2 = new VerticeImplListAdy<String>("Cordoba");
    Vertice<String> v3 = new VerticeImplListAdy<String>("Rosario");
    Vertice<String> v4 = new VerticeImplListAdy<String>("Mendoza");
    Vertice<String> v5 = new VerticeImplListAdy<String>("La Plata");
    Vertice<String> v6 = new VerticeImplListAdy<String>("Mar del Plata");
    Vertice<String> v7 = new VerticeImplListAdy<String>("San Luis");
    Vertice<String> v8 = new VerticeImplListAdy<String>("San Juan");

    Grafo<String> grafo = new GrafoImplListAdy<String>();
    grafo.agregarVertice(v1);
    grafo.agregarVertice(v2);
    grafo.agregarVertice(v3);
    grafo.agregarVertice(v4);
    grafo.agregarVertice(v5);
    grafo.agregarVertice(v6);
    grafo.agregarVertice(v7);
    grafo.agregarVertice(v8);

    grafo.conectar(v1, v2,2);
    grafo.conectar(v1, v3, 5);
    grafo.conectar(v1, v4, 8);
    grafo.conectar(v2, v3, 2);
    grafo.conectar(v2, v5, 3);
    grafo.conectar(v3, v4, 1);
    grafo.conectar(v3, v5, 1);
    grafo.conectar(v3, v6, 3);
    grafo.conectar(v4, v6, 2);
    grafo.conectar(v4, v7, 4);
    grafo.conectar(v4, v8, 5);

    Mapa<String> mapa = new Mapa<String>();
    mapa.setMapa(grafo);
    System.out.println("Devolver camino con dfs: ");
    ListaGenerica<String> camino = mapa.devolverCamino("Buenos Aires", "La Plata");
    for (int i = 0; i<camino.tamanio(); i++) {
      System.out.println(camino.elemento(i));
    }

    System.out.println("Devolver camino exceptuando: ");
    ListaGenerica<String> ciudades = new ListaGenericaEnlazada<>();
    ciudades.agregarFinal("Rosario");
    camino = mapa.devolverCaminoExceptuando("Buenos Aires", "San Luis", ciudades);
    for (int i = 0; i<camino.tamanio(); i++) {
      System.out.println(camino.elemento(i));
    }

    System.out.println("Devolver camino mas corto: ");
    camino = mapa.caminoMasCorto("Buenos Aires", "Mar del Plata");
    for (int i = 0; i < camino.tamanio(); i++) {
      System.out.println(camino.elemento(i));
    }

    System.out.println("Devolver camino sin cargar combustible: ");
    camino = mapa.caminoSinCargarCombustible("Buenos Aires", "San Juan", 11);
    for (int i = 0; i < camino.tamanio(); i++) {
      System.out.println(camino.elemento(i));
    }

    System.out.println("Devolver camino con menos cargas de combustible: ");
    camino = mapa.caminoConMenorCargaDeCombustible("Buenos Aires", "San Juan", 6);
    for (int i = 0; i < camino.tamanio(); i++) {
      System.out.println(camino.elemento(i));
    }
  }
}