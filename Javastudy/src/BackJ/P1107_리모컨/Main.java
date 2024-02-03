package BackJ.P1107_리모컨;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<String> brokenButtons = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chanel = sc.nextInt();
        int broken = sc.nextInt();
        sc.nextLine();
        if(broken!=0)  brokenButtons = Arrays.stream(sc.nextLine().split(" ", broken)).collect(Collectors.toList());
        int result = Math.abs(chanel-100); // 100에서부터 임시
        String[] trial;

        for(int i=chanel; i>=0; i--){
            trial = String.valueOf(i).split("");
            if(isAvailable(trial)) result = Math.min(result,trial.length+chanel-i);
        }

        for(int i=chanel+1; i<chanel+result; i++){
            trial = String.valueOf(i).split("");
            if(isAvailable(trial)) result = Math.min(result,trial.length+i-chanel);
        }

        System.out.println(result);
    }

    private static boolean isAvailable(String[] t){
        for(String n : t){
            if(brokenButtons.contains(n)) return false;
        }
        return true;
    }
}
