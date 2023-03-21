package solving.swea.n1225;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 조건에 따라 n개의 수를 처리하면 8자리 암호 생성 가능
 * 
 * 8개 숫자 입력 받음
 * 1. 첫 숫자 1감소시키고 뒤로 이동 -> 앞에서 빼서 뒤로 이동 -> 큐
 * 2. 그 다음 수 2감소...
 * 이렇게 5까지 감소시키는 것을 한 사이클이라고 함
 * 
 * 숫자 감소시킬 때 0보다 작아지면 0으로 유지시키며 프로그램 종료 후 반환
 * ...
 * 
 * */

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] cycle = {1,2,3,4,5};
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int num = sc.nextInt(); //테스트 번호
			Queue<Integer> q = new LinkedList<>();
			for(int i=0; i<8; i++) {
				q.add(sc.nextInt());
			}
			
			breakout:
			while(true) { // 전체 
				//
				for(int i=0; i<5;i++) { // 한 사이클
					int now = q.poll()-cycle[i];
					if(now > 0) {
						q.add(now);
					}
					else {
						q.add(0);
						break breakout;
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i : q) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}