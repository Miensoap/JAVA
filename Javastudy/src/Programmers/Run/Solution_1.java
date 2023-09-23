package Programmers.Run;

import java.util.Arrays;

public class Solution_1 {
    public String solution(String[] participant, String[] completion){
        String answer="";
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i= 0;
        for(;i < completion.length; i++)
            if(!participant[i].equals(completion[i]))
                break;

        return participant[i];
    }
    public static void main(String[] args) {
        String [] part = {"leo","kiki", "eden"};
        String [] comp = {"eden","kiki"};
        Solution_1 sol = new Solution_1();
        System.out.println(sol.solution(part,comp));


    }
}