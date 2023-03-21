package solving.swea.n4008;

/*
 * N개의 숫자가 적혀 있는 게임 판
 * + - x / 연산자 카드를 숫자 사이에 끼워 넣어 다양한 결과 구함 (단 연산자 우선순위 상관 없이 왼>오)
 * 최대와 최소를 찾고 그 차를 출력하기
 * 
 * 
 * 
 * */

import java.util.Scanner;

class Solution {
	static int N;
	static int[] cnt;
	static int[] nums;
	int max=Integer.MIN_VALUE;
	int min=Integer.MAX_VALUE;
	 //연산자의 조합
	static void dfs(int[] cnt) { //sel : 연산자 고른 횟수
//		if() {
//			//int sum=0;
//			//돌면서 합계 구하기
//			
//			return;
//		}
		
		// 연산자 조합 만들
		
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			cnt = new int[N-1];
			nums = new int[N];
			for(int i=0; i<cnt.length; i++) {
				cnt[i] = sc.nextInt();
			}
			for(int i=0; i<nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			
			
		}
	}
}