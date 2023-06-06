package Modulo1.Practica5B.Ej3;

import Clases.ListaGenerica.ListaGenerica;

public class Test {
   public static void main(String[] args) {
        Trie trie = new Trie();
        trie.agregarPalabra("arbol");
        trie.agregarPalabra("araña");
        trie.agregarPalabra("arañita");
        trie.agregarPalabra("arar");
        trie.agregarPalabra("hola");
        trie.agregarPalabra("hoja");
        trie.agregarPalabra("homo");
        trie.ImprimirPorNiveles();
        System.out.println("\n");

        ListaGenerica<StringBuilder> palabras = trie.palabrasQueEmpiezanCon("ar");
        System.out.println(palabras);

        };
  } 
