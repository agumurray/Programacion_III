package Modulo2.Practica7.A.Ej6;

import javax.crypto.AEADBadTagException;
import Clases.Grafo.Grafo;
import Clases.Grafo.Vertice;
import Clases.Grafo.Arista;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;
import Clases.ListaGenerica.utils.Cola;

public class Mapa<T> {
   private Grafo<String> mapaCiudades;

    public void setMapa(Grafo<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }


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

    public ListaGenericaEnlazada<String> devolverCamino(String ciudad1, String ciudad2) {
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        ListaGenericaEnlazada<String> camino = new ListaGenericaEnlazada<>();
    
        // Buscar el vértice correspondiente a la ciudad de origen
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
    
        if (i < marca.length) {
            devolverCamino(i, mapaCiudades, camino, marca, ciudad2);
        }
    
        return camino;
    }

    private boolean devolverCamino(int i, Grafo<String> mapaCiudades, ListaGenericaEnlazada<String> camino, boolean[] marca, String destino) {
        marca[i] = true;
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        if (v.dato().equals(destino)) {
            camino.agregarFinal(v.dato().toString());
            return true;
        }
            ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(v);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                int j = adyacentes.proximo().verticeDestino().posicion();
                if (!marca[j]) {
                    if (devolverCamino(j, mapaCiudades, camino, marca, destino)) {
                        camino.agregarInicio(v.dato().toString());
                        return true;
                    }
                }
            }
        return false;
    }

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) {
            devolverCaminoExceptuando(i, mapaCiudades, camino, marca, ciudad2, ciudades);
        }
        return camino;
    }

    private void devolverCaminoExceptuando(int i, Grafo<String> mapaCiudades, ListaGenerica<String> camino, boolean[] marca, String destino, ListaGenerica<String> ciudades) {
        marca[i] = true;
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        if (v.dato().equals(destino)) {
            camino.agregarFinal(v.dato().toString());
            return;
        }

        ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(v);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            int j = adyacentes.proximo().verticeDestino().posicion();
            if (!marca[j] && !ciudades.incluye(mapaCiudades.listaDeVertices().elemento(j).dato())) {
                devolverCaminoExceptuando(j, mapaCiudades, camino, marca, destino, ciudades);
                if (camino.tamanio() > 0) {
                    camino.agregarInicio(v.dato().toString());
                    return;
                }
            }
        }
    }

    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<String> aux = new ListaGenericaEnlazada<>();
        ListaGenerica<String> res = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) {
            caminoMasCorto(i, mapaCiudades, aux, marca, ciudad2, res);
        }
        return res;
    }

    private void caminoMasCorto(int i, Grafo<String> mapaCiudades, ListaGenerica<String> aux, boolean[] marca, String destino, ListaGenerica<String> res) {
        marca[i] = true;
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        aux.agregarFinal(v.dato());
        if (v.dato().equals(destino)) {
            if ((res.tamanio() == 0) || (aux.tamanio() < res.tamanio())) {
                copiarCamino(res, aux);
            }
            return;
        }

        ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.listaDeVertices().elemento(i));
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            int j = adyacentes.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                caminoMasCorto(j, mapaCiudades, aux, marca, destino, res);
                marca[j] = false;
                aux.eliminarEn(aux.tamanio() - 1);
            }
        }
    }

    private void copiarCamino(ListaGenerica<String> res, ListaGenerica<String> aux) {
        while (!res.esVacia()) {
            res.eliminarEn(0);
        }
        aux.comenzar();
        while (!aux.fin()) {
            res.agregarFinal(aux.proximo());
        }
    }

    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }

        if (i < marca.length) {
            caminoSinCargarCombustible(i, mapaCiudades, camino, marca, ciudad2, tanqueAuto);
        }
        return camino;
    }

    private void caminoSinCargarCombustible(int i, Grafo<String> mapaCiudades, ListaGenerica<String> camino, boolean[] marca, String destino, int tanqueAuto) {
        marca[i] = true;
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        if (v.dato().equals(destino)) {
            if (tanqueAuto>0) {
                camino.agregarFinal(destino);
            }
            return;
        }

        ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(v);

        adyacentes.comenzar();
        while(!adyacentes.fin()) {
            Arista<String> arista = adyacentes.proximo();
            int j = arista.verticeDestino().posicion();
            if (!marca[j]) {
                caminoSinCargarCombustible(j, mapaCiudades, camino, marca, destino, tanqueAuto - arista.peso());
                if (!camino.esVacia()) {
                    camino.agregarInicio(v.dato());
                    return;
                }
            }
        }
    }

    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<>();
        ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) {
            caminoConMenorCargaDeCombustible(i, marca, mapaCiudades, ciudad2, tanqueAuto, tanqueAuto, 0,0, camino, caminoActual);
        }
        return camino;
    }

    private void caminoConMenorCargaDeCombustible(int i, boolean[] marca, Grafo<String> grafo, String ciudad2, int capacidad, int tanque, int carga, int cargaActual, ListaGenerica<String> camino, ListaGenerica<String> caminoActual) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        caminoActual.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if ((camino.tamanio() == 0) || (cargaActual < carga)) {
                copiarCamino(camino, caminoActual);
                carga = cargaActual;
            }
            return;
        }

        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> aux = adyacentes.proximo();
            int j = aux.verticeDestino().posicion();
            if (!marca[j]) {
                tanque -= aux.peso();
                if (tanque <= 0 && capacidad > aux.peso()) {
                    tanque = capacidad;
                    cargaActual++;
                }
                if (capacidad > aux.peso()) {
                    caminoConMenorCargaDeCombustible(j, marca, grafo, ciudad2, capacidad, tanque, carga, cargaActual, camino, caminoActual);
                    marca[j] = false;
                    caminoActual.eliminarEn(caminoActual.tamanio() - 1);}
            }
        }
    }
}