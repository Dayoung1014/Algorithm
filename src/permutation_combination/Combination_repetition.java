package permutation_combination;

import java.util.ArrayList;

public class Combination_repetition {

	// Combination_repetition with ArrayList
	public static void Combination_repetition(ArrayList<Integer> list, int[] arr, int index, int count) {
	    // 다 뽑았을 때
	    if (count == 0) {
	        System.out.println(list);
	        return;
	    }

	    for(int i = index; i < arr.length; i++) {
	        list.add(arr[i]);
	        Combination_repetition(list, arr, i,count - 1); // 뽑을 때 마다 count - 1
	        list.remove(list.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
