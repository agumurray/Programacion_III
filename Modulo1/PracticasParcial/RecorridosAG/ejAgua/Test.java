package Modulo1.PracticasParcial.RecorridosAG.ejEmpresa;

import Clases.ArbolGeneral.ArbolGeneral;
import Clases.ListaGenerica.ListaGenerica;

public class Test {
    public static void main(String[] args){
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(1);
        //hace un arbol random
        a.agregarHijo(new ArbolGeneral<Integer>(2));
        a.agregarHijo(new ArbolGeneral<Integer>(3));
        a.agregarHijo(new ArbolGeneral<Integer>(4));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(6));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(7));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(8));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(9));

        System.out.println(minCaudal(a, 1000));
        
    }
    
    public static float minCaudal(ArbolGeneral<Integer> config, float litros) {
        if(config.esHoja())
            return litros;
        ListaGenerica<ArbolGeneral<Integer>> l = config.getHijos();
        float min = Float.MAX_VALUE;
        l.comenzar();
        float aux = litros / l.tamanio();
        while(!l.fin()) {
            float actual = minCaudal(l.proximo(), aux);
            if (actual<min)
                min = actual;
        }
        return min;
    }
}