package solving.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 정수 X에 사용할 수 있는 연산
 * - 3으로 나누어떨어지면 3으로 나눔
 * - 2로 나누어떨어지면 2로 나눔
 * - 1을 뺌
 * 
 * N이 주어졌을 때 연산 3개를 사용해 1을 만들려고 함
 * 사용하는 연산의 최솟값
 * */

public class Main_1463_1로만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int dp[] = new int[N+1];
		dp[0] = dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			if(i%6==0) dp[i]= Math.min(dp[i/2], Math.min(dp[i/3], dp[i-1])) +1;
			else if (i%3==0) dp[i]= Math.min(dp[i/3], dp[i-1]) +1;
			else if (i%2==0) dp[i]= Math.min(dp[i/2], dp[i-1]) +1;
			else dp[i] = dp[i-1]+1;
		}
		
		System.out.println(dp[N]);
	}

	

}
