class IteradorAB{
    public static void main(String[] args){
        int a = 10;
        int b = 1;
        if (a<b) {
            iteracionConFor(a,b);
            iteracionConWhile(a,b);
            recursivo(a,b);
 }
    else {
          iteracionConFor(b,a);
          iteracionConWhile(b,a);
          recursivo(b,a);
    }
    }

    public static void iteracionConFor(int a, int b) {
        for (int i=a; i<=b; i++) {
            System.out.println(i);
        }
    }

    public static void iteracionConWhile(int a, int b) {
        while(a<=b) {
            System.out.println(a);
            a++;
        }
    }

    public static void recursivo(int a, int b) {  
        if (a<=b) {
            System.out.println(a);
            recursivo(a + 1, b);
        }
    }

}

/*metodo de instancia: es utilizado unicamente en la instanciacion de una clase (objeto). no puede ser llamado desde la clase en si
 * metodo de clase: puede ser utilizado por la misma clase, se debe anteponer el prefijo "static"
 * 
 * en este ejercicio resulta conveniente utilizar metodos de clase para poder ser utilizados dentro de la misma 
 * y ver los resultados en consola.
 */