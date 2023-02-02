package baekjoon.n11399;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 인출하는데 걸리는 시간을 오름차순 정렬해서 
 * 
 * 1번 원소 * N
 * 2번원소 * N-1
 * ....
 * N번 원소 * 1
 * 
 * 총합
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		int[] times = new int[N];
		for(int i=0; i<N; i++) {
			times[i] = sc.nextInt();
		}

		Arrays.sort(times); // 정렬
		
		for(int i=0; i<N; i++) {
			res += times[i]*(N-i);
		}
		System.out.println(res);
		

	}

}
