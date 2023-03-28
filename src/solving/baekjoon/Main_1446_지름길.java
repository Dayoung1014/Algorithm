package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * D길이의 고속도로의 지름길은 일방통행, 역주행 불가(단방향 그래프)
 * 지름길이 없으면 그냥 고속도로로 가야해서 해당 거리만큼 가야함
 * 운전해야하는 최솟값 구하기
 * */

public class Main_1446_지름길 {

	static class Node implements Comparable<Node>{
		int e, c;
	
		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.c, o.c);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //1~12
		int D = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] graph = new ArrayList[10001]; //0비우기 위해
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); //시작 위치 
			int end = Integer.parseInt(st.nextToken()); //종료 위치
			int cost = Integer.parseInt(st.nextToken()); //길이
			
			graph[start].add(new Node(end, cost));
		}
		
		int[] dist = new int[10001]; //가면서 최솟값 갱신	
		boolean[] v = new boolean[10001];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		PriorityQueue<Node> Q = new PriorityQueue<>();
		Q.add(new Node(0, 0));

		while(!Q.isEmpty()) {
			Node p = Q.poll();
			int minIdx = p.e; 
			
			v[minIdx] = true;
			
			for(Node next : graph[minIdx]) {
				if(!v[next.e]&&dist[next.e]>dist[minIdx]+next.c) {
					dist[next.e]=dist[minIdx]+next.c;
					Q.add(new Node(next.e,dist[next.e]));
				}
			}	
		}
		
		System.out.println(Arrays.toString(dist));
		
		// 다익스트라 돌면서 지름길 최솟값만 dist에 저장
		// dist 도착점의 값이 있다면 그 값이 최소값
		// 다른 지점의 값+ 그 지점과의 거리차
		
		
	}

}
