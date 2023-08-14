package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=0; i<number+1; i++){
            answer+=is_3(i);
        }
        return answer;
    }

    static long is_3(int number){
        String strnum = number+"";
        long clap = strnum.chars().filter(c->c=='3' || c=='6' || c=='9').count();
        return clap;
    }
}
