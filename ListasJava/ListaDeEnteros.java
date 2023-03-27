public abstract class ListaDeEnteros {
   public abstract void comenzar();
    public abstract int proximo();
    public abstract boolean fin();

    public abstract int elemento(int pos);

    public abstract boolean agregarEn(int elem, int pos);
    public abstract boolean agregarInicio(int elem);
    public abstract boolean agregarFinal(int elem);

    public abstract boolean eliminarEn(int pos);
    public abstract boolean eliminar(int elem);

    public abstract boolean incluye(int elem);
    public abstract boolean esVacia();
    public abstract int tamanio();

    public abstract void imprimir();
}
