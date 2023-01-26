package baekjoon.n2798;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //카드의 개수
		M = sc.nextInt(); 
		result = 0; // M을 넘지 않는 최대값
		
		int[] cards = new int[N];
		for(int i=0; i<N; i++) { //카드 숫자 입력 받기
			cards[i] = sc.nextInt();
		}
		
		boolean[] visited = new boolean[N];
		
		combi(cards, visited, 0, 3);
		System.out.println(result);

	}
	
	// 재귀 이용한 조합
	/* idx(현재 인덱스) : 0부터 시작
	 * 현재 인덱스 뽑으면 visited[idx] = true / 뽑지 않으면 visited[idx] = false
	 * 뽑은 경우와 뽑지 않은 경우 모두 다 봐야함
	 * 그 전에 본 값들은 다시 보지 않도록 idx 1씩 증가
	 * idx == n이 되면 모든 인덱스 다 본 것임(arr 끝에 도착 -> 더 이상 조합 만들 수 X) -> 재귀 종료
	 * 
	 * */
	
	/*
	 * arr : 대상 배열 
	 * visited : 방문 배열 
	 * idx : arr 방문 위치 
	 * r : 남은 뽑을 개수
	 * */
	static void combi(int[] arr, boolean[] visited, int idx, int r) {
		// r==0 뽑는거 완료 -> 뽑은거 출력 -> 반환
		if(r==0) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					//System.out.print(arr[i]+" ");
					sum+=arr[i];
				}
			}
			if(sum<=M && sum>result) {
				result = sum;
			}
			//System.out.println();
			return;
		}
		
		// idx == n이면 arr 다 본거니까 반환
		if(idx == arr.length) {
			return;
		}
		
		// idx 방문 true
		visited[idx] = true;
		// 재귀 (idx+1, r-1)
		combi(arr, visited, idx+1, r-1); //하나 방문했으니까 idx+1/r-1
		
		// idx 방문 false
		visited[idx] = false; //반환 후에는 해당 idx false
		// 재귀 (idx+1, r)
		combi(arr, visited, idx+1, r); //반환 했으니까
	}

}
