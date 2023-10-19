package BackJ.P2668_DFS;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static List<Integer> first, second;
    static boolean[] visited;
    static Set<Integer> result = new HashSet<>();
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        first = new ArrayList<>();
        second = new ArrayList<>();
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            first.add(i);
            second.add(sc.nextInt()-1);
        }

        for(int i=0; i<N; i++) {
            if (first.get(i).equals(second.get(i))){
                result.add(first.get(i));
            }
            visited = new boolean[N];
            start = i;
            dfs(i);
        }

        System.out.println(result.size());
        List<Integer> list  = result.stream().sorted().collect(Collectors.toList());
        for (int num : list){
            System.out.println(num+1);
        }


    }

    static boolean dfs(int idx) {
        if (!visited[idx]) {
            if (!visited[second.get(idx)]) {
                visited[idx] = true;
                if (dfs(second.get(idx))) {
                    result.add(first.get(idx));
                }
            }
            else if (second.get(idx) == start)
                return true;
        }
        return false;
    }
}
