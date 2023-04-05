package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 수열 A가 주어졌을 때 가장 긴 감소하는 부분 순열의 길이를 구해라
 * */

public class Main_11722_가장긴감소하는부분순열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0; //가장 긴 감소하는 부분 수열 길이
		int[] dp = new int[N];
		Arrays.fill(dp, 1); // dp를 1로 초기화

		// LIS 알고리즘
		for (int i = 0; i < N; i++) { //현재값 설정
			for (int j = 0; j < i; j++) { //현재의 이전 값까지 탐색
				if(arr[i] < arr[j]) //이전 값이 자기보다 크다면
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			count = Math.max(count, dp[i]); // 가장 긴 감소하는 수열 길이 갱신
		}
		System.out.println(count);

	}
}
