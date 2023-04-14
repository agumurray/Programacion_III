public class Cola<T> {
    private ListaGenericaEnlazada<T> cola;

    public Cola () {
        cola = new ListaGenericaEnlazada<T>();
    }

    public void comenzar() {
        cola.comenzar();
    }

    public T getTope() {
        return this.cola.elemento(0);
    }

    public void encolar(T elem) {
        this.cola.agregarFinal(elem);
    }

    public T desencolar() {
        T aux = this.cola.elemento(0);
        this.cola.eliminarEn(0);
        return aux;
    }

    public boolean esVacia() {
        return this.cola.esVacia();
    }
}