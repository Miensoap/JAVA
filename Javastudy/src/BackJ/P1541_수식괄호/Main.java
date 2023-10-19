package BackJ.P1541_수식괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        int result = 0;
        try {
            String plus = order.split("-")[0];
            String minus = order.substring(order.indexOf("-"));
            StringTokenizer plusNums = new StringTokenizer(plus, "+");
            StringTokenizer minusNums = new StringTokenizer(minus, "+-");


            while (plusNums.hasMoreTokens()) result += Integer.parseInt(plusNums.nextToken());
            while (minusNums.hasMoreTokens()) result -= Integer.parseInt(minusNums.nextToken());
        }catch (Exception e){
            StringTokenizer plusNums = new StringTokenizer(order, "+");
            while (plusNums.hasMoreTokens()) result += Integer.parseInt(plusNums.nextToken());

        }
        finally {
            System.out.println(result);
        }




    }
}
