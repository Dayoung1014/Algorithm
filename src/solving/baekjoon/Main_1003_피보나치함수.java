package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N이 주어지고 fibonacci(N)을 호출했을 때
 * 0과 1이 각각 몇 번 출력되는가
 * 
 * */


public class Main_1003_피보나치함수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] cnt0  = new int[41];
			int[] cnt1  = new int[41];
			
			cnt0[0] = 1;
			cnt0[1] = 0;
			cnt1[0] = 0;
			cnt1[1] = 1;
		
			for (int n = 2; n<= N; n++) {
				cnt0[n] = cnt0[n-1] + cnt0[n-2];
				cnt1[n] = cnt1[n-1] + cnt1[n-2];
			}
			System.out.println(cnt0[N] + " " + cnt1[N]);
		}
		
		
	}
}
