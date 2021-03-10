package main;

/*
Класс, представляющий список публикаций учёного, с порядком на основе индекса Хирша.
*/

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> d = new HashMap<>();
        d.put("paper1", 8);
        d.put("paper2", 10);
        d.put("paper3", 12);
        d.put("paper4", 5);
        d.put("paper5", 4);
        d.put("paper6", 2);

        Publications p = new Publications("scientist", 6);
        p.fillPublicationsFromKeyboard();

        p.displayPublications();
        p.sortPublications();
        System.out.println();
        p.displayPublications();
    }
}
