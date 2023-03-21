package solving.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


class Solution_7465_창용마을무리의개수  {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static LinkedList<Integer>[] adj; // 친구 관계 양방향 연결 결리스트
	static boolean[] v; //방문 여부
	static int result;
	
	public static void main(String args[]) throws Exception {

		int T=Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //마을에 사는 사람의 수
			int M = Integer.parseInt(st.nextToken()); //서로를 알고 있는 사람의 관계 수

			adj = new LinkedList[N+1];
			for(int n=0; n<N+1; n++) {
				adj[n] = new LinkedList<Integer>();
			}

			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adj[from].add(to);
				adj[to].add(from);
			}


			v = new boolean[N+1];
			result = 0;

			for(int n=1; n<N+1; n++) { //1부터 N까지
				if(v[n]) continue;
				dfs(n);
				result++;
			}

			System.out.println("#"+test_case+" "+result);
		}
	}

	private static void dfs(int i) {
		v[i] = true;

		for(int a : adj[i]) {
			if(!v[a]) {
				dfs(a);
			}
		}
	}
}