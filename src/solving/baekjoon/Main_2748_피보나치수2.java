package solving.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2748_피보나치수2 {
	//시간초과
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		System.out.println(fibo(n));
//	}
//	
//	static int fibo(int n) {
//		if(n==0) return 0;
//		else if(n==1 || n==2) return 1;
//		else return fibo(n-2) + fibo(n-1);
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		if(n>1) dp[2] = 1;
		for (int i = 3; i <=n ; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
