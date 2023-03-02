package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. 낚시왕이 오른쪽으로 한 칸 이동
 * 2. 낚시왕이 있는 열에(세로) 있는 상어 중 땅과 가장 가까운 상어 잡음
 * 3. 상어가 이동
 *
 * ....
 * 낚시왕이 오른쪽  끝까지 이동하면 stop
 *
 * */

public class Main_17143_낚시왕3 {
	static class Fish {
		int r, c, s, d, z;

		public Fish(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int R, C, M;
	static Fish[][] map;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Fish[R][C];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Fish(r, c, s,d, z);
		}


		for(int p=0; p<C; p++) {
			for(int i=0; i<R; i++) {
				if(map[i][p] != null) { //사람 이동하며 상어 잡기
					result += map[i][p].z;
					map[i][p] = null;
					break;
				}
			}

			move(); //상어 이동
		}
		System.out.println(result);


	}

	private static void move() {
		Queue<Fish> before = new LinkedList<>(); //상어 이동 전
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!=null) before.offer(map[i][j]);
			}
		}
		//맵 초기화 후 상어 이동시키며 재배치
		map=new Fish[R][C];
		while(!before.isEmpty()) {
			Fish f = before.poll();

			int nr=f.r; int nc=f.c;

			for(int j=0; j<f.s; j++) {
				nr += dr[f.d];
				nc += dc[f.d];

				if(nr<0 || nc<0 || nr>=R || nc>=C) { // 경계 넘은 경우
					nr = nr-(2*dr[f.d]); //이동 전 단계로 가서, 다른 방향으로 한 번 가기
					nc  = nc-(2*dc[f.d]);
					if(f.d==1) f.d=2;
					else if(f.d==2) f.d=1;
					else if(f.d==3) f.d=4;
					else if(f.d==4) f.d=3;
				}
			}

			if(map[nr][nc] == null || map[nr][nc].z < f.z) { //맵에 넣어주기
				map[nr][nc] = new Fish(nr,nc,f.s,f.d,f.z);
			}
		}
	}

}