class Multiplos {
    public static void main(String[] args) {
        int a=8;
        int[] multiplos = getMultiplos(a);
        for (int i=0; i < multiplos.length; i++) {
            System.out.println(multiplos[i]);
        }
    }

    public static int[] getMultiplos(int a) {
        int[] m = new int[a];
        for (int i=0; i<m.length; i++) {
            m[i] = a * (i + 1);
        }
        return m;
    }
}