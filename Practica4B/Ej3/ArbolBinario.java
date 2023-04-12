public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		boolean lleno = true;
		cola.encolar(this);
		int cant_nodos = 0;
		int nivel = 0;
		while (!(cola.esVacia()) && lleno) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (!arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cant_nodos++;
				}
				if (!arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					cant_nodos++;
				}
			}
			else if (!(cola.esVacia())) {
				if (cant_nodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cant_nodos = 0;
				}
				else lleno = false;
			}
		}
		return lleno;
	}

	 public boolean esCompleto() {
		if (this.esVacio())
			return true;
		
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);

		ArbolBinario<T> arbol = new ArbolBinario<T>();

		boolean flag = false;

		while(!cola.esVacia()) {
			arbol = cola.desencolar();

			if (flag && !(arbol.esHoja())) 
				return false;

			if ((arbol.tieneHijoIzquierdo()) && (!arbol.tieneHijoDerecho()))
				return false;

			if (arbol.tieneHijoIzquierdo())
				cola.encolar(arbol.hijoIzquierdo);
			else 
				flag = true;

			if (arbol.tieneHijoDerecho())
				cola.encolar(arbol.hijoDerecho);
			else 
				flag = true;
		}
		return true;
	}

	
	// imprime el arbol en preorden  
	public void printPreorden() {
		if (this.getDato() != null) {
		System.out.print(this.getDato() + "=>");
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}
	}

	// imprime el arbol en postorden
	public void printInorden() {	
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printInorden();
		}
		if (this.getDato() != null) {
			System.out.print(this.getDato() + "=>");
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printInorden();
		}
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if (this.hijoIzquierdo != null)	{
			this.getHijoIzquierdo().printPostorden();
		}
		if (this.hijoDerecho != null) {
			this.getHijoDerecho().printPostorden();
		}
		if (this.getDato() != null) {
			System.out.print(this.getDato() + "=>");
		}
	}


	public void recorridoPorNiveles() {
		
	}

	
	private ListaGenerica<T> fronteraRecursivo(ListaGenerica<T> l) {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().fronteraRecursivo(l);
		}
		if (this.esHoja()) {
			l.agregarFinal(this.getDato());
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().fronteraRecursivo(l);
		}	
		return l;
	}


	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		fronteraRecursivo(l);
		return l;
	}

	
	
	
	public int contarHojas() {
		int cont = 0;
		if (this.esVacio()) {
			return cont;
		}
		if (this.hijoIzquierdo != null) {
			cont += this.getHijoIzquierdo().contarHojas();
		}
		if (this.hijoDerecho != null) {
			cont += this.getHijoDerecho().contarHojas();
		}
		if (this.getDato() != null) {
			if ((this.getHijoDerecho() == null) && (this.getHijoIzquierdo() == null)) {
				cont++;
			}
		}
		return cont;
	}

	public int sumaMaximaVertical(ArbolBinario<Integer> arbol, int suma) {
		int izq = 0;
		int der = 0;

		if(arbol.esHoja())
			return arbol.getDato();
		if(arbol.tieneHijoIzquierdo()) 
			izq += sumaMaximaVertical(arbol.getHijoIzquierdo(), izq);
		if(arbol.tieneHijoDerecho())
			der += sumaMaximaVertical(arbol.getHijoDerecho(), der);
		suma = Math.max(izq,der) + arbol.getDato();
		return suma;
	}

	public int sumaMaximaHorizontal(ArbolBinario<Integer> a) {
		ArbolBinario<Integer> arbol = null;
		int suma = 0, max = -1;
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		cola.encolar(a);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				suma += arbol.getDato();
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
			}
			else if (!cola.esVacia()) {
				if (suma>max)
					max = suma;
				suma = 0;
				cola.encolar(null);
			}
			else {
				if (suma>max)
					max = suma;
			}
		}
		return max;
	}
}

