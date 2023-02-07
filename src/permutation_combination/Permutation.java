package permutation_combination;

import java.util.ArrayList;

public class Permutation {

	// Permutation with ArrayList
	public static void permutation1(ArrayList<Integer> list, int[] arr, int count) { //뽑아서 저장, 뽑을 대상, 뽑을 개수
	    if (count == 0) {  // 다 뽑았을 때
	        System.out.println(list);
	        return;
	    }

	    for(int i = 0; i < arr.length; i++) {
	        if(list.contains(arr[i])) {
	            continue;
	        }
	        list.add(arr[i]);
	        permutation1(list, arr, count - 1); // 뽑을 때 마다 count - 1
	        list.remove(list.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	
	
	// Permutation_repetition with Array
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
