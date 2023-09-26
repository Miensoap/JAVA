package DataSt.InputEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        String str = "1 2 3 4";
        arr = new int[0];
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(str," ",false);

        while (st.hasMoreTokens()){
            String stt = st.nextToken();

        }
    }
}
