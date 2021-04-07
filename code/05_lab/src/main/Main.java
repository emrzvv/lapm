package main;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Lines allLines = new Lines();
        allLines.addInTail(new Node<String>("abacaba"));
        allLines.addInTail(new Node<String>("abacaba"));
        allLines.addInTail(new Node<String>("abc"));
        allLines.addInTail(new Node<String>("zzz"));
        allLines.addInTail(new Node<String>("zzz"));
        allLines.addInTail(new Node<String>("zz"));
        allLines.addInTail(new Node<String>("abcd"));
        allLines.addInTail(new Node<String>("123567"));
        allLines.addInTail(new Node<String>("123"));

        /*allLines.addInTail(new Node<>("1"));
        allLines.addInTail(new Node<>("999"));
        allLines.addInTail(new Node<>("22"));
        allLines.addInTail(new Node<>("333"));*/

        Stream<Node<String>> s = allLines.getStream();
        s.forEach(Node::display);

        Optional<Integer> res = allLines.getOptional();
        System.out.println(Optional.ofNullable(res));
    }
}
