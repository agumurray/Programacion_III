public class Pila<T> {
    private ListaGenericaEnlazada<T> pila;
    
    public Pila() {
        pila = new ListaGenericaEnlazada<T>();
    }

    public void comenzar() {
        pila.comenzar();
    }

    public T getTope() {
        return this.pila.elemento(0);
    }

    public void apilar(T elem) {
        this.pila.agregarInicio(elem);
    }

    public T desapilar() {
        T aux = this.pila.elemento(0);
        this.pila.eliminarEn(0);
        return aux;
    }

    public boolean esVacia() {
        return this.pila.esVacia();
    }
}