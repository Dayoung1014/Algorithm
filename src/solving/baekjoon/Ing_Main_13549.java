package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import java.util.StringTokenizer;


/*
 * BFS는 가중치 (cost)가 같을 때 최단거리 알고리즘
 * 가충기가 다를때는 다익스트라 알고리즘, dfs로 풀어보기
 * */
public class Ing_Main_13549 {
	static int start, end;
	static int res;
	
	static class Point implements Comparable<Point> {
		int now, time;

		public Point(int now, int time) {
			super();
			this.now = now;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.now, o.now);
		}
	}
	
	
//	static void move() {
//		PriorityQueue<Point> q = new PriorityQueue();
//		
//		
//		visited[start] = true;
//		q.add(new Point(start, 0));
//		
//		while(!q.isEmpty()) {
//			Point p = q.poll();
//			
//			if(p.now==end) {
//				if(res > p.time) res = p.time;
//			}
//			
//			int[] next = {p.now*2, p.now-1, p.now+1};
//			for(int i=0; i<3; i++) {
//				if(next[i]<0 || next[i]>100000 || visited[next[i]]) continue; //인덱스 벗어나거나 이미 방문한 경우
//				visited[next[i]] = true; //방문 처리
//				if(i==0) { //순간이동은 0초
//					q.add(new Point(next[i], p.time));
//				}
//				else { //앞뒤 이동은 1초
//					q.add(new Point(next[i], p.time+1));
//				}
//			}		
//		}
//	}

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
	
		
		boolean[] visited = new boolean[100001];
		int[] dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		ArrayList<Point>[] adj = new ArrayList[100001];
		for (int i = 0; i < 100001; i++) {
			adj[i]=new ArrayList();
		}
		
		
		PriorityQueue<Point> Q = new PriorityQueue();
		dist[0]=0;
		Q.add(new Point(start, 0));
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			int minIdx = p.now;
			
			visited[minIdx]=true;
			
			for (Point next : adj[minIdx]) {
				if(!visited[next.now]&&dist[next.now]>dist[minIdx]+next.time) {
					dist[next.now]=dist[minIdx]+next.time;
					Q.add(new Point(next.now,dist[next.now]));
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}

}
