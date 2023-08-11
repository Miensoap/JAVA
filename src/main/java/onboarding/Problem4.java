package onboarding;
import java.util.*;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = decode(word);
        return answer;
    }

    static String decode(String word){
        StringBuilder sb= new StringBuilder();
        sb.append(word);
        int length=sb.length();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<length; i++ ) {
            if (65 <= (int) sb.charAt(i) && (int) sb.charAt(i) <= 90)
                list.add(155 - (int) sb.charAt(i));

            if (97 <= (int) sb.charAt(i) && (int) sb.charAt(i) <= 122)
                list.add(219 - (int) sb.charAt(i));

            if (sb.charAt(i) == ' ')
                list.add(64);
        }

        StringBuilder answer = new StringBuilder();

        for (Integer integer : list) {
            char ch = (char) (int) integer;
            if (integer == 64)
                answer.append(' ');
            else
                answer.append(ch);
        }
        return answer.toString();
    }
}


