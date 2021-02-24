package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int am = s.nextInt();
        int an = s.nextInt();
        Matrix a = new Matrix(am, an);
        a.fillMatrixFromKeyboard(s);

        int bm = s.nextInt();
        int bn = s.nextInt();
        Matrix b = new Matrix(bm, bn);
        b.fillMatrixFromKeyboard(s);

        //Matrix summary = a.add(b);
        //summary.displayMatrix();

        Matrix mult = a.multiply(b);
        mult.displayMatrix();
    }
}
