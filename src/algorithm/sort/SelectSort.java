package algorithm.sort;

import java.util.Arrays;

// 배열값중 가장 작은것을 선택해서 앞으로 보내는 방식
public class SelectSort {
	static int arr[] = { 1, 10, 7, 6, 3, 4, 5, 2, 8, 9 };

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int idx = i;
			for (int j = i; j < arr.length; j++) {
				if(min>arr[j]) {
					min=arr[j];
					idx=j;
				}
			}
			int tmp = arr[i];
			arr[i]=arr[idx];
			arr[idx]=tmp;
		}
		System.out.println(Arrays.toString(arr));
	}

}
