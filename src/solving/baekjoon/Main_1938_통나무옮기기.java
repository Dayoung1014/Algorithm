package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 놓친 조건 : 3*3 정사각형의 구역에 단 한 그루의 나무도 없어야만 한다
 * 
 * 회전 시 
 * - 가로 -> 세로
 * - 세로 -> 가로
 * */

public class Main_1938_통나무옮기기 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1}; 
	static int res = 0;
	static class Point {
		int[] r = new int[3];
		int[] c = new int[3];
		int cnt;
		boolean tall; // 세로 상태인지 아닌지
		public Point(int[] r, int[] c, int cnt, boolean tall) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.tall = tall;
		}
		@Override
		public String toString() {
			return "Point [r=" + Arrays.toString(r) + ", c=" + Arrays.toString(c) + ", cnt=" + cnt + ", tall=" + tall
					+ "]";
		}
		
		
	}
	static int[] startR = new int[3];
	static int[] startC = new int[3];
	static int[] finishR = new int[3]; 
	static int[] finishC = new int[3];  
	
	private static void bfs() { 
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		
		
		boolean check = true;//세로인지 
		for (int i = 0; i < 3; i++) {
			v[startR[i]][startC[i]] = true;
			if(startR[0] != startR[i]) check = false; 
		}
		q.add(new Point(startR, startC, 0, check));
		
		continueOut:
		while(!q.isEmpty()) {
			Point p = q.poll();
			System.out.println(p);
			// finish 비교 시 앞 뒤로 다 해보기  
			if((p.r[0] == finishR[0] && p.r[1] == finishR[1]  && p.r[2] == finishR[2] 
					&&  p.c[0] == finishC[0] && p.c[1] == finishC[1]  && p.c[2] == finishC[2])
				|| (p.r[2] == finishR[0] && p.r[1] == finishR[1]  && p.r[0] == finishR[2] 
						&&  p.c[2] == finishC[0] && p.c[1] == finishC[1]  && p.c[0] == finishC[2]) ) {
				res = p.cnt;
				break;
			} 
			
			for (int d = 0; d < 5; d++) { 
				int[] nr; int[] nc; 
				if(d==4) { // 회전
					if(p.tall) { //세로 -> 가로
						nr = new int[] {p.r[2]-1, p.r[1], p.r[0]+1};
						nc = new int[] {p.c[2]-1, p.c[1], p.c[0]+1};
					}
					else { //가로 -> 세로
						nr = new int[] {p.r[0]-1, p.r[1], p.r[2]+1};
						nc = new int[] {p.c[0]+1, p.c[1], p.c[2]-1};
					}

				}
				else {  // 상하좌우 
					nr =  new int[]  {p.r[0]+dr[d], p.r[1]+dr[d], p.r[2]+dr[d]};
					nc =  new int[] {p.c[0]+dc[d], p.c[1]+dc[d], p.c[2]+dc[d]};
				} 
				if(nr[0]<0 || nr[1]<0 || nr[2]<0 || nc[0]<0 || nc[1]<0 || nc[2]<0) continue;
				if(nr[0]>=N  || nr[1]>=N || nr[2]>=N || nc[0]>=N || nc[1]>=N || nc[2]>=N) continue;
				if(v[nr[0]][nc[0]] && v[nr[1]][nc[1]] && v[nr[2]][nc[2]]) continue;
				if(map[nr[0]][nc[0]]=='1' || map[nr[1]][nc[1]]=='1' || map[nr[2]][nc[2]]=='1') continue;
				
				if(d==4) {
					for (int i = -1; i <=1 ; i++) {
						for (int j = -1; j <=1 ; j++) {
							int checkR = nr[1]+i;
							int checkC = nc[1]+i;
							if(checkR<0 || checkC<0 || checkR>=N || checkC>=N) continue continueOut;
							if(map[checkR][checkC]=='1') continue continueOut;
						}
					}
				}
				v[nr[0]][nc[0]] = true; v[nr[1]][nc[1]] = true; v[nr[2]][nc[2]] = true; 	//3개가 완전히 다 방문처리 된 것만 지나치기
				if(d==4) q.add(new Point(nr, nc, p.cnt+1, !p.tall));
				else q.add(new Point(nr, nc, p.cnt+1, p.tall));
			}  
		}
		 
	}
	
	static int N;
	static char[][] map;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		N = Integer.parseInt(br.readLine()); //평지 한 변의 길이
		map = new char[N][N]; 
		
		ArrayList<Integer> sR = new ArrayList<>(); ArrayList<Integer> sC = new ArrayList<>();
		ArrayList<Integer> fR = new ArrayList<>(); ArrayList<Integer> fC = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c);
				
				if(map[r][c] == 'B') {
					sR.add(r);
					sC.add(c);
				}
				if(map[r][c] == 'E') {
					fR.add(r);
					fC.add(c);
				} 
			}
		}  
		for (int i = 0; i < 3; i++) {
			startR[i] = sR.get(i);
			startC[i] = sC.get(i);
			
			finishR[i] = fR.get(i);
			finishC[i] = fC.get(i);
		} 
		bfs();
 
		System.out.println(res);
	}

}