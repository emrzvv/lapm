package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Paper implements Comparable<Paper> {
    public String title;
    public int citations;
    public int order;

    public Paper(String _title, int _hIndex, int _order) {
        this.title = _title;
        this.citations = _hIndex;
        this.order = _order;
    }

    public String toString() {
        return title + " " + Integer.toString(citations) + " " + Integer.toString(order);
    }

    public void display() {
        System.out.println("[Title]: " + title + " [citations]: " + citations + " [order]: " + order);
    }

    @Override
    public int compareTo(Paper p) {
        return Integer.compare(this.citations, p.citations);
    }
}

public class Publications implements Comparable<Publications>{
    public String scientistName;
    public Paper[] papers;
    public int papersAmount;

    @Override
    public int compareTo(Publications pub) {
        return Integer.compare(this.getHirshIndex(), pub.getHirshIndex());
    }

    public boolean hPapersHaveMinhCitations(int h) {
        int amount = 0;
        for (Paper p : papers) {
            if (p.citations >= h) {
                amount++;
            }
        }
        return h <= amount;
    }

    public int getHirshIndex() {
        this.sortPublications();
        int l = 0, r = Integer.min(papersAmount, papers[papersAmount - 1].citations);
        while (l <= r) {
            int m = l + (r - l) / 2;
            //System.out.println(l + " " + m + " " + r);
            if (hPapersHaveMinhCitations(m)) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return l - 1;
    }

    public Publications(String _scientistName, Paper[] _papers) {
        this.scientistName = _scientistName;
        this.papers = _papers;
        this.papersAmount = this.papers.length;
    }

    public Publications(String _scientistName, int _papersAmount) {
        this.scientistName = _scientistName;
        this.papers = new Paper[_papersAmount];
        this.papersAmount = _papersAmount;
    }

    public void fillPublicationsWithMap(HashMap<String, Integer> data) {
        int i = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            this.papers[i] = new Paper(entry.getKey(), entry.getValue(), i + 1);
            i++;
        }
    }

    public void fillPublicationsFromKeyboard() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < this.papersAmount; ++i) {
            String[] input = s.nextLine().split(" ");
            this.papers[i] = new Paper(input[0], Integer.parseInt(input[1]), i + 1);
        }
    }

    public void sortPublications() {
        Arrays.sort(this.papers);
    }

    public void displayPublications() {
        for (Paper p : this.papers) {
            p.display();
        }
    }
}
