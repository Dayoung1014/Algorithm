package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * DFS
 * 현재 놓여진 방향에 따라 이동할 수 있는 방법이 다름
 * 가로 -> 가로, 대각선
 * 세로 -> 세로, 대각선
 * 대각선 -> 가로, 세로, 대각선
 * */

public class Main_17070_파이프옮기기1 {
	
	static int n;
	static int[][] map;
	static int cnt=0;
	static void dfs(int x, int y, int state) { //0 = 가로 , 1 = 세로 , 2 = 대각선
		if(x==n-1 && y==n-1)  {
			cnt++;
			return;
		}
		if(state == 0){
			if(y+1 < n && map[x][y+1] == 0){
				dfs(x, y + 1, 0);
			}
		}else if(state == 1){
			if(x+1 < n && map[x+1][y] == 0){
				dfs(x+1, y, 1);
			}
		}else if(state == 2){
			if(y+1 < n && map[x][y+1] == 0){
				dfs(x, y + 1, 0);
			}
			if(x+1 < n && map[x+1][y] == 0){
				dfs(x+1, y , 1);
			}
		}

		if (x + 1 < n && y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		//dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0); //처음 위치에서 파이프의 end 좌표, 방향
		//System.out.println(map[N-1][N-1]);
		System.out.println(cnt);
		
	}
}
