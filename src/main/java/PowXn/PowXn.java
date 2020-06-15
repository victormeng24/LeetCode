package PowXn;

public class PowXn {
    public static void main(String[] args) {
        System.out.println(new PowXn().myPow(2.0, Integer.MIN_VALUE));
    }
    public double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1.0 / fastPow(x, -n);
        double a = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return a * a;
        } else return a * a * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return fastPow(x, N);
    }
}
