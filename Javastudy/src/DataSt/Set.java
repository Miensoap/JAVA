package DataSt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Set {
    public static void main(String[] args) {
        // 정렬되어 저장
        TreeSet<String> ts = new TreeSet<>();
        ts.add("apple");
        ts.add("core");
        ts.add("banana");

        ts.forEach(System.out::println);

        // 정렬 X
        HashSet<String> hs = new HashSet<>(ts);
        hs.forEach(System.out::println);

        hs.removeIf(element -> element.length() % 2 == 0);
        hs.forEach(System.out::println);
    }
}
