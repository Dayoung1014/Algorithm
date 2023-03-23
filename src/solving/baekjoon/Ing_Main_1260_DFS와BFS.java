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




public class Ing_Main_1260_DFS와BFS {
	
//	static class Node   {
//		int vertex;
//		Node link;
//		
//		public Node(int vertex, Node node) {
//			super();
//			this.vertex = vertex;
//			this.link = node;
//		}
//	}

	
    static int N, M, V;
    static PriorityQueue<Integer>[] graph;
    
	public static void main(String args[]) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1; //정점의 개수 (0비우고)
		M = Integer.parseInt(st.nextToken());  //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점 번호
		
		graph = new PriorityQueue[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new PriorityQueue();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken()); 
			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 0; i < N; i++) {
			System.out.println(graph[i].toString());
		}
		
		visited = new boolean[N];
	}
	 
	// 깊이 우선 탐색
	static boolean[] visited;
	static void dfs(int now) {
		
	}
	
//	
//	static void bfs(int start) {
//		Queue<Integer> q = new ArrayDeque<>();
//		boolean[] v = new boolean[N+1]; // 정점 개수 만큼
//		
//		v[start] = true;
//		q.offer(start);
//		
//		int cur = 0;
//		while(!q.isEmpty()) {
//			cur = q.poll();
//			System.out.print(cur + " ");
//			
//			for(Node tmp=graph[cur]; tmp!=null; tmp=tmp.link) {
//				if(!v[tmp.vertex]) {
//					v[tmp.vertex] = true;
//					q.offer(tmp.vertex);
//				}
//				System.out.println(q);
//			}
//		}
//		
//	}


}

