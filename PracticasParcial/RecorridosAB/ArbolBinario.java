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
		int cantNodos = 0;
		int nivel = 0;
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if((arbol.getHijoIzquierdo() != null)) {
					cola.encolar(arbol.getHijoIzquierdo());
					cantNodos++;
				}
				if(arbol.getHijoDerecho() != null) {
					cola.encolar(arbol.getHijoDerecho());
					cantNodos++;
				}
			}
			else if(!cola.esVacia()) {
				if (cantNodos == Math.pow(2,++nivel)) {
					cola.encolar(null);
					cantNodos = 0;
				}
				else 
					lleno = false;
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
		System.out.println(this.getDato());
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();	
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printInorden();
		System.out.println(this.getDato());
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().printInorden();
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPostorden();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().printPostorden();
		System.out.println(this.getDato());
	}


	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = new ArbolBinario<T>();
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			System.out.println(arbol.getDato());
			if (arbol.tieneHijoIzquierdo())
				cola.encolar(arbol.getHijoIzquierdo());
			if (arbol.tieneHijoDerecho())
				cola.encolar(arbol.getHijoDerecho());
		}
	}

	public int contarNiveles() {
		int cantNiveles = 0;
		ArbolBinario<T> arbol = new ArbolBinario<T>();
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if ((arbol == null) && (!cola.esVacia())) {
				cola.encolar(null);
				cantNiveles++;
			}
			else if (arbol != null) {
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			}
		}
		return cantNiveles;
	}

	
	public int nodosEnNivel(int k) {
		int nroNivel = 0;
		int cantNodos = 0;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		ArbolBinario<T> arbol = new ArbolBinario<T>();
	  
		while(!cola.esVacia()) {
		  arbol = cola.desencolar();
		  if (arbol != null) {
			if (nroNivel == k)
			  while (arbol != null) {
				cantNodos++;
				arbol = cola.desencolar();
			  }
			  else {
				if (arbol.tieneHijoIzquierdo()) 
				  cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho()) 
				  cola.encolar(arbol.getHijoDerecho());
			  }
		  }
		  else if(!cola.esVacia()) {
			cola.encolar(null);
			nroNivel++;
		  }
		}
		return cantNodos;
	  }

	public int[] nodosPorNivel() {
		int nroNivel = 0;	int cantNodos[] = new int[20];
  Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
  ArbolBinario<T> arbol = new ArbolBinario<T>();
  cola.encolar(this);
  cola.encolar(null);
  while(!cola.esVacia()) {
    arbol = cola.desencolar();
    if (arbol != null) {
      cantNodos[nroNivel]++;
      if (arbol.tieneHijoIzquierdo())
        cola.encolar(arbol.getHijoIzquierdo());
      if (arbol.tieneHijoDerecho())
        cola.encolar(arbol.getHijoDerecho());
    }
    else if(!cola.esVacia()) {
      cola.encolar(null);
      nroNivel++;
    }
  }
  cantNodos[nroNivel + 1] = 0;
  return cantNodos;
}

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		this.fronteraRecursivo(l,this);
		return l;
	}

	private void fronteraRecursivo(ListaGenerica<T> l, ArbolBinario<T> arbol) {
		if (arbol.tieneHijoIzquierdo())
			fronteraRecursivo(l, arbol.getHijoIzquierdo());
		if (arbol.tieneHijoDerecho())
			fronteraRecursivo(l, arbol.getHijoDerecho());
		if (arbol.esHoja())
			l.agregarFinal(arbol.getDato());
	}



	public int contarHojas() {
  		int cont = 0;
  		if (this.esVacio())
    		return cont;
  		if (this.tieneHijoIzquierdo())
    		cont += this.getHijoIzquierdo().contarHojas();
  		if (this.tieneHijoDerecho())
    		cont += this.getHijoDerecho().contarHojas();
  		if (this.esHoja())
    		cont++;
  		return cont;
}
	

}
