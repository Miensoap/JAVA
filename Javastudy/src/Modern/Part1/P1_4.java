package Modern.Part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.util.Comparator.comparing;
public class P1_4 {
    public static void main(String[] args) {

        Apple apple1 = new Apple("GREEN", 200);
        Apple apple2 = new Apple("RED", 120);
        List<Apple> inventory1 = new ArrayList<>(Arrays.asList(apple1, apple2));

        // Comparator 조합
        Comparator<Apple> c = comparing(Apple::getWeight);
        inventory1.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));

        // Predicate 조합
        Predicate<Apple> redApple = (Apple apple) -> "RED".equals(apple1.getColor());
        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(apple -> apple.getWeight() >150)
                        .or(apple -> "GREEN'".equals(apple.getColor()));

        // Function 조합
        Function<Integer, Integer> f = x -> x+1;
        Function<Integer, Integer> g = x -> x*2;
        // f -> g
        Function<Integer, Integer> h = f.andThen(g);
        // g-> f
        Function<Integer, Integer> i = f.compose(g);
    }
}
