package solving.baekjoon.n1987;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 세로 R , 가로 C칸으로 된 표 모양 보드
 * 칸에 대문자 알파벳 적혀 있고
 * 1, 1에 말이 있음
 * 
 * 말은 상하좌우 한칸씩 이동
 * 지금까지 나온 알파벳과 달라야 함
 * 
 * 최대 몇 칸 지날 수 있는지 
 * 
 * 1,1 포함해서
 * */

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R, C;
	static Character[][] map;
	static boolean[] visited;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int result;

//	static class Point {
//		int r, c, cnt;
//
//		public Point(int r, int c, int cnt) {
//			this.r = r;
//			this.c = c;
//			this.cnt = cnt;
//		}
//	}


	// 같은 레벨의 것들을 한번에 접근하기 때문에 visited 배열 제대로 관리 안됨
//	static void bfs() {
//		dict = new boolean[26];
//		result = 0;
//		Queue<Point> q = new LinkedList<>();
//
//		q.offer(new Point(0, 0, 1));
//
//		while (!q.isEmpty()) {
//			Point p = q.poll();
//			dict[asciiIdx(map[p.r][p.c])] = true;
//
//			System.out.println(p.cnt);
//			for(int d=0; d<4; d++) {
//				int nr = p.r + dr[d];
//				int nc = p.c + dc[d];
//
//				if(nr<0 || nc<0 || nr>=R || nc>=C || dict[asciiIdx(map[nr][nc])]) continue;
//				q.offer(new Point(nr, nc, p.cnt+1));
//				//System.out.println(nr + " " + nc);
//				dict[asciiIdx(map[nr][nc])] = true;
//			}
//
//			result = Math.max(result, p.cnt);
//		}
//	}


	static void dfs(int r, int c, int count) {
		if(visited[map[r][c]-'A']) {
			result = Math.max(result, count);
			return;
		}

		else {
			visited[map[r][c]-'A'] = true;
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
				dfs(nr, nc, count+1);
			}
			visited[map[r][c]-'A'] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new Character[R][C];
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		visited = new boolean[26];
		dfs(0,0, 0);
		System.out.println(result);

	}


}
