package permutation_combination_subset;

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
	
	public static void subset_binaryCount() {
		
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

	}

}
