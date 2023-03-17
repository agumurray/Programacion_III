import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        System.out.println("Ingrese un entero para meter en la lista: ");
        int n = in.nextInt();
        while (n!=-1) {
            lista.agregar(n);   
            System.out.println("Ingrese un entero para meter en la lista: ");
            n = in.nextInt();
        }
        in.close();
        lista.imprimir();
    }
}