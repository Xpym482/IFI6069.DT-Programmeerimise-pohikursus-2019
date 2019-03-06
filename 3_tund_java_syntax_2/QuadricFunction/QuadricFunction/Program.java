 
 public class Program{

    public static void main(String[] args) {
        QuadricFunction esimene_ruutvorrand = new QuadricFunction(2, 3, -5);
        double x1 = esimene_ruutvorrand.getX1();
        double x2 = esimene_ruutvorrand.getX2();

       /*  
        System.out.println(x1);
        System.out.println(x2);
        */

        QuadricFunction2 teine_ruutvorrand = new QuadricFunction2(2, 3, -5);
        System.out.println(teine_ruutvorrand.x1);
        System.out.println(teine_ruutvorrand.x2);




    }
 }