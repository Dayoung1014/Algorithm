package permutation_combination;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {
	// 조합 with ArrayList
	public static void combination1(ArrayList<Integer> select, int[] arr, int index, int count) { //뽑아서 저장, 뽑을 대상, 시작 위치, 뽑을 개수
	    if (count == 0) { // 다 뽑았을 때
	        System.out.println(select);
	        return;
	    }

	    for(int i = index; i < arr.length; i++) {
	        select.add(arr[i]);
	        combination1(select, arr, i + 1, count - 1); // 뽑을 때 마다 count - 1
	        select.remove(select.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	
	// 조합 with Array
	// select : 뽑아서 저장 / arr : 뽑을 대상 / visited : arr에서의 방문 여부 / count : 뽑은 개수 / idx : arr에서의 인덱스
	public static void combination2(int[] select, int[] arr, boolean[] visited, int count, int idx) { 
		if(count == select.length) {
			System.out.println(Arrays.toString(select));
			return;
		}
		
		for(int i=idx; i<arr.length;i++) {
			if(!visited[i]) { //방문하지 않았다면
				visited[i] = true;
				select[count] = arr[i];
				combination2(select, arr, visited, count+1, i+1);
				visited[i] = false;
			}
		}
	}

	
	public static void main(String[] args) {
		//{1, 2, 3} 중복 없이 2개 고르는 조합
		System.out.println("ArrayList를 이용하여 조합 구하기");
		combination1(new ArrayList<>(), new int[]{1, 2, 3}, 0, 2);
		
		System.out.println("Array를 이용하여 조합 구하기");
		combination2(new int[2], new int[] {1,2,3}, new boolean[] {false, false, false}, 0, 0);
	}

}
