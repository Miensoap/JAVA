package Modern.Part2;

import java.util.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

// Ch4. Stream
public class P2_1 {
    public static List <Dish> menu = new ArrayList<>(Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef",false,700, Dish.Type.MEAT),
            new Dish("chicken",false,400,Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    ));
    public static void main(String[] args) {
       List<Dish> lowCaloricDishes = new ArrayList<>();

       for(Dish dish : menu){
           if (dish.getCalories() < 400){
               lowCaloricDishes.add(dish);
           }
       }
       lowCaloricDishes.sort(new Comparator<Dish>() {
           public int compare(Dish dish1, Dish dish2) {
               return Integer.compare(dish1.getCalories(), dish2.getCalories());
           }
       });

       List<String> lowCaloricDishesName = new ArrayList<>();
       for(Dish d : lowCaloricDishes){
           lowCaloricDishesName.add(d.getName());
       }

       List<String> newLowCaloricDishesName =
               menu.parallelStream() // 병렬 실행
                       .filter(d -> d.getCalories()<400) // 400칼로리 이하의 요리 선택
                       .sorted(comparing(Dish::getCalories)) // 칼뢰리로 요리 정렬
                       .map(Dish::getName) // 요리명 추출
                       .collect(toList()); // 모든 요리명을 리스트에 저장

        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        List<String> names =
                menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering : "+ dish.getName());
                            return dish.getCalories() > 300;
                        })
                        .map(dish ->{
                            System.out.println("mapping : "+ dish.getName());
                            return dish.getName();
                        })
                        .limit(3)
                        .collect(toList());
        System.out.println(names);
    }
}
