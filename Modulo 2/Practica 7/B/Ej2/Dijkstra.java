public class Dijkstra<T> {
    public Costo[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> v)  {
        Costo[] costos = new Costo[grafo.listaDeVertices().tamanio()];
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < costos.length; i++) {
            costos[i] = new Costo();
        }
        costos[v.posicion()].setMin(0);
        costos[v.posicion()].setPrevio(v.posicion());

        for (int i = 0; i < costos.length; i++) {
        int pos = verticeMenorDist(costos, marca);
        if (pos == -1) {
            break;
        }
        Vertice<T> u = grafo.listaDeVertices().elemento(pos);
        marca[pos] = true;
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<T> arista = adyacentes.proximo();
            Vertice<T> destino = arista.verticeDestino();
             if ((!marca[destino.posicion()]) && (costos[destino.posicion()].getMin() > costos[u.posicion()].getMin() + arista.peso())) {
                    costos[destino.posicion()].setMin(costos[u.posicion()].getMin() + arista.peso());
                    costos[destino.posicion()].setPrevio(u.posicion());
                }
        }
    }
        return costos;
    }

    private int verticeMenorDist(Costo[] costos, boolean[] marca) {
        int minDistancia = Integer.MAX_VALUE;
        int minPos = -1;

        for (int i = 0; i < costos.length; i++) {
            if ((!marca[i]) && (costos[i].getMin() < minDistancia)) {
                minDistancia = costos[i].getMin();
                minPos = i;
            }
        }
        return minPos;
    }
}
