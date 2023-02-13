package algorithm.permutation_combination_subset;

public class Subset {
	static int totalCnt;;
	
	// 부분집합 재귀로 구현하기
	public static void subset_recur(int[] arr, boolean[] sel, int idx) { //원본 배열, 선택 true/false, 원본 인덱스
		if(idx==arr.length) {
			for(int i=0; i<sel.length; i++) { 
				if(sel[i]) System.out.print(arr[i]+" "); 
			}
			System.out.println();
			totalCnt++; 
			return;
		}
		
		// 담는 경우
		sel[idx] = true;
		subset_recur(arr, sel, idx+1);
		
		// 안담는 경우
		sel[idx] = false;
		subset_recur(arr, sel, idx+1);
	}
	
	// 부분집합 재귀로 구현하기(공집합 제거)
	public static void subset_recur_exceptEmpty(int[] arr, boolean[] sel, int cnt, int idx) { //원본 배열, 선택 true/false, 원본 인덱스
		if(idx==arr.length) {
			if(cnt>0) { //공집합 아닌 경우에만
				for(int i=0; i<sel.length; i++) { 
					if(sel[i]) System.out.print(arr[i]+" "); 
				}
				System.out.println();
				totalCnt++; 
			}
			return;
		}
		
		// 담는 경우
		sel[idx] = true; 
		subset_recur_exceptEmpty(arr, sel, cnt+1, idx+1);
		
		// 안담는 경우
		sel[idx] = false;
		subset_recur_exceptEmpty(arr, sel, cnt, idx+1);
	}
	
	
	// 부분집합 바이너리 카운팅으로 구현
	public static void subset_binaryCount() {
		int[] arr = {1,3,5};
		System.out.println(4<<2); //16
		System.out.println(1 << arr.length); //8
		
		for(int i = 0; i < (1 << arr.length); i++) {
			//i는 0,1,2,3,4,5,6,7
			//i를 2진수로 표현했을때 맨 뒤에 0번째 비트가 1이면 배열의 0번째 원소 포함
			//i를 2진수로 표현했을때 맨 뒤에 1번째 비트가 1이면 배열의 1번째 원소 포함
			//i를 2진수로 표현했을때 맨 뒤에 2번째 비트가 1이면 배열의 2번째 원소 포함
			//원소의 갯수만큼 반복을 한다.
			for(int j = 0; j < arr.length; j++) {
				//j는 0,1,2
				//i를 2진수로 표현했을때 맨 뒤에 j번째 비트가 1이면 배열의 j번째 원소 포함
				if(  ( i & (1 << j) ) != 0 ) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}
	

	
	

	public static void main(String[] args) {
		int [] arr = {1, 2, 3};
		
		// 부분집합 
		totalCnt = 0;
		subset_recur(arr, new boolean[arr.length], 0);
		System.out.println("부분집합 개수 : "+totalCnt  + "\n");
		
		// 부분집합 (공집합 제거)
		totalCnt = 0;
		subset_recur_exceptEmpty(arr, new boolean[arr.length], 0, 0);
		System.out.println("부분집합 개수(공집합 제외) : "+totalCnt );
		
		//subset_binaryCount();

	}

}
