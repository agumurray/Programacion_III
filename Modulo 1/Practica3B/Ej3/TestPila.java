public class TestPila {
   public static void main(String[] args) {
      Pila<Character> pila = new Pila<Character>();
      Character tope;

      pila.apilar('a');
      pila.apilar('b');
      pila.apilar('c');
      pila.apilar('d');
      pila.apilar('e');

     tope = pila.desapilar(); 
     tope = pila.desapilar(); 
     tope = pila.desapilar(); 
     tope = pila.desapilar(); 

     System.out.println(pila.getTope());
   } 
}
