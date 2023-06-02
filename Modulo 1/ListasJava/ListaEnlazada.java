public class ListaEnlazada extends ListaDeEnteros{
    private Nodo inicio;
    private Nodo actual;
    private int tamanio;


    @Override
    public void comenzar() {
        this.actual = this.inicio;
    }

    @Override
    public int proximo() {
        int valor = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return valor;
    }

    @Override
    public boolean fin() {
        return this.actual == null;
    }

    @Override
    public int elemento(int pos) {
        Nodo aux = this.inicio;
        for (int i = 1; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getDato();
    }

    @Override
    public boolean agregarEn(int elem, int pos) {
        if (pos<0 || pos>this.tamanio) {
            return false;
        }
        Nodo nuevo = new Nodo(elem);
        if (pos == 0) {
            nuevo.setSiguiente(this.inicio);
            this.inicio = nuevo;
        } else {
            Nodo aux = this.inicio;
            for (int i = 1; i < pos; i++) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        this.tamanio++;
        return true;
    }

    @Override
    public boolean agregarInicio(int elem) {
        return agregarEn(elem, 0);
    }

    @Override
    public boolean agregarFinal(int elem) {
        return agregarEn(elem, this.tamanio);
    }

    @Override
    public boolean eliminarEn(int pos) {
        if (pos<0 || pos>=this.tamanio) {
            return false;
        }
        if (pos == 0) {
            this.inicio = this.inicio.getSiguiente();
        } else {
            Nodo aux = this.inicio;
            for (int i = 1; i < pos; i++) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        this.tamanio--;
        return true;
    }

    @Override
    public boolean eliminar(int elem) {
        Nodo aux = this.inicio;
        int pos = 0;
        while (aux != null && aux.getDato() != elem) {
            aux = aux.getSiguiente();
            pos++;
        }
        if (aux == null) {
            return false;
        }
        return eliminarEn(pos);
    }

    @Override
    public boolean incluye(int elem) {
        Nodo aux = this.inicio;
        while (aux != null && aux.getDato() != elem) {
            aux = aux.getSiguiente();
        }
        return aux != null;
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    @Override
    public int tamanio() {
        return this.tamanio;
    }

    @Override
    public void imprimir() {
        Nodo aux = this.inicio;
        while (aux != null) {
            System.out.print(aux.getDato() + "==>");
            aux = aux.getSiguiente();
        }
        System.out.println("null");
    }
}