package Modern.Part1;

import java.util.*;

public class P1_1<T>{
    static Apple apple1 = new Apple("GREEN", 200);
    static Apple apple2 = new Apple("RED" , 120);
    static List <Apple> inventory1 = new ArrayList<>(Arrays.asList(apple1,apple2));

    public static void main(String[] args) {
        List<Apple> greenApples =
            filterApples(inventory1, new AppleGreenColorPredicate());

         // 5. 익명 클래스 사용
        List<Apple> redApples = filterApples(inventory1, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "RED".equals(apple.getColor());
            }
        });

        // 6. 람다 표현식사용
        List<Apple> HeavyApples = filterApples(inventory1, apple -> apple.getWeight() > 150);

    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        // 4. 추상적 조건으로 필터링
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }

}

// 3. 동작 파라미터화
interface ApplePredicate {
    boolean test(Apple apple);
}
class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate{
    public boolean test(Apple apple){
        return "GREEN".equals(apple.getColor());
    }
}






