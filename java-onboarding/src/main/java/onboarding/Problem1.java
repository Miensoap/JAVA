package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {


        int pobi_left=pobi.get(0);
        int pobi_right = pobi.get(1);
        if (pobi_left!=pobi_right-1)
            return -1;

        int pobi_leftans=maxreturn(pobi_left);
        int pobi_rightans=maxreturn(pobi_right);
        int pobi_ans=Math.max(pobi_leftans,pobi_rightans);

        int crong_left=crong.get(0);
        int crong_right = crong.get(1);
        if (crong_left!=crong_right-1)
            return -1;

        int crong_leftans=maxreturn(crong_left);
        int crong_rightans=maxreturn(crong_right);
        int crong_ans=Math.max(crong_rightans,crong_leftans);

        int answer = Integer.MAX_VALUE;

        if (pobi_ans>crong_ans)
                answer = 1;
        else if (pobi_ans<crong_ans)
                answer = 2;
        else
            answer=0;

        return answer;
    }

    static int maxreturn(int page){
        String strpage=String.valueOf(page);
        int [] arrNum = new int[strpage.length()];
        for (int i =0; i<strpage.length(); i++){
            arrNum[i] = strpage.charAt(i) -'0';
        }

        int pagesum= Arrays.stream(arrNum).sum();
        int pagemulti=Arrays.stream(arrNum).reduce(1,(a,b)->(a*b));

        return  Math.max(pagesum,pagemulti);
    }
}



