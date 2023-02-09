package baekjoon.n2961;

import java.util.Scanner;

/*
 * 재료 N개 
 * 각 재료의 신맛S / 쓴맛B 알고 있다
 * 음식에서 신맛  = 사용한 재료의 신맛들의 곱
 * 음식에서 쓴맛 = 사용한 재료의 쓴맛들의 합
 * 
 * 재료를 하나 이상 사용해서 음식의 신맛 쓴맛의 차가 가장 작은
 * 
 * -> 모든 부분집합(공집합 제외) 구해서 |신맛-쓴맛| 절대값이 가장 작은거 구하기
 * */

public class Main {
	static int [] sour ;
	static int [] bitter;
	static int max=Integer.MAX_VALUE;
	private static void recursive(int falseCnt, int[] arr, boolean[] sel, int idx) { //arr 원본배열 / sel 담은 것들 / idx 원본배열인덱스
		if(falseCnt == arr.length) return;  //공집합 제외
		
		if(idx == arr.length  ) { 
			int s = 1;
			int b = 0;
			for(int i=0; i<sel.length; i++) {
				if(sel[i]) { 
					s *= sour[i];
					b += bitter[i];
				}
			}
			if(Math.abs(s-b) < max) {
				max = Math.abs(s-b);
			}
			return;
		}
		
		// 담는 경우 
		sel[idx] = true; 
		recursive(falseCnt, arr, sel, idx+1);
		
		// 안담는 경우
		sel[idx] = false; 
		falseCnt++;
		recursive(falseCnt, arr, sel, idx+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sour = new int[N];
		bitter = new int[N];
		int [] idx = new int[N];
		for(int i=0; i<N; i++) {
			sour[i] = sc.nextInt(); //신맛
			bitter[i] = sc.nextInt(); //쓴맛
			idx[i] = i;
		}
		
		recursive(0, idx, new boolean[N], 0);
		System.out.println(max);
	}

}
