import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int V, E;
	
	static class Edge implements Comparable<Edge>{
		int s, e, c;

		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", c=" + c + "]";
		}
		
	}
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> edges = new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges.add(new Edge(A, B, C));
		}
		
		parents = new int[V+1];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
        
		Collections.sort(edges);
		long sum= 0; int cnt=0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if(find(edge.s) != find(edge.e)){
				union(edge.s, edge.e);
				cnt++;
				sum+=edge.c;
				if(cnt==V-1) break;
			}

		}
		System.out.println(sum);
		
	}

	private static int find(int s) {
		if(parents[s] == s) return s;
		else return parents[s] = find(parents[s]);
	}
	
	private static void union(int s, int e) {
		int ps = find(s);
		int pe = find(e);
		if(ps != pe) {
			parents[ps] = pe;
		}
		
	}



}