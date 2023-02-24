package solving.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


/*
 * 사람 0~N-1 번호 매겨져 있음
 * 일부 사람들이 친구임
 * AB BC CD DE 이렇게 친구인 사이가 존재하는가 안하는가 알고싶음
 * 
 * 
 * 
 * 
 * */

public class Main_13023_ABCDE {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] relation;
    static boolean result = false;
    static ArrayList<Integer> friends = new ArrayList<>();
    static LinkedList<Integer>[] adj;
    
	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken()); //사람의 수
		M= Integer.parseInt(st.nextToken()); // 친구 관계의 수
		relation = new int[M][2];
		
		adj = new LinkedList[N];
		for(int n=0; n<N; n++) {
			adj[n] = new LinkedList<>();
		}

		int from, to;
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			adj[from].add(to);
			adj[to].add(from);
		}
	
		
		for(int n=0; n<N; n++) {
			dfs(n);
		}
		
		if(result) System.out.println(1);
		else System.out.println(0);
		

	}
	
	
	//재귀 돌면서 depth+1 해줌
	//depth == 5 완성
	private static void dfs(int i) { 
		
	}


}
