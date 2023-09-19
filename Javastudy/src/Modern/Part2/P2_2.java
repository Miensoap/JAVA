package Modern.Part2;
import java.util.List;
import static Modern.Part2.P2_1.menu;
import static java.util.stream.Collectors.toList;
public class P2_2 {
    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);
    }
}
