package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

/*
 *  스티커 한 장을 떼면 상하좌우 못쓰게 됨
 *  
 *  각 스티커에 점수를 매기고, 점수의 합이 최대가 되게
 *  */

public class Main_9465_스티커 {  
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int n = Integer.parseInt(br.readLine()); //
			int[][] map = new int[2][n+1];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[2][n+1];
			for (int i =1; i <= n; i++) {
				if(i==1) {
					dp[0][i] = map[0][i];
					dp[1][i] = map[1][i];
				}
				else {
					dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
					dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
				}
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n] ));
			
		}
	}
}
