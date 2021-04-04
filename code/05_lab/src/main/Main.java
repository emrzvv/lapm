package main;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>(Arrays.asList("aba", "abacaba", "aba", "abc", "abacaba", "zzz"));
        ArrayList<Stream<String>> streams = new ArrayList<>();

        HashSet<String> checker = new HashSet<>();

        lines.forEach((line) -> {
            if (!checker.contains(line)) {
                checker.add(line);
                streams.add(lines.stream().filter(line::equals));
            }
        });

        streams.forEach((s) -> {
            s.forEach((toPrint) -> {System.out.print(toPrint + " ");});
            System.out.println();
        });
    }
}
