package Modulo1.ListasJava;

import java.util.Scanner;
import Clases.ListaDeEnteros.ListaDeEnterosEnlazada;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        System.out.println("Ingrese un entero para meter en la lista: ");
        int n = in.nextInt();
        while (n!=-1) {
            lista.agregarFinal(n);   
            System.out.println("Ingrese un entero para meter en la lista: ");
            n = in.nextInt();
        }
       in.close(); 
       lista.imprimir();
    }
}
    


