package Clases.ArbolGeneral;

import Clases.ListaGenerica.utils.Cola;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}

	public Integer altura() {
		int nivel = 0;
		int max = 0;
		if (this.esHoja())
			return nivel;

		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();

		for (int i = 0; i < hijos.tamanio(); i++) {
			nivel = hijos.elemento(i).altura() + 1;
			if (nivel > max)
				max = nivel;
		}

		return max;
	}

	public boolean include(T dato) {
		boolean flag = false;
		if (dato.equals(this.getDato()))
			return true;
		if (this.tieneHijos()) {
			for (int i = 0; i < hijos.tamanio(); i++) {
				flag = this.getHijos().elemento(i).include(dato);
				if (flag)
					return flag;
			}
		}
		return flag;
	}

	public Integer nivel(T dato) {
		int nivel = -1;
		if (dato.equals(this.getDato()))
			return nivel + 1;
		if (this.tieneHijos()) {
			for (int i = 0; i < hijos.tamanio(); i++) {
				nivel = this.getHijos().elemento(i).nivel(dato);
				if (nivel != -1)
					return nivel + 1;
			}
		}
		return nivel;
	}

	public Integer ancho() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		int max = 0;
		int cant;

		cant = 0;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				for (int i = 0; i < arbol.getHijos().tamanio(); i++) {
					cola.encolar(arbol.getHijos().elemento(i));
					cant++;
				}
			} else if (!cola.esVacia()) {
				if (max < cant)
					max = cant;
				cola.encolar(null);
				cant = 0;
			}
		}

		return max;
	}

	public void ImprimirPorNiveles() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);

		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.print(arbol.getDato() + " ");
				for (int i = 0; i < arbol.getHijos().tamanio(); i++) {
					cola.encolar(arbol.getHijos().elemento(i));
				}
			} else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}

	public ListaGenerica<T> encontrarPrincesa() {
		ListaGenerica<T> lista = new ListaGenericaEnlazada<>();
		if ((this.getDato().equals("Princesa")) || (this.getDato().equals("Dragon")) || this.esHoja()) {
			if (this.getDato().equals("Princesa")) {
				lista.agregarInicio(this.getDato());
			}
			return lista;
		}
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		while (!hijos.fin() && lista.esVacia()) {
			lista = hijos.proximo().encontrarPrincesa();
			if (!lista.esVacia()) {
				lista.agregarInicio(this.getDato());
			}
		}
		return lista;
	}

	public ListaGenerica<T> cantImagenes(int n) {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		ListaGenerica<T> result = new ListaGenericaEnlazada<T>();
		while (!cola.esVacia() && (nivel <= n)) {
			arbol = cola.desencolar();
			if (arbol == null) {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
			} else {
				if (nivel == n) {
					if (arbol.getDato().equals(1))
						result.agregarFinal(arbol.getDato());
				}
				if (arbol.tieneHijos())
					for (int i = 0; i < arbol.getHijos().tamanio(); i++)
						cola.encolar(arbol.getHijos().elemento(i));
			}
		}
		return result;
	}


}