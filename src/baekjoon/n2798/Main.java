package baekjoon.n2798;

import java.util.ArrayList;
import java.util.Scanner;

// 블랙잭
//카드의  합이 21을 넘지 않는 한도 내에서 카드의 합을 최대한 크게 만들어야 함
// 새로운 규칙 추가된 블랙잭
// 각 카드에 양의 정수가 있음
// 딜러가 N장의 카드를 숫자가 보이도록 둠
// 딜러가 M을 외침
// 플레이어가 제한된 시간 안에 N장 중 3장 골라서 
// ->합이 M을 넘지 않으면서 최대한 가깝게
// 이렇게 만드는 카드 3장의 합 출력

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //카드의 개수
		int M = sc.nextInt(); 
		int result = 0;
		ArrayList<Integer> game = new ArrayList<>(); //3장 조합들
		
		int[] cards = new int[N];
		for(int i=0; i<N; i++) { //카드 숫자 입력 받기
			cards[i] = sc.nextInt();
		}
		

	}
	
	//재귀 이용한 구현
	/* depth는 현재 인덱스 0부터 시작
	 * 현재 인덱스 뽑으면 visited[depth] = true / 뽑지 않으면 visited[depth] = false
	 * 뽑은 경우와 뽑지 않은 경우 모두 다 봐야함
	 * 그 전에 본 값들은 다시 보지 않도록 depth 1씩 증가
	 * depth == n이 되면 모든 인덱스 다 본 것임(arr 끝에 도착 -> 더 이상 조합 만들 수 X) -> 재귀 종료
	 * 
	 * */
	static void combi(int[] arr, boolean[] visited, int depth, int n, int r) {
		
	}

}
