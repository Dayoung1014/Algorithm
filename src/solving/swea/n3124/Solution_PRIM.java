package solving.swea.n3124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_PRIM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E;
	
	static class Vertex {
		int e, c;

		public Vertex(int e, int c) {
			super();
			this.e = e;
			this.c = c;
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
			

			for (int cnt = 0; cnt < V-1; cnt++) {
				int minIdx = 0;
				int minDist = Integer.MAX_VALUE;
				for (int i = 1; i < V+1; i++) {
					if(!v[i]&&minDist>dist[i]) {
						minIdx = i;
						minDist = dist[i];
					}
				}
				v[minIdx]=true;

				for(Vertex next : adj[minIdx]) {
					if(!v[next.e] && next.c < dist[next.e]) {
						dist[next.e] = next.c;
					}
				}
			}
			
			long sum= 0; 
			for (int i = 1; i < dist.length; i++) {
				sum+=dist[i];
			}
			System.out.println("#"+test_case+" "+sum);
			
		
		}
	}



}