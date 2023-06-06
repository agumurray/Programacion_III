package Modulo1.Practica2B.EJ3;

public class SwapValores {
    public static void swap1 (int x, int y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }

public static void swap2 (Integer x, Integer y) {
    if (x < y) {
        int tmp = x ;
        x = y ;
        y = tmp;
    }
}

    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a,b); //no funciona porque se manda una copia del valor
        swap2(c,d); // no funciona porque se manda una copia del objeto
        System.out.println("a=" + a + " b=" + b) ;
        System.out.println("c=" + c.intValue() + " d=" + d) ;
    }
}