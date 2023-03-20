public class TestTablet {
    public static void main(String[] args) {
        Tablet[] tablets = new Tablet[3];

        Tablet tablet1 = new Tablet("Apple", "iOS", "iPad Air", 499.99, 10.9f);
        Tablet tablet2 = new Tablet("Samsung", "Android", "Galaxy Tab S7", 649.99, 11.0f);
        Tablet tablet3 = new Tablet("Amazon", "Fire OS", "Fire HD 10", 149.99, 10.1f);
        
        tablets[0] = tablet1;
        tablets[1] = tablet2;
        tablets[2] = tablet3;
        
        for (int i=0; i<tablets.length; i++) {
            System.out.println(tablets[i].devolverDatos());
        }
    }


}
