package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 
 * 방향키 북동남서
 * 로봇청소기와 방의 상태가 주어졌을 때 청소하는 영역의 개수를 구해라
 * 
 * 방 
 * - N*M (0, 0 ~ N-1, M-1)
 * - 벽 or 빈칸
 * - 청소기는 4방 이동 가능
 * 
 * 로봇청소기 
 * 1. 현재 칸이 청소되지 않은 경우 현재 칸 청소
 * 2. 현재 칸의 4방 중 청소되지 않은 빈 칸이 없는 경우
 * 		-> 방향 유지한채 후진 후 1로 돌아감
 * 		-> 후진 하려 했는데 벽인 경우 작동 멈춤
 * 3. 현재 칸의 4방 중 청소되지 않은 빈칸이 있는 경우
 * 		-> 반시계 방향으로 회전 
 * 		-> 바라보는 방향 기준 앞쪽이 청소되지 않은 경우 한 칸 전진
 * 		-> 다시 반시계 회전... 위 반복
 * 
 * 작동 멈출 때 까지 몇 칸 청소할수 있는지 구해라
 * */


public class Main_14503_로봇청소기 {
	static int N, M;
	static int[][] map; // 1은 벽 / 0은 빈칸
	static int[] start = new int[2];
	
	// d : 북 동 남 서
	static int d;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static int clean = 0; //작동 멈출 때 까지 청소하는 칸의 개수
	
	
	// 벽은 방문 X
	// 빈칸 청소 유무 -> 방문 배열로 해결
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		
		v[start[0]][start[1]] = true; //방문하며 청소했다고 침
		clean++;
		q.add(new Point(start[0],start[1]));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			boolean exist = false; //청소할 방이 존재하는가 
			// 4방 청소 확인
			
			
			// 4방을 다 청소할 수 없다면
			if(!exist) { 
				// -> 방향 유지한채 후진 후 1로 돌아감
				// -> 후진 하려 했는데 벽인 경우 작동 멈춤
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		 st = new StringTokenizer(br.readLine());
		 start[0] = Integer.parseInt(st.nextToken()); //청소기 시작 r
		 start[1] = Integer.parseInt(st.nextToken()); //청소기 시작 c
		 d = Integer.parseInt(st.nextToken()); //청소기 시작 방향
		 
		 bfs();
		 System.out.println(clean);
	}
}
