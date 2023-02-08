package baekjoon.n15655;

/*
 * N개의 자연수에서 M개 조합
 * 오름차순으로 구하려면 -> 원형을 sort 후 조합 구하기
 * */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void combi(int[] select, int[] arr, int count, int idx) {
		if(count == select.length) {
			for(int s : select) {
				System.out.print(s+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			select[count] = arr[i];
			combi(select, arr, count+1, i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt();
		int [] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		combi(new int[M], arr, 0, 0);
	}

}