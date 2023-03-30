package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 새집은 N*N 격자
 * r : 행 번호 c : 열 번호 (1부터 시작)
 * 
 * 파이프 2개의 칸 차지
 * 회전은 3가지 방향으로 가능
 * - 가로(왼 오)
 * - 세로(위 아래)
 * - 대각선(왼위 우아래)
 * 
 * 파이프를 밀어서 이동시켜야 함
 * 빈 칸만 차지하도록 해야함
 * 
 * */

public class Ing_Main_17070_파이프옮기기1 {
	
	// 밀 수 있는 방향 : 오른쪽, 아래, 대각선
	// 다음 좌표의 start는 현재 좌표의 end
	static int[] dr = {0, 1, 1}; // 다음 end 좌표의 위치
	static int[] dc = {1, 0, 1};
	static int N;
	static int[][] map;
	
	static boolean[][] visited;
	static int count = 0;
	
	static void dfs(int r, int c) {
		System.out.println(r + " "+c);
		if(r==N-1 && c==N-1) {
			count++;
			System.out.println("====================");
			visited = new boolean[N][N];
			//return;
		}
		
		visited[r][c] = true;
		
		
		for(int i=0; i<3; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
			if((i==0 || i==1) && map[nr][nc] == 1) continue;
			if((i==2) && (map[nr][nc]==1 || map[nr-1][nc]==1 || map[nr][nc-1]==1)) continue;
			dfs(nr, nc);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1); //처음 위치에서 파이프의 end 좌표
		System.out.println(count);
		
		
	}
}
