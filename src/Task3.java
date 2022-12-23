public class Task3 {
    public static void main(String[] args){
        double a = 0.0;
        double b = 10.0;
        double e = 0.00000001;
        double fa = f(a);
        double fb =  f(b);
        System.out.println(HalfDivisionMethod(a, b, fa, fb, e));

    }
    private static double f(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    private static double HalfDivisionMethod(double a, double b, double fa, double fb, double e) {
        double c = (a + b)/2;
        if (Math.abs(a - b) < e) return c;
        double fc = f(c);
        if (Math.abs(fc) < e) return c;
        if (fc * fa < 0)
            return HalfDivisionMethod(a, c, fa, fc, e);
        else
            return HalfDivisionMethod(c, b, fc, fb, e);
    }
}
