import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M;
	static int N; 
	static int[][] map;
	static boolean finish;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println(Arrays.toString(new int[10]));
		int T = sc.nextInt(); // 테스트 케이스 개수
		for(int t=0; t<T; t++) {
			M = sc.nextInt(); // 밭의 가로 길이
			N = sc.nextInt(); // 밭의 세로 길이
			int K = sc.nextInt(); // 심어진 배추 위치 개수
			
			map = new int[N][M];
			for(int i=0; i<K; i++) {
				int x = sc.nextInt(); //가로 위치
				int y = sc.nextInt(); //세로 위치
				map[y][x] = 1;
			}
			
			int sum=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						sum++;
						bfs(i, j);
					}
				}
			}
			System.out.println(sum);
		}

	}
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		v[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}

			}
		}
	}

}
