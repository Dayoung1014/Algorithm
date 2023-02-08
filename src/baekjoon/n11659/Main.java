package baekjoon.n11659;

import java.util.Scanner;

/*
 * 수 N개가 주어졌을 때
 * i번째 수(포함) ~ j번째 수(포함)의 합 구하기
 * */
// 시간초과...
/*
 * 어차피 입력 받는 for는 필수적임
 * 입력 받으면서 누적합을 구해두고
 * 누적합 j 번째 - 누적합 i-1 번째
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //수의 개수
		int M = sc.nextInt(); //합을 구해야 하는 횟수
		int[] arrSum = new int[N]; // 누적합 배열
		arrSum[0] = sc.nextInt();
		for(int i=1; i<N; i++) {
			arrSum[i] = arrSum[i-1] + sc.nextInt();
		}
		
		for(int m=0; m<M; m++) {
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			if(i==0) {
				System.out.println(arrSum[j]);
			}
			else {
				System.out.println(arrSum[j]-arrSum[i-1]);
			}
		}
		
	}

}
