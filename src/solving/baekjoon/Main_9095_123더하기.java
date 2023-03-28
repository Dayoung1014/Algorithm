package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1, 2, 3의 합으로 나타내는 방법의 수 (순서 다르면 다른것이라고 침)
 * */

public class Main_9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] dp = new int[n+1];
			dp[1]=1;
			if(n>=2) dp[2] = 2;
			if(n>=3) dp[3] = 4;
			
			for (int j = 4; j <=n; j++) {
				//j-1에서 1추가
				dp[j] = dp[j-1];
				
				//j-2에서 2추가
				dp[j] += dp[j-2];
						
				//j-3에서 3추가
				dp[j] += dp[j-3];
			}
			
			System.out.println(dp[n]);
		}
	}
}
