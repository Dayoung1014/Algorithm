package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 방향 없는 그래프(양방향)가 주어졌을 때 
 * 연결 요소의 개수를 구해라
 * */

public class Main_11724_연결요소의개수 {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		visited[n] = true;
		q.add(n);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph[now]) {
				if(visited[next]) continue;
				visited[next] = true;
				q.add(next);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1; //0부터 시작하도록
			int v = Integer.parseInt(st.nextToken())-1;
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int cnt=0;
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			cnt++;
			bfs(i);	
		}
		System.out.println(cnt);
		
	}
}
