package solving.baekjoon.n15654;

import java.util.Arrays;
import java.util.Scanner;

// 순열 (중복 제외)
// 오름차순 출력 

public class Main {
	static int[] nums;
	static int[] res;
	static boolean[] visited;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		res = new int[M];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
			
		}
		Arrays.sort(nums);
		per(M, 0);

	}
	
	public static void per(int M, int idx) { 
		if(idx==M) {
			for(int j=0; j<M; j++) {
				System.out.print(res[j]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(!visited[i]) {
				res[idx] = nums[i];
				visited[i] = true;
				per(M, idx+1);
				visited[i] = false;
			}
		}
		
	}
}
