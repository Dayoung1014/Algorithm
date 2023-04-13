package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1×N 크기의 미로
 * 
 * 칸에 적힌 수 이하만큼 오른쪽으로 떨어진 칸으로 한번에 이동 가능
 * 지금 3 적혀 있으면 오른쪽으로 +1 +2 +3 가능
 * 
 * 가장 왼쪽 -> 가장 오른쪽 가려 함
 * 최소 몇 번 점프 해야 하는가
 * 갈 수 없느 경우 -1
 * */

public class Main_11060_점프점프 {
	static int N;
	static int[] map;
	static int res = Integer.MAX_VALUE;
	
	static class Pos {
		int idx;
		int count;
		public Pos(int idx, int count) {
			super();
			this.idx = idx;
			this.count = count;
		}
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>(); //인덱스 넣어주기
		boolean[] v = new boolean[N];
		v[0] = true;
		q.add(new Pos(0, 0));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.idx == N-1) {
				res = Math.min(res, p.count);
				continue;
			}
			int val = map[p.idx]; //점프 할 수 있는 값
			
			for (int i = 1; i <= val; i++) {
				int next = p.idx + i;
				if(next >= N || v[next]) continue;
				
				v[next] = true;
				q.add(new Pos(next, p.count+1));
			}
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 N = Integer.parseInt(br.readLine());
		 map = new int[N];
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 for (int i = 0; i < N; i++) {
			 map[i] = Integer.parseInt(st.nextToken());
		}
		 
		 bfs();
		 
		 if(res==Integer.MAX_VALUE) System.out.println(-1);
		 else System.out.println(res);
	}
}
