package Modulo1.Practica2B.EJ2;

public class Perro extends Animal {
   @Override
   public void saludo() {
      System.out.println("Guau!");
   }

   public void saludo(Perro otro) {
    System.out.println("Guau, guau!");
   }
}
