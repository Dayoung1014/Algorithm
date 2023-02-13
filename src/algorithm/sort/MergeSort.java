package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
	static int[] arr = {1,10,7,6,3,2,8,4,9,5};
	static int[] sorted = new int[arr.length];
	public static void main(String[] args) {
		mergeSort(0,arr.length-1);
		System.out.println(Arrays.toString(sorted));
	}
	// start => m
	// stop => n
	private static void mergeSort(int start, int end) {
		if(start<end) {
			int middle = (start+end)/2;
			mergeSort(start, middle);
			mergeSort(middle+1, end);
			merge(start,middle,end);
		}
	}
	private static void merge(int start, int middle, int end) {
		int i = start;
		int j = middle+1;
		int k = start;
		// 작은값 순서대로 배열에 삽입
		while(i <= middle && j <= end) {
			if(arr[i]<arr[j]) {
				sorted[k]=arr[i];
				i++;
			}else {
				sorted[k]=arr[j];
				j++;
			}
			k++;
		}
		// 남은 데이타 삽입
		if(i<=middle) {
			for (int t = i; t <= middle; t++) {
				sorted[k]=arr[t];
				k++;
			}
		}else {
			for (int t = j; t <= end; t++) {
				sorted[k]=arr[t];
				k++;
			}
		}
		// 정렬된 배열을 삽입
		for (int t = start; t <= end; t++) {
			arr[t]=sorted[t];
		}
	}
}
