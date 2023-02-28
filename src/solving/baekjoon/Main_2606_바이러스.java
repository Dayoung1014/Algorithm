package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 한컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 연결되어 있는 모든 컴퓨터다 다 걸림
 * 
 * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
 * */

public class Main_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static LinkedList<Integer>[] adj;
	static boolean[] v;
	static int count;
	private static void dfs(int n) {
		v[n] = true;

		for(int a:adj[n]) {
			if(!v[a]) {
				dfs(a);
				count++;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		adj = new LinkedList[N+1];
		v = new boolean[N+1];
		
		for(int n=0; n<N+1; n++) {
			adj[n] = new LinkedList<Integer>();
		}
		
		int pair = Integer.parseInt(br.readLine());
		for(int p=0; p<pair; p++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from].add(to);
			adj[to].add(from);
		}
		
//		for(int n=0; n<N+1; n++) {
//			System.out.println(adj[n]);
//		}
//		
		
		count = 0;
		dfs(1);
		System.out.println(count);

	}

}
