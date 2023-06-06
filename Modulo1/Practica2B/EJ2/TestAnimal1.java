package Modulo1.Practica2B.EJ2;

public class TestAnimal1 {
    public static void main(String[] args) {
        Gato gato1 = new Gato(); //instanciacion de objeto
        gato1.saludo();
        Perro perro1 = new Perro(); //instanciacion de objeto
        perro1.saludo();
        PerroGrande perroGrande1 = new PerroGrande(); //instanciacion de objeto
        perroGrande1.saludo();
        Animal animal1 = new Gato(); //instanciacion de objeto con upcasting
        animal1.saludo();
        Animal animal2 = new Perro(); //instanciacion de objeto con upcasting
        animal2.saludo();
        Animal animal3 = new PerroGrande(); //instanciacion de objeto con upcasting
        animal3.saludo();
        Perro perro2 =(Perro) animal2; //instanciacion de objeto con downcasting
        PerroGrande perroGrande2 = (PerroGrande) animal3; //instanciacion de objeto con downcasting
        Perro perro3 = (Perro) animal3; //instanciacion de objeto con downcasting
        Gato gato2 = (Gato) animal2; //instanciacion de objeto con downcasting
        perro2.saludo(perro3);
        perro3.saludo(perro2);
        perro2.saludo(perroGrande2);
        perroGrande2.saludo(perro2);
        perroGrande2.saludo(perroGrande1);
        gato2.saludo();
    }
}