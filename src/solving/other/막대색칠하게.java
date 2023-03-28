package solving.other;

import java.util.Scanner;

/*
 * 1cm 파, 1cm 노, 2cm 빨
 * 이 막대들을 연결해 길이가 n인 막대를 만드는 방법의 수 구하기
 * */


public class 막대색칠하게 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 2;
		dp[2] = 5;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1]*2;
			dp[i] += dp[i-2];
		}		
		
		System.out.println(dp[n]);
	}
}
