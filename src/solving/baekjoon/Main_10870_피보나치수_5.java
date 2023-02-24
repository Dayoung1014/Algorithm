package solving.baekjoon;

import java.util.Scanner;

public class Main_10870_피보나치수_5 {
	
	public static int fibo(int n) {
		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		
		return fibo(n-1)+fibo(n-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));
	}

}
