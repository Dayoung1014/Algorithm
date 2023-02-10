package permutation_combination_subset;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

	// 순열 with ArrayList
	public static void permutation1(ArrayList<Integer> select, int[] arr, int count) { //뽑아서 저장, 뽑을 대상, 뽑을 개수
	    if (count == 0) {  // 다 뽑았을 때
	        System.out.println(select);
	        return;
	    }

	    for(int i = 0; i < arr.length; i++) {
	        if(select.contains(arr[i])) {
	            continue;
	        }
	        select.add(arr[i]);
	        permutation1(select, arr, count - 1); // 뽑을 때 마다 count - 1
	        select.remove(select.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	
	
	// 순열 with Array
	// select : 뽑아서 저장 / arr : 뽑을 대상 / visited : arr에서의 방문 여부 / count : 뽑은 개수 
	public static void permutation2(int[] select, int[] arr, boolean[] visited, int count) { 
		if(count == select.length) { // 다 뽑음 (뽑은 개수 == 뽑아서 저장하는 곳의 길이)
			System.out.println(Arrays.toString(select));
			return;
		}
		for(int i = 0; i<arr.length; i++) {
			if(!visited[i]) { //방문하지 않았다면
				visited[i] = true;
				select[count] = arr[i];
				permutation2(select, arr, visited, count+1); //뽑은 개수 하나 올려서 넘겨줌->select 다음 인덱스에 저장 가능
				visited[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		//{1, 2, 3} 중복 없이 2개 고르는 순열
		System.out.println("ArrayList를 이용하여 순열 구하기");
		permutation1(new ArrayList<>(), new int[]{1, 2, 3}, 2);

		System.out.println("Array를 이용하여 순열 구하기");
		permutation2(new int[2], new int[] {1, 2, 3}, new boolean[] {false, false, false},  0);
		
	}

}