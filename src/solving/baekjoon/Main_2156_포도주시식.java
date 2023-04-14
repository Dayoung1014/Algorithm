package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n];
		for (int i = 0; i < dp.length; i++) {
			if(i==0) dp[0] = arr[0];
			else if(i==1) dp[1] = dp[0] + arr[1];
			else {
				// 
			
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(dp));

	}

}
