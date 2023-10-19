package BackJ.P4673_셀프넘버;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N = 10000;
    static List<Integer> no = new ArrayList<>();
    public static void main(String[] args) {

        for(int i=1; i<=N; i++){
            String str = Integer.toString(i);
            char[] chari = str.toCharArray();
            int sumi = i;

            for(char c : chari){
                sumi+= Integer.parseInt(Character.toString(c));
            }
            no.add(sumi);
        }

        for(int i=1; i<=N; i++ ){
            if(!no.contains(i)){
                System.out.println(i);
            }
        }
    }


}
