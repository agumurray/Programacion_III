public class Adivinanza {
    public static ListaGenericaEnlazada<String> secuenciaMayor(ArbolBinario<String> arbol) {
        ListaGenericaEnlazada<String> izq = new ListaGenericaEnlazada<String>();
        ListaGenericaEnlazada<String> der = new ListaGenericaEnlazada<String>();

        if(arbol.esHoja()) {
            ListaGenericaEnlazada<String> resultado = new ListaGenericaEnlazada<String>();
            resultado.agregarInicio(arbol.getDato());
            return resultado;
        }

        if (arbol.tieneHijoIzquierdo()) {
            izq = secuenciaMayor(arbol.getHijoIzquierdo());
        }

        if(arbol.tieneHijoDerecho()) {
            der = secuenciaMayor(arbol.getHijoDerecho());
        }

        if(izq.tamanio() >= der.tamanio()) {
            izq.agregarInicio("Si");
            izq.agregarInicio(arbol.getDato());
            return izq;
        }
        else {
            der.agregarInicio("No");
            der.agregarInicio(arbol.getDato());
            return der;
        }
    }

    public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciasMayores(ArbolBinario<String> abinario) {
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> izq = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> der = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> res = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    if (abinario.esHoja()) {
      ListaGenericaEnlazada<String> res1 = new ListaGenericaEnlazada<String>();
      res1.agregarInicio(abinario.getDato());
      res.agregarInicio(res1);
      return res;
    }
    if (abinario.tieneHijoIzquierdo()) {
      izq = secuenciasMayores(abinario.getHijoIzquierdo());
    }
    if (abinario.tieneHijoDerecho()) {
      der = secuenciasMayores(abinario.getHijoDerecho());
    }
    izq.comenzar();
    der.comenzar();
    if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() > der.elemento(0).tamanio())) {
      int i = 0;
      while (izq.elemento(i)!=null) {
        izq.elemento(i).agregarInicio("Si");
        izq.elemento(i).agregarInicio(abinario.getDato());
        i++;
      }
      return izq;
    } else if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() < der.elemento(0).tamanio())){
        int i = 0;
        while (der.elemento(i)!=null) {
          der.elemento(i).agregarInicio("Si");
          der.elemento(i).agregarInicio(abinario.getDato());
          i++;
        }
        return der;
      } else {
        int i = 0;
        while (izq.elemento(i) != null) {
          izq.elemento(i).agregarInicio("Si");
          izq.elemento(i).agregarInicio(abinario.getDato());
          res.agregarFinal(izq.elemento(i));
          i++;
        }
        i = 0;
        while (der.elemento(i)!=null) {
          der.elemento(i).agregarInicio("Si");
          der.elemento(i).agregarInicio(abinario.getDato());
          res.agregarFinal(der.elemento(i));
          i++;
        }
      return res;
    }
  }
}
