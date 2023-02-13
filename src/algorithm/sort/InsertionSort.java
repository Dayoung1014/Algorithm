package algorithm.sort;

import java.util.Arrays;

/*
 * 숫자를 적절한 위치에 삽입하는 방식
 * 숫자의 위치를 무조건 바꾸지 안고 필요할때만 위치를 바꾼다
 * 앞에 있는 숫자는 미리 정리되어있다고 가정한다
 * 버블 선택정렬보다 효율적이다
 */
public class InsertionSort {
	static int arr[] = { 1, 10, 7, 6, 3, 4, 5, 2, 8, 9 };
	public static void main(String[] args) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i; j>=0&&arr[j]>arr[j+1] ; j--) {
				int tmp = arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=tmp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		// while 이용
//		for (int i = 0; i < arr.length-1; i++) {
//			int j = i;
//			while (j>=0&&arr[j]>arr[j+1] ) {
//				int tmp = arr[j];
//				arr[j]=arr[j+1];
//				arr[j+1]=tmp;
//				j--;
//			}
//		}
//		System.out.println(Arrays.toString(arr));
	}

}
