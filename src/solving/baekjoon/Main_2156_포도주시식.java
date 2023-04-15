package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 선택 시 모두 마시고 원래 위치에 다시 놓아야 함
 * 연속으로 놓여 있는 3잔을 모두 마실 수는 없음
 * 
 * 가장 많은 양의 포도주를 마시고 싶을 때 그 양은 얼마인가
 * */

public class Main_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n+1];
		for (int i = 1; i < dp.length; i++) {
			if(i==1) dp[1] = arr[1];
			else if(i==2) dp[2] = dp[1] + arr[2];
			else {
				dp[i] = Math.max(Math.max(dp[i-2] + arr[i] , dp[i-1]), dp[i-3]+arr[i-1]+arr[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
