package solving.swea;

/*
* 맨홀 뚜껑을 통해 지하터널로 들어감
* 터널끼리 연결이 되어 있는 경우 이동 가능
* 시간당 1 이동 가능
*
* 탈주범이 있을 수 있는 위치의 개수 계산
*
* 터널이 있는 곳이라도 연결이 안되면 갈 수 없음
*
* 1 : 상하좌우
* 2 : 상하
* 3 : 좌우
* 4 : 상우
* 5 : 하우
* 6 : 하좌
* 7 : 상좌
*
*

*
* */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_1953_탈주범검거2  {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] v;
	static int result;

	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};

	static boolean[][] last;
	//static Queue<Point> q ;

	static void move(int r, int c, int d, int time) { //0 1 2 3 (상하좌우)
		int nr = r + dr[d];
		int nc = c + dc[d];

		if(nr>=0 && nc>=0 && nr<N && nc<M && !v[nr][nc]) {
			dfs(nr, nc, time+1);
			v[nr][nc] = false;
//			if(map[nr][nc]==0) {
//				if(!last[r][c]) {
//					last[r][c] = true;
//					result++;
//				}
//				return;
//			}
//			else {
//
//			}

		}

	}

	static void dfs(int r, int c, int time) {
		//System.out.println("r "+r+" / c "+c);
		int type = map[r][c];
		if(time == L || type ==0 ) {// || r==0 || r==N || c==0 || r==M
			System.out.println(r+ " / "+c);
			//System.out.println("끝");
//			if(!last[r][c]) {
//				last[r][c] = true;
//				result++;
//			}
			result++;
			return;
		}

		v[r][c] = true;

//		if(type==0) {
//			//System.out.println("끝");
//
//			return;
//		}

		switch (type)  {
			case 1: //상하좌우
				move(r, c, 0, time);
				move(r, c, 1, time);
				move(r, c, 2, time);
				move(r, c, 3, time);
				break;
			case 2: //상하
				move(r, c, 0, time);
				move(r, c, 1, time);
				break;
			case 3: //좌우
				move(r, c, 2, time);
				move(r, c, 3, time);
				break;
			case 4: //상우
				move(r, c, 0, time);
				move(r, c, 3, time);
				break;
			case 5: //하우
				move(r, c, 1, time);
				move(r, c, 3, time);
				break;
			case 6: //하좌
				move(r, c, 1, time);
				move(r, c, 2, time);
				break;
			case 7: //상좌
				move(r, c, 0, time);
				move(r, c, 2, time);
				break;
		}


	}
//
//	static class Point{
//		int r, c, time, type;
//
//		public Point(int r, int c, int time, int type) {
//			this.r = r;
//			this.c = c;
//			this.time = time;
//			this.type = type;
//		}
//
//		@Override
//		public String toString() {
//			return "Point{" +
//					"r=" + r +
//					", c=" + c +
//					", time=" + time +
//					", type=" + type +
//					'}';
//		}
//	}

//		static void move(int r, int c, int d, int time) { //0 1 2 3 (상하좌우)
//		int nr = r + dr[d];
//		int nc = c + dc[d];
//
//		if(nr>=0 && nc>=0 && nr<N && nc<M && !v[nr][nc]) {  //&& map[nr][nc]!=0
//			v[nr][nc] = true;
//			q.offer(new Point(nr, nc, time+1 , map[nr][nc]));
//
//		}
//
//	}
//	static void bfs() {
//		v[R][C] = true;
//		q.offer(new Point(R, C, 0, map[R][C]));
//
//		while (!q.isEmpty()) {
//			Point p = q.poll();
//			System.out.println(p);
//			if(p.time == L || p.type ==0 || p.r==0 || p.r==N || p.c==0 || p.r==M) {
//				System.out.println("끝");
//				if(!last[p.r][p.c]) {
//					last[p.r][p.c] = true;
//					result++;
//				}
//				//return;
//			}
//
//			switch (p.type)  {
//				case 1: //상하좌우
//					move(p.r, p.c, 0, p.time);
//					move(p.r, p.c, 1, p.time);
//					move(p.r, p.c, 2, p.time);
//					move(p.r, p.c, 3, p.time);
//					break;
//				case 2: //상하
//					move(p.r, p.c, 0, p.time);
//					move(p.r, p.c, 1, p.time);
//					break;
//				case 3: //좌우
//					move(p.r, p.c, 2, p.time);
//					move(p.r, p.c,3, p.time);
//					break;
//				case 4: //상우
//					move(p.r, p.c, 0, p.time);
//					move(p.r, p.c, 3, p.time);
//					break;
//				case 5: //하우
//					move(p.r, p.c, 1, p.time);
//					move(p.r, p.c,3, p.time);
//					break;
//				case 6: //하좌
//					move(p.r, p.c,1, p.time);
//					move(p.r, p.c,2, p.time);
//					break;
//				case 7: //상좌
//					move(p.r, p.c, 0, p.time);
//					move(p.r, p.c,2, p.time);
//					break;
//			}
//
//		}
//	}
	public static void main(String args[]) throws Exception {
		int T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //지하 세로 길이
			M = Integer.parseInt(st.nextToken()); //지하 가로 길이
			R = Integer.parseInt(st.nextToken()); //맨홀 세로 위치
			C = Integer.parseInt(st.nextToken()); //맨홀 가로 위치
			L = Integer.parseInt(st.nextToken()); //탈출 소요 시간


			map = new int[N][M]; //지하 터널 정보 (0은 없음)
			v = new boolean[N][M];
			last = new boolean[N][M];
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}

			result = 0;
			//q = new LinkedList<>();
			dfs(R, C, 0); //맨홀 위치에서 시작
			//bfs();
//			for(int n=0; n<N; n++) {
//				for(int m=0; m<M; m++) {
//					System.out.print(last[n][m] + " ");
//
//				}
//				System.out.println();
//			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}