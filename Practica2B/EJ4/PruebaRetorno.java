public class PruebaRetorno{
    public static String procesarArregloString(int[] arreglo) {
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
       double promedio = 0;
       
       for (int i = 0; i < arreglo.length; i++) {
           if (arreglo[i] > max) {
               max = arreglo[i];
           }
           if (arreglo[i] < min) {
               min = arreglo[i];
           }
           promedio += arreglo[i];
       }

       promedio/=arreglo.length;

       return("El maximo es: " + max + " El minimo es: " + min + " El promedio es: " + promedio);
    }

    public static void procesarArregloOBJ(int[] arreglo, Resultado res) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double promedio = 0;

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
            if (arreglo[i] < min) {
                min = arreglo[i];
            }
            promedio += arreglo[i];
        }

        promedio/=arreglo.length;

        res.setMax(max);
        res.setMin(min);
        res.setPromedio(promedio);
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Resultado res = new Resultado(Integer.MIN_VALUE,Integer.MAX_VALUE, 0);
        System.out.println(procesarArregloString(arreglo));
        procesarArregloOBJ(arreglo, res);
        System.out.println(res);
    }
}