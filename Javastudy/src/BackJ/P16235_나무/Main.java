package BackJ.P16235_나무;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static ArrayList<Tree> trees = new ArrayList<>();
    static Deque<Integer> dead_trees = new LinkedList<>();
    static int N,M,K;
    static int[][] ground;
    static int[][] nutrients;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M_K = reader.readLine().split(" ");
		N = Integer.parseInt(N_M_K[0]);
		M = Integer.parseInt(N_M_K[1]);
		K = Integer.parseInt(N_M_K[2]);
		nutrients = new int[N][N];
		ground = new int[N][N];

        for (int i=0; i<N; i++){
            String[] n = reader.readLine().split(" ");
            for(int j = 0; j<N; j++){
                ground[i][j] = 5;
                nutrients[i][j] = Integer.parseInt(n[j]);
            }
        }
        for (int i=0; i<M; i++){
            String[] t = reader.readLine().split(" ");
            trees.add(new Tree(t));
        }
        trees.sort((tree1, tree2) -> tree1.age - tree2.age);
        while (K!=0){
            spring();
            summer();
            fall();
            winter();
            K--;
        }
        System.out.println(trees.size());
    }

    public static void spring(){
        for (int i=0; i<trees.size(); i++) {
            Tree tree = trees.get(i);
            if (ground[tree.x][tree.y] < tree.age) {
                tree.live = false;
                dead_trees.add(i);
                continue;
            } else {
                ground[tree.x][tree.y] -= tree.age;
                tree.age += 1;
            }
        }
    }
    public static void summer(){
        while (!dead_trees.isEmpty()){
            int deadTreeIndex = dead_trees.pollLast();
            Tree deadTree = trees.get(deadTreeIndex);
            int nutrient = deadTree.age/2;
            ground[deadTree.x][deadTree.y]+=nutrient;
            deadTree.live=false;
        }
    }
    public static void fall(){
        ArrayList<Tree> newborn = new ArrayList<>();
        for (Tree tree : trees) {
            if (!tree.live) {
                continue;
            }
            if (tree.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = tree.x + dx[d];
                    int ny = tree.y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    newborn.add(new Tree(nx, ny, 1));
                }
            }
        }
        for (Tree tree : trees) {
			if (tree.live) {
				newborn.add(tree);
			}
		}
		trees = newborn;
    }
    public static void winter(){
        for(int i = 0; i<N; i++){
            for(int j=0; j<N; j++){
                ground[i][j] +=nutrients[i][j];
            }
        }
    }
}

class Tree {
    int x,y,age;
    boolean live = true;
     public Tree(int x,int y,int age){
        this.x=x;
        this.y =y;
        this.age =age;
    }
    public Tree(String[] tree){
        this.x=Integer.parseInt((tree[0])) -1 ;
        this.y = Integer.parseInt(tree[1]) - 1;
        this.age = Integer.parseInt(tree[2]);
    }
}