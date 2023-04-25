import javax.lang.model.element.Element;

public class ArbolGeneral<Integer> {

	private Integer dato;

	private ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();

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
	
	public void preOrden() {
		System.out.println(this.getDato());
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			for (int i = 0; i<hijos.tamanio(); i++) {
				hijos.elemento(i).preOrden();
			}
		}	
	}

	public void postOrden() {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			for (int i = 0; i<hijos.tamanio(); i++) {
				hijos.elemento(i).postOrden();
			}
		}
		System.out.println(this.getDato());	
	}

	public void inOrden() {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.elemento(0).inOrden();
			System.out.println(this.getDato());
			for (int i = 1; i<hijos.tamanio(); i++) {
				hijos.elemento(i).inOrden();
			}
		}
		else
			System.out.println(this.getDato());
	}
	
	public Integer altura() {
		int altura = 0;
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			for (int i = 0; i<hijos.tamanio(); i++) {
				int alturaHijo = hijos.elemento(i).altura();
				if (alturaHijo > altura)
					altura = alturaHijo;
			}
			return altura + 1;
		}
		return altura;
	}

	public boolean include (T dato) {
		if (dato.equals(this.getDato()))
			return true;
		if (this.tieneHijos()) {
			for (int i = 0; i<hijos.tamanio(); i++) {
				if (this.getHijos().elemento(i).include(dato))
					return true;
			}
		}
		return false;
	}

	public Integer nivel(T dato) {
		Cola <ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		int nivel = 0;
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol == null) {
				if (!cola.esVacia()) {
					nivel++;
					cola.encolar(null);
				}
			}
			else {
				if (arbol.getDato().equals(dato))
					return nivel;
				if (arbol.tieneHijos()) {
					for (int i = 0; i<arbol.getHijos().tamanio(); i++) {
						cola.encolar(arbol.getHijos().elemento(i));
					}
				}
			}
		}
		return -1;
	}

	public Integer ancho() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		int anchoMax = 0;
		int anchoNivel = 0;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol == null) {
				if (!cola.esVacia())
					cola.encolar(null);
				if (anchoNivel > anchoMax)
					anchoMax = anchoNivel;
				anchoNivel = 0;
			}
			else {
				if (arbol.tieneHijos()) {
					for (int i = 0; i<arbol.getHijos().tamanio(); i++) {
						cola.encolar(arbol.getHijos().elemento(i));
						anchoNivel++;
					}	
				}
			}
		}
		return anchoMax;

	}

	public ListaGenerica<Integer> cantImagenes(int n) {
		Cola<ArbolGeneral<Integer>> cola = new Cola<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> arbol;
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		ListaGenerica<Integer> result = new ListaGenericaEnlazada<Integer>();
		while(!cola.esVacia() && (nivel<=n)) {
			arbol = cola.desencolar();
			if (arbol == null) {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
			}
			else {
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