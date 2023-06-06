public class DispositivosMoviles {
    public static void main(String[] args) {
        Mobile sm1 = new SmartPhone("Samsung", "Android", "Galaxy S10", 10000, 123456789);
        Mobile sm2 = new SmartPhone("Samsung", "Android", "Galaxy S10", 10000, 123456789);
        Mobile t1 = new Tablet("Apple", "iOS", "iPad", 10000, 10);
        Mobile t2 = new Tablet("Samsung", "Android", "TAB3", 10000, 10);


        System.out.println(sm1);
        System.out.println(sm2);
        System.out.println(t1);
        System.out.println(t2);

        System.out.println(sm1.equals(sm2));
        System.out.println(t1.equals(t2));
    }
}