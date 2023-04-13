package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1~N 학생들에 대하여 
 * 두 학생끼리 키를 비교한 결과의 일부가 주어져 있다.
 * N명의 학생들의 키는 모두 다름
 * 
 *  자신의 키가 몇 번째인지 알 수 있다
 * -> 
 * 자신보다 작은 사람 + 자신보다 큰 사람 == 전체 - 1
 * */

public class Main_2458_키순서 {
	static int N, M;
	
	static int bfs(ArrayList<Integer>[] graph, int i) {
		int count = 0;
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N+1];
		
		v[i] = true;
		q.add(i);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph[now]) {
				if(v[next]) continue;
				v[next] = true;
				q.add(next);
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] small2big = new ArrayList[N+1]; // 0비우고 사용
		ArrayList<Integer>[] big2small = new ArrayList[N+1]; // 0비우고 사용
		for (int i = 0; i < small2big.length; i++) {
			small2big[i] = new ArrayList<>();
			big2small[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			small2big[start].add(finish);
			big2small[finish].add(start);
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int small = bfs(big2small, i);
			int big = bfs(small2big, i);
			if(small+big == N-1) result++;
		}
		
		System.out.println(result);
	}

}
