import java.util.Scanner;
public class Multiplos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        while (a != 0) {
            int[] multiplos = getMultiplos(a);
            for (int i=0; i < multiplos.length; i++) {
            System.out.println(multiplos[i]);

            }
            a = in.nextInt();
        }
        in.close();
    }

    public static int[] getMultiplos(int a) {
        int[] m = new int[a];
        for (int i=0; i<m.length; i++) {
            m[i] = a * (i + 1);
        }
        return m;
    }
}