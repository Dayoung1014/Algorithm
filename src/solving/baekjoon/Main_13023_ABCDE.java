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
 * 인접 양방향 리스트로 친구 관계 생성
 * 시작하는 사람을 0~N-1 로 하는 dfs 탐색 각각 진행
 * 깊이 4 이상 시 친구 관계 존재하는 것
 * */

public class Main_13023_ABCDE {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static boolean result;

    static LinkedList<Integer>[] adj; // 친구 관계 양방향 연결 결리스트
	static boolean[] v; //방문 여부
    
	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken()); //사람의 수
		M= Integer.parseInt(st.nextToken()); // 친구 관계의 수
		
		adj = new LinkedList[N];
		for(int n=0; n<N; n++) {
			adj[n] = new LinkedList<Integer>();
		}

		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj[from].add(to);
			adj[to].add(from);
		}


		v = new boolean[N];
		result = false;
		for(int n=0; n<N; n++) {
			v[n] = true;
			dfs(n, 0);
			v[n] = false;

			if(result) break;
		}
		
		if(result) System.out.println(1);
		else System.out.println(0);

	}


	
	//재귀 돌면서 depth+1 해줌
	//depth == 5 완성
	private static void dfs(int i, int count) {
		if(count >= 4) {
			result = true;
			return;
		}


		for(int a : adj[i]) {
			if(!v[a]) {

				dfs(i, count+1);
				v[a] = false;
			}
		}
	}


}
