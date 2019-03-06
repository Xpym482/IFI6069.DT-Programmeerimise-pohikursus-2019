import java.lang.Math;

public class QuadricFunction {
    double a;
    double b;
    double c;

    // QuadricFunction esimene = new QuadricFunction(2, 3, -5);
    // _a = 2; b_ = 3; _c = -5
    // esmine.a = 2; esimene.b = 3; esimene.c = -5;
    public QuadricFunction(double _a, double _b, double _c) {
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }

    public double getX1() {
        double sqrt_content = Math.pow(this.b, 2.0) - 4 * this.a * this.c;
        double sqrt_calculated = Math.sqrt(sqrt_content);
        if (Double.isNaN(sqrt_calculated)) {
            throw new ArithmeticException("Ruutjuure sisu, peab olema nullist suurem.");
        } else {
            return (-this.b + sqrt_content) / (this.a * 2);
        }

    }

    public double getX2() {
        double sqrt_content = Math.pow(this.b, 2.0) - 4 * this.a * this.c;
        double sqrt_calculated = Math.sqrt(sqrt_content);
        if (Double.isNaN(sqrt_calculated)) {
            throw new ArithmeticException("Ruutjuure sisu, peab olema nullist suurem.");
        } else {
            return (-this.b - sqrt_content) / (this.a * 2);
        }
    }

}