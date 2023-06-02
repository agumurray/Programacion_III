public class ListaDeEnterosConArreglos extends ListaDeEnteros{
    private int tamanio;
    private int[] datos = new int[200];
    private int actual = 0;

    @Override
    public void comenzar() {
        this.actual = 0;
    }

    @Override
    public int proximo() {
        return datos[actual++];
    }

    @Override
    public boolean fin() {
        return actual == tamanio;
    }

    @Override
    public int elemento(int pos) {
        return datos[pos-1];
    }

    @Override
    public boolean agregarEn(int elem, int pos) {
        if (pos<0 || pos>datos.length || pos > tamanio || tamanio == datos.length) {
            return false;
        }
    tamanio++;
    for (int i = tamanio -1; i > pos; i--) {
        datos[i] = datos[i-1];
    }
    datos[pos] = elem;
    return true;
    }

    @Override
    public boolean agregarInicio(int elem) {
        return agregarEn(elem, 0);
    }

    @Override
    public boolean agregarFinal(int elem) {
        return agregarEn(elem, tamanio);
    }

    @Override
    public boolean eliminarEn(int pos) {
        if (pos<0 || pos>tamanio) {
            return false;
        }
        for (int i = pos; i < tamanio-1; i++) {
            datos[i] = datos[i+1];
        }
        tamanio--;
        return true;
    }

    @Override 
    public boolean eliminar(int elem) {
        int pos = 0;
        while (pos < tamanio && datos[pos] != elem) {
            pos++;
        }
        if (pos == tamanio) {
            return false;
        }
        return eliminarEn(pos);
    }

    @Override
    public boolean incluye(int elem) {
        int pos = 0;
        while (pos < tamanio && datos[pos] != elem) {
            pos++;
        }
        return pos < tamanio;
    }

    @Override
    public boolean esVacia() {
        return tamanio == 0;
    }

    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < tamanio; i++) {
            System.out.print(datos[i] + "==>");
        }
        System.out.println("null");
    }

}
