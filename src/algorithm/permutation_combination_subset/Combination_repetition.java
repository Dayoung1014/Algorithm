package algorithm.permutation_combination_subset;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination_repetition {
	static ArrayList<Integer> select = new ArrayList<>();

	// 중복 조합 with ArrayList
	public static void combination_repetition1(ArrayList<Integer> select, int[] arr, int index, int count) { //뽑아서 저장, 뽑을 대상, 시작 위치, 뽑을 개수
	    if (count == 0) { 	  // 다 뽑았을 때
	        System.out.println(select);
	        return;
	    }

	    for(int i = index; i < arr.length; i++) {
	        select.add(arr[i]);
	        combination_repetition1(select, arr, i,count - 1); // 뽑을 때 마다 count - 1
	        select.remove(select.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	
	// 중복 조합 with Array
	// select : 뽑아서 저장 / arr : 뽑을 대상 / count : 뽑은 개수 / idx : arr에서의 인덱스
	public static void combination_repetition2(int[] select, int[] arr, int count, int idx) { 
		if(count == select.length) {
			System.out.println(Arrays.toString(select));
			return;
		}
		
		for(int i=idx; i<arr.length;i++) {
			select[count] = arr[i];
			combination_repetition2(select, arr, count+1, i);
		}
	}
	
	public static void main(String[] args) {
		//{1, 2, 3} 중복 포함 2개 고르는 중복 조합
		System.out.println("ArrayList를 이용하여 중복 조합 구하기");
		combination_repetition1(select, new int[]{1, 2, 3}, 0, 2);

	
		System.out.println("Array를 이용하여 중복 조합 구하기");
		combination_repetition2(new int[2], new int[] {1,2,3}, 0, 0);
	}

}
