package solving.baekjoon.n11660;

import java.util.Scanner;

/*
 * (x1, y1)부터 (x2, y2)까지 합 구하기
 * 각 구간도 포함해서 구해야함
 * 행, 열 번호가 1부터 시작함에 주의
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //표의 크기
		int M = sc.nextInt(); //합을 구하는 횟수
		int[][] dp = new int[N+1][N+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int now = sc.nextInt();
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + now;
			}
		}

		for(int i=0; i<M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);

		}

	}

}
