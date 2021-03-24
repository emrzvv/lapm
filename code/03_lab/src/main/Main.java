package main;

/*
Класс, представляющий список публикаций учёного, с порядком на основе индекса Хирша.
*/

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Publications p1 = new Publications("scientist", 4);
        Publications p2 = new Publications("scientist2", 4);
        p1.fillPublicationsFromKeyboard();
        p2.fillPublicationsFromKeyboard();

        Publications[] data = {p1, p2};
        Arrays.sort(data);
        for (Publications p : data) {
            System.out.println(p.getHirshIndex());
            p.displayPublications();
        }

    }
}
/*
paper1 8
paper2 10
paper3 12
paper4 8
paper1 4
paper2 3
paper4 7
paper5 4
 */

/*
paper1 4
paper2 3
paper4 7
paper5 4
 */
//4й 19й
//5я 16й
