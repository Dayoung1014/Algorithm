package algorithm.sort;

import java.util.Arrays;

// 새로운 배열
public class CountingSort {
	static int arr[] = { 1, 10, 7, 6, 3, 4, 5, 2, 8, 9 };
	static int[] count=new int[100];
	
	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		System.out.println(Arrays.toString(count));
		for (int i = 0; i < count.length; i++) {
			if(count[i]!=0) {
				System.out.print(i+" ");
				
			}
		}
	}

}
