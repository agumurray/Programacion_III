package Modulo1.PracticasParcial.caminosPrincesa;

import Clases.ArbolGeneral.ArbolGeneral;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Test {
    public static void main(String[] args){
        ArbolGeneral<String> a = new ArbolGeneral<String>("Coyote");
        //hace un arbol random
        a.agregarHijo(new ArbolGeneral<String>("Scooby"));
        a.agregarHijo(new ArbolGeneral<String>("Craia"));
        a.agregarHijo(new ArbolGeneral<String>("Cid"));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<String>("Pluto"));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<String>("Gato"));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<String>("Tweety"));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<String>("Princesa"));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<String>("Dragon"));

        ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
        lista = a.encontrarPrincesa();
        System.out.println(lista);
    }    
}