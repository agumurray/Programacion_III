package Clases.Grafo.utils;

class CostoHeap<T> implements Comparable<CostoHeap<T>> {
    private int pos;
    private int costo;

    public CostoHeap(int pos, int costo) {
        this.pos = pos;
        this.costo = costo;
    }

    public CostoHeap() {
        
    }

    public int getPos() {
        return pos;
    }

    public int getCosto() {
        return costo;
    }

    @Override
    public int compareTo(CostoHeap<T> otro) {
        return Integer.compare(costo, otro.getCosto());
    }
}
