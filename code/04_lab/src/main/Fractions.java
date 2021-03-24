package main;

import java.util.Iterator;
import java.util.Scanner;

public class Fractions implements Iterable<Fraction> {
    int amount;
    Fraction [] data;

    public Fractions(Fraction[] _data, int _amount) {
        this.data = _data;
        this.amount = _amount;
    }

    public void inputFractionsFromKeyboard() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < amount; ++i) {
            String f = s.nextLine();
            String[] parts = f.split("/");
            data[i] = new Fraction(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
    }

    private class FractionIterator implements Iterator<Fraction> {
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < amount;
        }

        @Override
        public Fraction next() {
            return data[pos++];
        }
    }

    @Override
    public Iterator<Fraction> iterator() {
        return new FractionIterator();
    }
}