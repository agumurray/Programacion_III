public class Test {
  public static void main(String[] args) {
    ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(10);
    arbol.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
    arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
    arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(2));
    arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(9));
    arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(11));
    arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(5));
    arbol.agregarHijoDerecho(new ArbolBinario<Integer>(7));
    arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
    arbol.getHijoDerecho().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
    arbol.getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(2));
    arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(3));

    Procesador proc = new Procesador(arbol);

    ListaGenerica<ArbolBinario<Integer>> lista = proc.procesarArbol();

    lista.comenzar();

    while(!lista.fin()){
      ArbolBinario<Integer> aux = lista.proximo();
      System.out.println(aux.getDato());
    }
  }
  
}