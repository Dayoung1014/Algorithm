package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 상근이네 집 -> 락페
 * 맥주 한박스(20병) 들고 출발
 * 50m에 한 병씩 마셔야 함(50m 가려면 그 전에 맥주 한 병 마셔야 함)
 * 
 * 가다가 편의점 들릴 수 있음
 * - 빈 병 버리고 새 맥주 병 살 수 있음
 * - 단 들고있는 병수가 20병을 넘을 수 없다.
 * 
 * 좌표 사이 거리 : x의 차 + y의 차
 * 
 * 
 * -----
 * 편의점 몇 개 들리든 상관 없음
 * dfs로 모든 경로 완탐하면서 하나라도 성공하면 happy
 * 다 돌았는데 못한다면 sad
 * 
 * 현재 위치에서 가까운 순으로 가서 맥주 채우면 됨
 * */

public class Main_9205_맥주마시면서걸어가기 {
	
	static class Point {
		int x, y;
		int beer;
		
		public Point(int x, int y, int beer) {
			super();
			this.x = x;
			this.y = y;
			this.beer = beer;
		}
	}
	
	static int n; //편의점 개수
	static int[][] store;
	static boolean finish;

	static boolean[] visited;

	static void bfs() { 
		Queue<Point> q = new LinkedList<>();
		visited[0] = true;
		q.add(new Point(store[0][0], store[0][1], 20));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			//System.out.println("현재 위치 : "+p.x+" "+p.y);
			if(check(p)) { // 현재 위치에서 바로 방문 가능하다면
				finish=true;
				return;
			}
			
			for(int i=1; i<=n; i++) { // 편의점 확인
				if(visited[i]) continue; //이미 방문한 편의점은 무시
				int next_beer = drink(p, store[i][0], store[i][1]); //다음 편의점 방문했을 때 남는 맥주 수 계산
				if(next_beer < 0) continue; //맥주가 부족하다면 해당 편의점은 방문 X
				
				// 가능하다면 해당 편의점 방문, 큐 추가
				visited[i] = true;
				q.add(new Point(store[i][0], store[i][1], 20));

				if(visited[n+1]) {
					finish=true;
					return;
				}
			}
		}
	}

	static int drink(Point now, int nextX, int nextY) { // 현재에서 다음 편의점 방문 시 까지 남는 맥주 수 계산
		int dist = Math.abs(nextX - now.x) + Math.abs(nextY - now.y) ;
		return now.beer - (int)Math.ceil(dist/50);
	}

	static boolean check(Point now) { //현재 위치에서 락페로 도착 가능한지
		int dist = Math.abs(store[n+1][0] - now.x) + Math.abs(store[n+1][1] - now.y) ;
		//System.out.println(dist + " " + dist/50.0 + " "+Math.ceil(dist/50.0));
		if(Math.ceil(dist/50.0) <= now.beer) return true;
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			n = Integer.parseInt(br.readLine()); //편의점 개수
			
			store = new int[n+2][2]; // 집 - 편의점들 - 락페
			visited = new boolean[n+2];

			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken()); // x좌표
				store[i][1] = Integer.parseInt(st.nextToken()); // y좌표
			}
		
	
			finish = false;
			bfs();
			
			if(finish) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
	}

}
