package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 현서 -> 찬홍이에게 가야함
 * 가는 길에 소 만나면 여물 줘야하는데 최소한의 소를 만나고 싶음
 * 
 * 농부 현서는 헛간 1에 있고 농부 찬홍이는 헛간 N
 * 
 * 다익스트라는 사이클 불가
 * 
 * */
public class Main_5972_택배배송 {
	static int N, M;
	static ArrayList<Node>[] graph;
	
	static class Node implements Comparable<Node>{
		int e, c;

		public Node(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) { 
			return this.c-o.c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cow = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, cow));
			graph[e].add(new Node(s, cow));
		}
		
		boolean[] visited = new boolean[N + 1]; 
		int[] dist = new int[N+1];
		Arrays.fill(dist, 50000001);
		
		dist[1] = 0; 
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(1,0));
		while(!q.isEmpty()) {
			Node now = q.poll(); 
			
			if(visited[now.e]) continue;
			visited[now.e] = true;
			
			for(Node next : graph[now.e]) { 
				if(dist[next.e] > dist[now.e]+next.c) {
					dist[next.e] = dist[now.e]+next.c;
					q.add(new Node(next.e, dist[next.e]));
				} 
			}  	 
		}
		 
		System.out.println(dist[N]);
		 
	}
}
