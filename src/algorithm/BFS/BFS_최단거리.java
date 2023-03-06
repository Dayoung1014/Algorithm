package algorithm.BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 * 0, 0에서 finishN, finishM 까지 이동하는 최단거리를 구하세요.
 *  . 길이여서 이동 가능
 *  - 은 벽이여서 이동 불가
 * */

public class BFS_최단거리 {
	static char[][] map;
	static int N = 3;
	static int M = 4;
	static int finishN = 2;
	static int finishM = 0;
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static class Point{
		int r,c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c  + ", cnt=" + cnt + "]";
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner("...-\n"
											 +"--.-\n"
											 +"...-\n");
		
		map = new char[3][4];
		
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		bfs();
	}

	
	private static void bfs() {
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[3][4];
		
		v[0][0]=true;
		Q.offer(new Point(0,0, 0));
		
		breakOut:
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r==finishN &&p.c==finishM) {
				System.out.println(p.toString());
				break breakOut;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(nr<0 || nc<0 || nr>=3 || nc>=4) continue;
				if(v[nr][nc] || map[nr][nc]=='-') continue;

				v[nr][nc]=true;
				Q.add(new Point(nr,nc, p.cnt+1));
			}
		
	}
	}
}
