package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// visited[현재 위치] = 바로 직전의 위치

public class Main_13913 {
	static int N, K, res;
	static ArrayList<Integer> resList = new ArrayList();
	static class Pos {
		int now;
		int time;
		public Pos(int now, int time) {
			super();
			this.now = now;
			this.time = time;
		}
	}
	
	static void move() {
		Queue<Pos> q = new LinkedList();
		int[] v = new int[100001];
		
		q.add(new Pos(N, 0));
		v[N] = N;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(v[K] != 0) {
				System.out.println(p.time);
				Stack<Integer> stack = new Stack<Integer>();
				int cur = K;
				stack.add(K);
				while(cur!=N) {
					stack.add(v[cur]);
					cur = v[cur];
				}
				
				while(!stack.isEmpty()) {
					System.out.print(stack.pop()+" ");
				}
				return;
			}
			
			int[] next = new int[] {p.now+1, p.now-1, p.now*2};
			
			for (int i = 0; i < next.length; i++) {
				int n = next[i];
				
				//동생보다 많이 간 경우 -1만 가능
				if(n<0 || n>100000 || v[n]!=0) continue;
				if(p.now>K && i!=1) continue;
				v[n] = p.now;
				q.add(new Pos(n, p.time+1));
			}
			
			
		
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		res = Integer.MAX_VALUE;
		
		move();
		
		
	}

}
