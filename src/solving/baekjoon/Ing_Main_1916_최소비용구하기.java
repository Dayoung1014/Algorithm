package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 노드 : 도시 
 * 엣지 : 버스
 * */

public class Ing_Main_1916_최소비용구하기 {
	
	static class Node {
		int e, c;

		public Node(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", c=" + c + "]";
		}
		
	}
	static int N, M;
	static long[] dist;
	static boolean[] v;
	static ArrayList<Node>[] adj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new long[N+1];
		
		v = new boolean[N+1];
		adj = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[s].add(new Node(e, c));
		}

		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		
		for(int i=1; i<N+1; i++) {
			int minIdx = -1; 
			long minD = Long.MAX_VALUE;
			
			for(int j=1; j<N+1; j++) {
				if(minD > dist[j] && !v[j]) {
					minD = dist[j];
					minIdx = j;
				}
			}
			
			if(minIdx == -1) break;
			v[minIdx] = true;
			
			
			for(Node next : adj[minIdx]) {
				if(!v[next.e] && dist[next.e] > dist[minIdx]+next.c);
				dist[next.e] = dist[minIdx] + next.c;
			}
			
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(end + " " +start);
		System.out.println(dist[end]+" "+dist[start+1]);
		
		System.out.println(dist[end] - dist[start+1]);
		
	}

}
