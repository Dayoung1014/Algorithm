package solving.baekjoon;

import java.util.Scanner;

// 1부터 N까지 중복 순열 (같은 순열은 하나로 침)
// 고른 수열은 오름(같은거는 괜찮)차순


public class Main_15652_N과_M_4 {
	static int[] nums;
	static int[] res;
	static int max=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		nums = new int[N];
		res = new int[M];
		
		
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}
		
		per(M, 0);
	}
		
		public static void per(int M, int idx) { // M개 // 뽑은 개수

			if(idx==M) {
				for(int j=0; j<M; j++) {
					System.out.print(res[j]+" ");
				}
				System.out.println();
				max=0;
				return;
			}
			
			for(int i=0; i<nums.length; i++) {
				if(max<=nums[i]) {
					res[idx] = nums[i];
					max = nums[i];
					per(M, idx+1);
				}
			}
			
		}
	
	}
	



