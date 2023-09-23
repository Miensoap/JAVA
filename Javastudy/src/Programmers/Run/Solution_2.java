package Programmers.Run;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_2 {
    // Hash 사용
    public String solution(String[] participant, String[] completion){
        String answer="";
        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant)
            map.put(player, map.getOrDefault(player,0) + 1);

        for(String player : completion)
            map.put(player,map.get(player)-1);

        for(String key : map.keySet()){
            if(map.get(key)!=0){
                answer=key;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String [] part = {"leo","kiki", "eden"};
        String [] comp = {"eden","kiki"};
        Solution_1 sol = new Solution_1();
        System.out.println(sol.solution(part,comp));


    }
}
