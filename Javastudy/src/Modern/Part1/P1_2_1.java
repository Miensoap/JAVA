package Modern.Part1;

import java.util.*;

public class P1_2_1 {
    public  void main(String[] args) {

        Apple apple1 = new Apple("GREEN", 200);
        Apple apple2 = new Apple("RED", 120);
        List<Apple> inventory1 = new ArrayList<>(Arrays.asList(apple1, apple2));

        Comparator<Apple> byWeight =
                (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        List<Apple> greenApples =
                newfilter(inventory1, (Apple a) -> "GREEN".equals(a.getColor()));

    }
    // 7. List 형식으로 추상화
        public  static <T> List<T> newfilter (List < T > list, FruitPredicate<T> p){
            List<T> result = new ArrayList<>();
            for (T e : list) {
                if (p.test(e)) {
                    result.add(e);
                }
            }
            return result;
        }
}

