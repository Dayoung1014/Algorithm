package baekjoon.n11729;

import java.util.Scanner;
import java.util.Stack;

/*
 * 하노이 탑 이동
 * 세 개의 장대, 첫 번째 장대에 n개의 원판이 반경이 큰 순서대로 쌓여 있음
 * 1 -> 3으로 전체 이동
 * 
 * 조건
 * 1. 한 번에 한 개의 원판만 옮길 수 있음
 * 2. 쌓아 놓은 원판은 항상 위<아래
 * 3. 최소가 되는 이동 횟수 K 구하기
 * 
 * 출력 K
 * 이동 과정 a번째 맨 위 -> b번째 맨 위
 * */

public class Main {
	static Stack<Integer> one = new  Stack<>();
	static Stack<Integer> two = new  Stack<>();
	static Stack<Integer> three = new  Stack<>();
	
	public static void move(one, two, three) {
		if(one.size()==0 && three.size())
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=N; i>0; i-- ) {
			one.add(i);
		}
		
		
		
		
	}

}
