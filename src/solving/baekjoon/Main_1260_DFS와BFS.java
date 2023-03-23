package solving.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
 * 그래프 DFS BFS 탐색
 * 정점 번호 1~N
 * 방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것을 먼저 방문
 * 
 * */




public class Main_1260_DFS와BFS {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    
    static StringBuilder dfs_sb = new StringBuilder();
    static StringBuilder bfs_sb = new StringBuilder();
    
	// 깊이 우선 탐색
	static boolean[] visited;
	static void dfs(int now) {
		if(visited[now]) return;
	
		visited[now] = true;
		dfs_sb.append(now+" ");
		
		for (int i = 0; i < graph[now].size(); i++) {
			int next = graph[now].get(i);
			dfs(next);
		}
	}
	
	// 너비 우선 탐색
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+1]; // 정점 개수 만큼
		
		v[start] = true;
		q.offer(start);
		
		int cur = 0;
		while(!q.isEmpty()) {
			cur = q.poll();
			bfs_sb.append(cur+" ");
			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				if(v[next]) continue;
				v[next] = true;
				q.offer(next);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1; //정점의 개수 (0비우고)
		M = Integer.parseInt(st.nextToken());  //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점 번호
		
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken()); 
			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N];
		dfs(V);
		bfs(V);
		System.out.println(dfs_sb);
		System.out.println(bfs_sb);
	}
	 


}
