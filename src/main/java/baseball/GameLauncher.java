package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameLauncher {
    static boolean continueGame = true;
    static void setContinueGameFalse(){
            continueGame = false;
    }
    public void run(){
        while (continueGame) {
            playGame();
            while (reStart())
                playGame();
        }
    }
    public void playGame() throws IllegalArgumentException{
        List <Integer> answer = rdAnswer();
        try {
            System.out.println("숫자 야구 게임을 시작합니다.");
            if (!score(input(),answer)){
                score(input(),answer);
            }
        }catch (IllegalArgumentException e){
            throw e;
        }
    }

    private boolean reStart()throws IllegalArgumentException{
	    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart= readLine();
        if(restart.equals("1")){
            return true;
        }else if(restart.equals("2")){
            return false;
        } else{
            throw new IllegalArgumentException(
                "잘못된 값이 입력되었습니다."
            );
	}
}
    public static List<Integer> rdAnswer(){
        List<Integer> answer = new ArrayList<>(Arrays.asList(1,3,9));
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
             }
        }
        return answer;
    }

    public static List<Integer> input() throws IllegalArgumentException{
        String number = readLine();
        List<Integer> numberList = new ArrayList<>();
        for (int i=0; i<number.length(); i++){
            numberList.add(Integer.parseInt(number.charAt(i)+""));
        }
        if (checkinput(numberList))
            return numberList;
        else
            throw new IllegalArgumentException(
                    "잘못된 값이 입력되었습니다."
            );
    }
    public static boolean checkinput(List<Integer> numberList){
        // List<Integer> to int
        if (numberList.size()!=3)
            return false;
        for (Integer integer : numberList) {
            if (Collections.frequency(numberList, integer) > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean score (List<Integer> number, List<Integer> answer){
        List<Character> scoreCard = new ArrayList<>();
        for(int i= 0; i<number.size(); i++){
            if (number.get(i)==answer.get(i)){
                scoreCard.add('S');
            }
            else if (answer.contains(number.get(i)))
                scoreCard.add('B');
            else{
                scoreCard.add('X');
            }
        }

        int countS = Collections.frequency(scoreCard, 'S');
        int countB = Collections.frequency(scoreCard, 'B');
        if (countS==number.size()){
            System.out.println("정답!");
            setContinueGameFalse();
            return true;
        }
        else{
            hint(countS,countB);
            return false;}
    }

    private static void hint(int countS, int countB) {
        if (countS>0 && countB>0)
            System.out.println(countB+"볼 "+countS+"스트라이크");
        else if (countS>0) {
            System.out.println(countS+"스트라이크");
        }
        else if (countB>0){
            System.out.println(countB+"볼");
        }
        else
            System.out.println("낫싱");
    }
}