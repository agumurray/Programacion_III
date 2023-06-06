package Modulo1.Practica3B.Ej4;

import Clases.ListaGenerica.utils.Pila;

public class TestBalanceo {
    public static void main(String[] args) {
        String str = new String("{( ) [ ( ) ] }");

        if (estaBalanceado(str))
            System.out.println("El string esta balanceado.");
        else 
            System.out.println("El string no esta balanceado");
    } 
    public static boolean estaBalanceado(String str) {
        Character aux;
        Pila<Character> pila = new Pila<Character>();
        for (int i = 0; i<str.length(); i++) {
        if ((str.charAt(i) == '{') || (str.charAt(i) == '[') || (str.charAt(i) == '(')) {
           pila.apilar(str.charAt(i));
        }

        else if ((str.charAt(i) == '}') || (str.charAt(i) == ']') || (str.charAt(i) == ')')) {
            if (pila.esVacia())
                return false;
            if (((str.charAt(i) == '}') && (pila.getTope() == '{')) || ((str.charAt(i) == ']') && (pila.getTope() == '[')) || ((str.charAt(i) == ')') && (pila.getTope() == '('))) {
                aux = pila.desapilar();
            }
            else 
                return false;
        }

    }
        if (pila.esVacia())
            return true;
        return false;
    }
}
