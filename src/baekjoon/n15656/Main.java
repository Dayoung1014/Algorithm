package baekjoon.n15656;

import java.util.Arrays;
import java.util.Scanner;

/*
 * N개 중 M개 중복 순열
 * 오름차순으로 구하려면 -> 원형을 sort 후 구하기
 * -> 시간 초과
 * */

public class Main {
	public static void permu_re(int[] select, int[] arr, int count) {
		if(count == select.length) {
			for(int s : select) {
				System.out.print(s+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			select[count] = arr[i];
			permu_re(select, arr, count+1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		permu_re(new int[M], arr, 0);
	}

}
