public class ListaEnlazada {
    public Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
        } else {
            Nodo nodoActual = this.cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
    }


    public void imprimir() {
        Nodo nodoActual = this.cabeza;
        while (nodoActual != null) {
            System.out.print(nodoActual.valor + " -> ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println("null");
    }
}