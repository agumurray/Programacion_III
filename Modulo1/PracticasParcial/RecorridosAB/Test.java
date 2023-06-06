package Modulo1.PracticasParcial.RecorridosAB;

import Clases.ArbolBinario.ArbolBinario;
import Clases.ListaGenerica.utils.Cola;

class Test {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
        ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        System.out.println(sumaMaximaVertical(arbolBinarioB,0));
        System.out.println(sumaMaximaHorizontal(arbolBinarioB));
    }

	public static int sumaMaximaVertical(ArbolBinario<Integer> arbol, int suma) {	
		int izq = 0;
		int der = 0;

		if (arbol.esHoja())
			return arbol.getDato();
		if (arbol.tieneHijoIzquierdo())
			izq += sumaMaximaVertical(arbol.getHijoIzquierdo(), suma);
		if (arbol.tieneHijoDerecho())
			der += sumaMaximaVertical(arbol.getHijoDerecho(), suma);
		suma = Math.max(izq,der) + arbol.getDato();
		return suma;
	}

    public static int sumaMaximaHorizontal(ArbolBinario<Integer> a) {
		ArbolBinario<Integer> arbol = null;
		int suma = 0; int max = -1;
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
        cola.encolar(a);
        cola.encolar(null);
        while(!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol != null) {
                suma+=arbol.getDato();
                if (arbol.tieneHijoIzquierdo())
                    cola.encolar(arbol.getHijoIzquierdo());
                if (arbol.tieneHijoDerecho())
                    cola.encolar(arbol.getHijoDerecho());
            }

            else {
                if (suma>max)
                    max = suma;
                if (!cola.esVacia()) {
                cola.encolar(null);
                if (suma > max)
                    max = suma;
                suma = 0;
            }
        }
        }
        return max;
	}

}