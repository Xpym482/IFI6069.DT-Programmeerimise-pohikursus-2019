public class QuadricFunction2{

    double a;
    double b;
    double c;

    double x1;
    double x2;

    public QuadricFunction2(double _a, double _b, double _c) {
        this.a = _a;
        this.b = _b;
        this.c = _c;

        this.getX1();
        this.getX2();
    }

    public void getX1() {
        double sqrt_content = Math.pow(this.b, 2.0) - 4 * this.a * this.c;
        double sqrt_calculated = Math.sqrt(sqrt_content);

        if (Double.isNaN(sqrt_calculated)) {
            throw new ArithmeticException("Ruutjuure sisu, peab olema nullist suurem.");
        } else {
            this.x1 = (-this.b + sqrt_content) / (this.a * 2);
        }

    }

    public void getX2() {
        double sqrt_content = Math.pow(this.b, 2.0) - 4 * this.a * this.c;
        double sqrt_calculated = Math.sqrt(sqrt_content);

        if (Double.isNaN(sqrt_calculated)) {
            throw new ArithmeticException("Ruutjuure sisu, peab olema nullist suurem.");
        } else {
            this.x2 = (-this.b - sqrt_content) / (this.a * 2);
        }
    }


 

    
}