package Clases.ListaDeEnteros;

/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}

	public void imprimir() {
		NodoEntero aux = this.inicio;
		while (aux != null) {
			System.out.print(aux.getDato() + "==>");
			aux = aux.getSiguiente();
		}
		System.out.println("null");
	}

	public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada lista) {
		ListaDeEnterosEnlazada merge = new ListaDeEnterosEnlazada();
		merge.comenzar();
		int tamanio1 = this.tamanio;
		int tamanio2 = lista.tamanio();
		int i = 0;
		int j = 0;
		while (merge.tamanio < (tamanio1 + tamanio2)) {
			if ((i <= tamanio1 - 1) && (j <= tamanio2 - 1)) {
				if (lista.elemento(j) < this.elemento(i)) {
					merge.agregarFinal(lista.elemento(j));
					j++;
				} else {
					merge.agregarFinal(this.elemento(i));
					i++;
				}
			}

			else {
				while (lista.elemento(j) != null) {
					merge.agregarFinal(lista.elemento(j));
					j++;
				}
				while (this.elemento(i) != null) {
					merge.agregarFinal(this.elemento(i));
					i++;
				}
			}
		}
		return merge;
	}

	public ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada lista) {
		if (lista.tamanio() <= 1)
			return lista;

		ListaDeEnterosEnlazada izq = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada der = new ListaDeEnterosEnlazada();

		int i = 0;
		lista.comenzar();
		while (!lista.fin()) {
			if ((i < lista.tamanio() / 2)) {
				izq.agregarFinal(lista.proximo());
			} else {
				der.agregarFinal(lista.proximo());
			}
			i++;
		}
		izq = mergeSort(izq);
		der = mergeSort(der);

		return merge(izq, der);

	}

	private static ListaDeEnterosEnlazada merge(ListaDeEnterosEnlazada izq, ListaDeEnterosEnlazada der) {
		der.comenzar();
		izq.comenzar();
		ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
		while (!izq.esVacia() && !der.esVacia()) {
			if (izq.elemento(0) < der.elemento(0)) {
				resultado.agregarFinal(izq.elemento(0));
				izq.eliminarEn(0);
			} else {
				resultado.agregarFinal(der.elemento(0));
				der.eliminarEn(0);
			}
		}
		while (!der.esVacia()) {
			resultado.agregarFinal(der.elemento(0));
			der.eliminar(der.elemento(0));
		}
		while (!izq.esVacia()) {
			resultado.agregarFinal(izq.elemento(0));
			izq.eliminar(izq.elemento(0));
		}
		return resultado;
	}

	public ListaDeEnterosEnlazada ordernar() {
		ListaDeEnterosEnlazada listaOrdenada = new ListaDeEnterosEnlazada();
		int tamanioListaOriginal = this.tamanio;
		listaOrdenada.comenzar();
		int min = Integer.MAX_VALUE;
		int j;
		for (j = 0; j < this.tamanio; j++) {
			if (this.elemento(j) < min)
				min = this.elemento(j);
		}
		listaOrdenada.agregarFinal(min);
		while (listaOrdenada.tamanio < tamanioListaOriginal) {
			min = Integer.MAX_VALUE;
			for (j = 0; j < this.tamanio; j++) {
				if ((this.elemento(j) < min) && (this.elemento(j) > listaOrdenada.elemento(listaOrdenada.tamanio() - 1)))
					min = this.elemento(j);
			}
			listaOrdenada.agregarFinal(min);
		}
		return listaOrdenada;
	}
}
