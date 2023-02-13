package algorithm.sort;

import java.util.Arrays;

// 두개를 비교해 가면서 더 작은 놈은 앞으로  o(n^2)
// 결과적으로 가장큰놈이 맨뒤로 가기 때문에 범위를 뒤어서 부터 줄여나가는 방식
// ex
/*
 * 1, 10, 7, 6, 3, 4, 5, 2, 8, 9
 * 1, 10, 7, 6, 3, 4, 5, 2, 8, 9
 * 1, 7, 10, 6, 3, 4, 5, 2, 8, 9
 * 1, 7, 6, 10, 3, 4, 5, 2, 8, 9
 * 1, 7, 6, 3, 10, 4, 5, 2, 8, 9
 * ...
 * 1, 7, 6, 3, 4, 5, 2, 8, 9, 10
 * 다시 N-1 까지 자리교환 반복
 */
public class BubleSort {
	static int arr[] = { 1, 10, 7, 6, 3, 4, 5, 2, 8, 9 };
	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
