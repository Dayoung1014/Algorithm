package solving.baekjoon;

import java.util.Scanner;

/*
 * 1하나로 이루어진 타일, 00붙어있는 타일 
 * 
 * N이 주어졌을 때 만들 수 있는 가짓수 세기
 * 
 * 1은 n-1에 붙일 수 있음
 * 00은 n-2에 붙일 수 있음
 * */

public class Main_1904_01타일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] f = new int[N+1];
		f[1] = 1;
		if(N>1) f[2] = 2;
		for (int i = 3; i <=N; i++) {
			f[i] = (f[i-1]+f[i-2]) % 15746;
		}
		
		System.out.println(f[N]);
	}
}
