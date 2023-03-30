package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 퇴사1보다 데이터 입력 범위가 커졌기 때문에
 * 퇴사1처럼 완탐으로는 시간 초과
 * -> DP로 해결
 * */

public class Ing_Main_15486_퇴사2 {
	static int N;
	static int[] day;
	static int[] price;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		day = new int[N+1]; // 1 2 3 4 5 6 7
		price = new int[N+1]; 
	
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			day[i] =  Integer.parseInt(st.nextToken());
			price[i] =  Integer.parseInt(st.nextToken());
		}
		
		work();
	}
	
	private static void work() {
		int[] dp = new int[N+2]; //퇴직하는 날
		
		for (int d = 1; d <= N; d++) {
			int next_day = d+day[d];
			if(next_day <= N+1) {
				// 현재일을 하는 경우와 아닌 경우 중 큰 값을 저장
				// 여태까지 해서 벌은 금액이 dp에 있음
				// 현재해서 번 금액 + 현재 일 벌 수 있는 금액 / next day 금액 비교
				dp[next_day] = Math.max(dp[d] + price[d], dp[next_day]);
				
			}
			System.out.println(Arrays.toString(dp)+" "+d+"일째");
			
		}
	}

}
