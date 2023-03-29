package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하기
 * */

public class Main_1912_연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		int max = arr[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
