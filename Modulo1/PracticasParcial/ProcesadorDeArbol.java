package Modulo1.PracticasParcial;

import Clases.ArbolBinario.ArbolBinario;

public class ProcesadorDeArbol {

	private ArbolBinario<Character> arbol;

	public ProcesadorDeArbol(ArbolBinario<Character> arbol) {
		this.arbol = arbol;
	}

	public ProcesadorDeArbol() {
		this.arbol = new ArbolBinario<Character>();
	}

	public int procesar(int k) {
		int cant = 0;
		if ((k == 0) && (arbol.esHoja()))
			return 1;
		if ((arbol.tieneHijoDerecho()) && !(arbol.tieneHijoIzquierdo()))
			k--;
		if ((arbol.tieneHijoIzquierdo()) && !(arbol.tieneHijoDerecho()))
			k--;
		if (arbol.tieneHijoIzquierdo()) {
			ProcesadorDeArbol auxIzq = new ProcesadorDeArbol(arbol.getHijoIzquierdo());
			cant += auxIzq.procesar(k);
		}

		if (arbol.tieneHijoDerecho()) {
			ProcesadorDeArbol auxDer = new ProcesadorDeArbol(arbol.getHijoDerecho());
			cant += auxDer.procesar(k);
		}
		return cant;
	}
}