package solving.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Solution_3124_최소스패닝트리_PRIM_PQ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E;
	
	static class Vertex implements Comparable<Vertex> {
		int e, c;

		public Vertex(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Vertex o) { 
			return Integer.compare(this.c, o.c);
		}
	}
	
	static ArrayList<Vertex>[] adj;
	static int[] dist;
	static boolean[] v;
	
	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[V+1];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				adj[A].add(new Vertex(B, C));
				adj[B].add(new Vertex(A, C));
			}
			

			dist = new int[V+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			v = new boolean[V+1];
			dist[1]=0; //첫 방문을 0이 아닌 1부터 (문제에서 0 없음)
			
			PriorityQueue<Vertex> Q = new PriorityQueue<>();
			Q.add(new Vertex(1,0));
			long sum=0;
			
			while(!Q.isEmpty()) {
				Vertex p = Q.poll(); 
				if(!v[p.e]) {
					v[p.e] = true;
					sum += p.c;
					for (Vertex next : adj[p.e]) {
						if(!v[next.e] && next.c <dist[next.e]) {
							dist[next.e] = next.c;
							Q.add(next);
						}
					}
				}
			}
		
			System.out.println("#"+test_case+" "+sum);
			
		
		}
	}



}