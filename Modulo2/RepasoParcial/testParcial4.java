package Modulo2.RepasoParcial;

import Clases.Grafo.Grafo;
import Clases.Grafo.GrafoImplListAdy;
import Clases.Grafo.Vertice;
import Clases.Grafo.VerticeImplListAdy;
import Clases.ListaGenerica.ListaGenerica;
import Modulo2.RepasoParcial.util.Ciudad;
import Modulo2.RepasoParcial.util.Ciudad2;
import Modulo2.RepasoParcial.util.Parcial4;

public class testParcial4{

  public static void main(String args[]) {
    Vertice<Ciudad2> sp = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Suipacha", 3));
    Vertice<Ciudad2> ck = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Carlos Keen", 5));
    Vertice<Ciudad2> m = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Moreno", 4));
    Vertice<Ciudad2> q = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Quilmes", 3));
    Vertice<Ciudad2> l = new VerticeImplListAdy<Ciudad2>(new Ciudad2("La Plata", 3));
    Vertice<Ciudad2> a = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Abasto", 4));
    Vertice<Ciudad2> c = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Ca単uelas", 2));
    Vertice<Ciudad2> n = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Navarro", 2));
    Vertice<Ciudad2> sa = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Saladillo", 2));
    Vertice<Ciudad2> lo = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Lobos", 1));
    Vertice<Ciudad2> pi = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Pinamar", 1));
    Vertice<Ciudad2> al = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Altamirano", 1));
    Vertice<Ciudad2> b = new VerticeImplListAdy<Ciudad2>(new Ciudad2("Buenos Aires", 2));


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
    ciudades.agregarVertice(al);
    ciudades.agregarVertice(b);

    ciudades.conectar(sp, ck, 2); // Suipacha - Carlos Keen
    ciudades.conectar(ck, sp, 2);

    ciudades.conectar(sp, n, 2); // Suipacha - Navarro
    ciudades.conectar(n, sp, 2);

    ciudades.conectar(ck, m, 2); // Carlos Keen - Moreno
    ciudades.conectar(m, ck, 2);

    ciudades.conectar(m, q, 2); // Moreno - Quilmes
    ciudades.conectar(q, m, 2);

    ciudades.conectar(q, l, 2); // Quilmes - La Plata
    ciudades.conectar(l, q, 2);

    ciudades.conectar(l, a, 0); // La Plata - Abasto
    ciudades.conectar(a, l, 0);

    ciudades.conectar(a, m, 2); // Abasto - Moreno
    ciudades.conectar(m, a, 2);

    ciudades.conectar(al, l, 1); // Altamirano - La Plata
    ciudades.conectar(l, al, 1);

    ciudades.conectar(al, c, 1); // Altamirano - Ca単uelas
    ciudades.conectar(c, al, 1);

    ciudades.conectar(c, n, 2); // Ca単uelas - Navarro
    ciudades.conectar(n, c, 2);

    ciudades.conectar(n, sa, 2); // Navarro - Saladillo
    ciudades.conectar(sa, n, 2);

    ciudades.conectar(n, lo, 0); // Navarro - Lobos
    ciudades.conectar(lo, n, 0);

    ciudades.conectar(l, c, 2); // La Plata - Ca単uelas
    ciudades.conectar(c, l, 2);

    ciudades.conectar(m, b, 2); // La Plata - Buenos Aires
    ciudades.conectar(b, m, 2);
    
    ciudades.conectar(b, sp, 2); // Buenos Aires - Suipacha
    ciudades.conectar(sp, b, 2);
    
    Parcial4 parcial = new Parcial4();

   ListaGenerica<Ciudad2> ciud = parcial.resolver(ciudades, "La Plata", "Suipacha");
   ciud.comenzar();

   while(!ciud.fin()) {
    System.out.print(ciud.proximo().getNombre() + "->");
   }

  }

}