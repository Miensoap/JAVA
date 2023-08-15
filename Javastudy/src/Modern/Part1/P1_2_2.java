package Modern.Part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1_2_2 {
    @FunctionalInterface
    public interface FruitPredicate<T> {
        boolean test(T t);
    }
    public static <T> List<T> newfilter (List < T > list, P1_2_2.FruitPredicate<T> p){
            List<T> result = new ArrayList<>();
            for (T e : list) {
                if (p.test(e)) {
                    result.add(e);
                }
            }
            return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> even =  P1_2_2.newfilter(numbers, (Integer i) -> i%2 ==0);

    }
}
