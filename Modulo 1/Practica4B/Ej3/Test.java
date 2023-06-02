public class Test {
    public static void main(String[] args) {
        ArbolBinario<String> arbolBinarioB=new ArbolBinario<String>("Nashe?");
        ArbolBinario<String> hijoIzquierdoB=new ArbolBinario<String>("Si");
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<String>("Hola"));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<String>("Chau"));
        ArbolBinario<String> hijoDerechoB=new ArbolBinario<String>("No");
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<String>("Hola"));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<String>("Chau"));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        arbolBinarioB.printPreorden();
        System.out.println("Fin arbol");

        ListaGenericaEnlazada<String> caminoMayor = new ListaGenericaEnlazada<String>();

        caminoMayor = Adivinanza.secuenciaMayor(arbolBinarioB);

        System.out.println(caminoMayor);
    }
}