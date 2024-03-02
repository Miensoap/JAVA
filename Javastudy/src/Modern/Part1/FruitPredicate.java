package Modern.Part1;

@FunctionalInterface
public interface FruitPredicate<T> {
    boolean test(T t);
}
