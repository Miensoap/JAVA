package BackJ.P1260_DFSBFS;

import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> A ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int start = scanner.nextInt();

        A= new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            int S = scanner.nextInt();
            int E = scanner.nextInt();
            A.get(S).add(E);
            A.get(E).add(S);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(A.get(i));
        }

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
        System.out.println();

    }

    private static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node+" ");
            for(int i : A.get(now_Node)){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void DFS(int Node){
        System.out.print(Node+" ");
        visited[Node] = true;
        for(int i : A.get(Node)){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
