package main;

public class Fraction {
    private int up;
    private int down;

    public Fraction(int _up, int _down) {
        this.up = _up;
        this.down = _down;
    }

    public String toString() {
        return Integer.toString(up) + "/" + Integer.toString(down);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }

    private static Fraction cutFraction(Fraction f) {
        int g = gcd(f.up, f.down);
        return new Fraction(f.up / g, f.down / g);
    }

    public static boolean mutuallyInverse(Fraction f, Fraction g) {
        Fraction a = Fraction.cutFraction(f);
        Fraction b = Fraction.cutFraction(g);
        return a.up == b.down && a.down == b.up;
    }
}
