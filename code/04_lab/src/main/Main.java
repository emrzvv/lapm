package main;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Fraction[] fRaw = new Fraction[7];
        fRaw[0] = new Fraction(1, 2);
        fRaw[1] = new Fraction(2, 3);
        fRaw[2] = new Fraction(3, 2);
        fRaw[3] = new Fraction(6, 4);
        fRaw[4] = new Fraction(6, 7);
        fRaw[5] = new Fraction(2, 3);
        fRaw[6] = new Fraction(7, 6);
	    Fractions fractions = new Fractions(fRaw, 7);

	    for (Fraction f : fractions) {
	        for (Fraction g : fractions) {
                if (Fraction.mutuallyInverse(f, g)) {
                    System.out.println(f.toString() + " " + g.toString());
                }
            }
        }


        /*Iterator<Fraction> i = fractions.iterator();
	    while (i.hasNext()) {
	        Fraction a = i.next();
	        Iterator<Fraction> j = fractions.iterator();
	        while (j.hasNext()) {
	            Fraction b = j.next();
	            if (Fraction.mutuallyInverse(a, b)) {
	                System.out.println(a.toString() + " " + b.toString());
                }
            }
        }*/
    }
}
