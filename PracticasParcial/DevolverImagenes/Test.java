public class Test {
    public static void main(String[] args){
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(1);
        //hace un arbol random
        a.agregarHijo(new ArbolGeneral<Integer>(2));
        a.agregarHijo(new ArbolGeneral<Integer>(3));
        a.agregarHijo(new ArbolGeneral<Integer>(4));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(1));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(1));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(1));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(8));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(9));

        //como tengo un arbol de enteros, el numero 1 equivale a un archivo de tipo imagen
        System.out.println(a.cantImagenes(2));
    }    
}