package hw;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

class 암호생성기 {
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