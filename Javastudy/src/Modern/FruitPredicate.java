package Modern;

@FunctionalInterface
public interface FruitPredicate<T> {
    boolean test(T t);
}
