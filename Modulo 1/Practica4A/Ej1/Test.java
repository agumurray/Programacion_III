public class Test {
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

    arbolBinarioB.printPreorden();
    System.out.println("Fin arbol");
    arbolBinarioB.printInorden();
    System.out.println("Fin arbol");
    arbolBinarioB.printPostorden();
    System.out.println("Fin arbol");

    int hojas = arbolBinarioB.contarHojas();

    System.out.println("La cantidad de hojas es: " + hojas);

    ListaGenerica<Integer> l = new ListaGenericaEnlazada<Integer>();

    l = arbolBinarioB.frontera();

    System.out.println(l.toString());

    System.out.println(arbolBinarioB.esLleno());

   System.out.println(arbolBinarioB.esCompleto());
   } 
}
