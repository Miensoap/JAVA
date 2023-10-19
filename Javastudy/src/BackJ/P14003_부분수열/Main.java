package BackJ.P14003_부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX_N = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] D = new int[MAX_N];
        D[0] = arr[0];
        int[] result = new int[arr.length];
        result[0] = 0;
        int size = 1;
        for (int i = 1; i < N; i++) {
            int index = Arrays.binarySearch(D, 0, size, arr[i]);

            index = index >= 0 ? index : Math.abs(index) - 1;
            D[index] = arr[i];
            if (index == size) {
                size++;
            }
            result[i] = index;
        }
        String[] str = new String[size];
        System.out.println(size);
        size--;
        for(int j = arr.length-1; j >= 0; j--) {
            if (size == -1) break;
            if (result[j] == size) {
                str[size] = String.valueOf(arr[j]);
                size--;
            }
        }
        System.out.println(String.join(" ", str));
    }
}
