package CodeTree.Ch4.완탐.행복한수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, M;
    static List<List<Integer>> arr;
    static List<List<Integer>> sequences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>(N);
        sequences = new ArrayList<>(N);

        // 가능한 모든 수열을 sequences 에 저장
        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            arr.add(new ArrayList<Integer>());
            for (int j = 0; j < N; j++) {
                arr.get(i).add(Integer.parseInt(nums[j]));
            }
            sequences.add(arr.get(i));
        }
        for (int i = 0; i < N; i++) {
            List<Integer> sequence = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                sequence.add((arr.get(j).get(i)));
            }
            sequences.add(sequence);
        }

        int cnt = 0;
        for (List<Integer> seq : sequences) {
//            System.out.println(seq);
            if (isHappy(seq)) {
                cnt++;
//                System.out.println(seq);
            }
        }
        System.out.println(cnt);
    }

    static boolean isHappy(List<Integer> seq) {
        int cnt = 0;
        for (int i = 1; i < seq.size(); i++) {
            if (seq.get(i).equals(seq.get(i - 1))) {
                cnt++;
                if (cnt >= M-1) return true;
            }
            else cnt = 0;
        }
        return cnt >= M - 1;
    }
}
