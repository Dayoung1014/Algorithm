package algorithm.sort;

import java.util.Arrays;

/*
 * 시간복잡도 O(N*logN)
 * 특정한 값을 기준으로 둘로 나눈다 (피봇 기준값)
 * 분할정보
 * 기준값 3
 * -> 방향은 기준값보다 큰값  <- 방향은 기준값보다 작은값 을 찾아 값을 바꾸어준다
 * 3_, 7, 8, 1, 5, 9, 6, 10, 2, 4
 * 3_, 2, 8, 1, 5, 9, 6, 10, 7, 4
 * 3_, 2, 1, 8, 5, 9, 6, 10, 7, 4
 * 기준값 기준으로 인덱스가 엇갈림
 * 엇갈림기준으로 왼쪽에 있는값을 기준값을 바꾸어준다
 * 1, 2, 3, 8, 5, 9, 6, 10, 7, 4
 * 기준값이 바뀌면 기준값기준 왼쪽은 기준값보다 작고 오른쪽은 기준값 보다 크다
 * 이제 기준값 3을 기준으로 왼쪽은 가장왼쪽값인 1이 기준값이 되고 오른쪽은 8이 기준값이 된다
 * 왼쪽기준 정렬
 * 1_, 2, 3, 8_, 5, 9, 6, 10, 7, 4
 * 1, 2_, 3, 8_, 5, 9, 6, 10, 7, 4
 * 오른쪽 정렬 기준값 8 보다 큰 9 와 작은 4의 위치 교환
 * 1, 2, 3, 8_, 5, 9, 6, 10, 7, 4
 * 기준값 8 보다 큰 9 와 작은 4의 위치 교환
 * 1, 2, 3, 8_, 5, 4, 6, 10, 7, 9
 * 기준값 8 보다 큰 10 와 작은 9의 위치 교환
 * 1, 2, 3, 8_, 5, 4, 6, 7, 10, 9
 * 기준값 8 보다 큰 10 와 작은 8이 검색되고 엇갈림 기준값과 7의 위치교환
 * 1, 2, 3, 7_, 5, 4, 6, 8_, 10, 9
 * 기준값은 7, 8 이 되고 다시 반복한다
 * 1, 2, 3, 5_, 7, 4, 6, 8_, 10, 9
 * 1, 2, 3, 5_, 4, 7, 6, 8_, 10, 9
 * * 1, 2, 3, 4_, 5, 7, 6, 8_, 10, 9
 * 선택정렬 n ^ 2
 * 1,2,3,4,5,6,7,8,9,10 = 100
 *  1,2,3,4,5 = 25 
 *  6,7,8,9,10 = 25
 *  = 50  
 *  기준값을 잘못주면 O(n^2) 이 나온다
 */
public class QuickSort {
	static int arr[] = { 3, 7, 8, 1, 5, 9, 6, 10, 2, 4 };

	public static void main(String[] args) {
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int key = start; // 키는 첫번째 원소
		int i = start + 1;
		int j = end;
		int tmp=0;

		while (i <= j) {
			while (i<=end && arr[i] <= arr[key]) {
				i++;
			}
			while (arr[j] >= arr[key] && j > start) {
				j--;
			}
			if (i > j) {
				tmp = arr[j];
				arr[j] = arr[key];
				arr[key] = tmp;
			} else {
				tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}

		}
		quickSort(arr, start, j - 1);
		quickSort(arr, j + 1, end);
	}
}
