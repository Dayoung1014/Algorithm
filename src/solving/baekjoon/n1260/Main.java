package solving.baekjoon.n1260;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 그래프 DFS BFS 탐색
 * 정점 번호 1~N
 * 방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것을 먼저 방문
 * 
 * */


class Main {
	static class Node {
		int vertex;
		Node link;
		public Node(int vertex, Node node) {
			super();
			this.vertex = vertex;
			this.link = node;
		}
	}
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, V;
    static Node[] graph;
    
	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken());  //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점 번호
		
		graph = new Node[N+1]; //간선이 연결하는 두 정점의 번호들
		int from, to;
		
		for(int m=0; m<M; m++) { // 간선
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			graph[from] = new Node(to, graph[from]);
			graph[to] = new Node(to, graph[to]);
		}
		
		System.out.println();
		
		bfs(V);
	}
	
	static void dfs() {
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+1]; // 정점 개수 만큼
		
		v[start] = true;
		q.offer(start);
		
		int cur = 0;
		while(!q.isEmpty()) {
			cur = q.poll();
			//System.out.print(cur + " ");
			
			for(Node tmp=graph[cur]; tmp!=null; tmp=tmp.link) {
				if(!v[tmp.vertex]) {
					v[tmp.vertex] = true;
					if(!q.isEmpty()) { // 비어있지 않다면 정렬 맞춰주기
						  
					}
					else { 
						q.offer(tmp.vertex);
					}
				}
				System.out.println(q);
			}
		}
		
	}
	
}

