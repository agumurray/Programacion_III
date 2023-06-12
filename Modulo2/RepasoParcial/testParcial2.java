package Modulo2.RepasoParcial;

import Clases.Grafo.Grafo;
import Clases.Grafo.GrafoImplListAdy;
import Clases.Grafo.Vertice;
import Clases.Grafo.VerticeImplListAdy;
import Clases.ListaGenerica.ListaGenerica;
import Modulo2.RepasoParcial.util.Ciudad2;
import Modulo2.RepasoParcial.util.Parcial2;

public class testParcial2 {

  public static void main(String args[]) {
    Vertice<Ciudad2> sp = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Suipacha", 3));
    Vertice<Ciudad2> ck = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Carlos Keen", 5));
    Vertice<Ciudad2> m = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Moreno", 4));
    Vertice<Ciudad2> q = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Quilmes", 3));
    Vertice<Ciudad2> l = new VerticeImplListAdy<Ciudad2>(new Ciudad2("La Plata", 3));
    Vertice<Ciudad2> a = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Abasto", 4));
    Vertice<Ciudad2> c = new VerticeImplListAdy<Ciudad2>(new Ciudad2("CaÃ±uelas", 2));
    Vertice<Ciudad2> n = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Navarro", 1));
    Vertice<Ciudad2> sa = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Saladillo", 2));
    Vertice<Ciudad2> lo = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Lobos", 1));
    Vertice<Ciudad2> pi = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Pinamar", 1));

    Grafo<Ciudad2> ciudades = new GrafoImplListAdy<Ciudad2>();

    ciudades.agregarVertice(sp);
    ciudades.agregarVertice(ck);
    ciudades.agregarVertice(m);
    ciudades.agregarVertice(q);
    ciudades.agregarVertice(l);
    ciudades.agregarVertice(a);
    ciudades.agregarVertice(c);
    ciudades.agregarVertice(n);
    ciudades.agregarVertice(sa);
    ciudades.agregarVertice(lo);
    ciudades.agregarVertice(pi);

    ciudades.conectar(sp, ck, 2);
    ciudades.conectar(ck, sp, 2);
    ciudades.conectar(sp, n, 1);
    ciudades.conectar(n, sp, 1);
    ciudades.conectar(ck, m, 2);
    ciudades.conectar(m, ck, 2);
    ciudades.conectar(m, q, 2);
    ciudades.conectar(q, m, 2);
    ciudades.conectar(q, l, 2);
    ciudades.conectar(l, q, 2);
    ciudades.conectar(l, a, 2);
    ciudades.conectar(a, l, 2);
    ciudades.conectar(a, m, 0);
    ciudades.conectar(m, a, 0);
    ciudades.conectar(a, c, 2);
    ciudades.conectar(c, a, 2);
    ciudades.conectar(c, n, 2);
    ciudades.conectar(n, c, 2);
    ciudades.conectar(n, sa, 2);
    ciudades.conectar(sa, n, 2);
    ciudades.conectar(n, lo, 0);
    ciudades.conectar(lo, n, 0);

    Parcial2 parcial = new Parcial2();

    ListaGenerica<Ciudad2> camino = parcial.resolver(ciudades, "La Plata", "Suipacha", 2);
    camino.comenzar();
    while (!camino.fin()) {
        System.out.print(camino.proximo().getNombre() + "->");
    }
  }

}
