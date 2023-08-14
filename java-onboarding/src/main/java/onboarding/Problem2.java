package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer="answer";
         while (true) {
            answer = decode(cryptogram);
            if (answer.equals(cryptogram)){ // 전이랑 똑같으면 그만
                break;
            }
            cryptogram = answer;
        }
        return answer;
    }

    static String decode(String word){
        StringBuilder sb= new StringBuilder();
        sb.append(word);
        int length=sb.length();
        for (int i=0; i<length-1; i++ ){
            if (sb.charAt(i)==sb.charAt(i+1)){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
//                length-=2;
                return sb.toString();
            }
        }

        return sb.toString();
    }
}
