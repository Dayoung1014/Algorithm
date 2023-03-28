package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n+1];
		int[] dp = new int[n+1];

		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
			if(i==1) dp[1] = stairs[1];
			else if(i==2) dp[2] = stairs[1]+stairs[2];
			else if(i==3) dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
			else dp[i] = Math.max(dp[i-3]+stairs[i-1], dp[i-2]) + stairs[i];
		}

		System.out.println(dp[n]);


	}
}
