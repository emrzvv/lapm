package main;

import java.rmi.server.ExportException;

public class Example {
    public static int a;
    public int b;

    Example() {
        a = 1;
        b = 2;
    }

    public static void change_a(int x) {
        a = x;
    }

    public void change_a_2(int x) {
        a = x;
    }
}
