package DataSt;

import java.util.*;

public class Stk_Hm {
    public static void main(String[] args) {
        // 순차적 접근 , 이전 데이터와 신규 데이터가 같을 때 연산에 이용
        Stack<Integer> stk = new Stack<>();

        if(stk.empty()){
            stk.push(1);
            stk.push(2);
            stk.push(3);
        }
        if (!stk.empty()){
            if(stk.peek()==3)
                stk.pop();
        }
        // 없으면 -1 리턴
        if(stk.search(3)==-1){
            System.out.println("3 is poped");
        }

        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("key1", 1);
        hm.put("key2", 2);
        hm.put("key3", 3);

        if(hm.containsKey("key1") && hm.containsValue(1))
            System.out.println("Yes");

        hm.put("key1", hm.getOrDefault("key1", 0)*10);
        List<String> keyList = new ArrayList<>(hm.keySet());

        keyList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int v1 = hm.get(s1);
                int v2 = hm.get(s2);

                return Integer.compare(v1, v2);
            }
        });

        keyList.forEach(System.out::println);

    }

}

