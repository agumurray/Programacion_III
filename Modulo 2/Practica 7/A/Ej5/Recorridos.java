public class Recorridos<T> {
    public ListaGenericaEnlazada<Vertice<T>> dfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenericaEnlazada<Vertice<T>> lis = new ListaGenericaEnlazada<Vertice<T>>();
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.dfs(i, grafo, lis, marca);
        }
        return lis;
    }

    private void dfs(int i, Grafo<T> grafo, ListaGenericaEnlazada<Vertice<T>> lis,boolean[] marca) {
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        lis.agregarFinal(v);
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            int j = adyacentes.proximo().verticeDestino().posicion();
            if (!marca[j])
                this.dfs(j, grafo,lis, marca);
        }
    }

    public void bfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.bfs(i, grafo, marca);
        }
    }

    private void bfs(int i, Grafo<T> grafo, boolean[] marca) {
        ListaGenerica<Arista<T>> ady = null;
        Cola<Vertice<T>> q = new Cola<Vertice<T>>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while (!q.esVacia()) {
            Vertice<T> v = q.desencolar();
            System.out.println(v.dato());
            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]) {
                    Vertice<T> w = arista.verticeDestino();
                    marca[j] = true;
                    q.encolar(w);
                }
            }
        }
    }
}
