package solving.baekjoon.n1074;

// 16개 단위로 
/*
 * x: -1 / 1 / -1 / 3 
 * y: 1 / -3 / 1 / 1
 * 
 * 
 * 32개 단위로 
 * 1
 * - 7
 * */

import java.util.Scanner;

public class Main {
	static int N, r, c;
	static int[] dy = {1, -3, 1, 1};
	static int x = 0;
	static int y=0;
	static int count=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //배열의 크기 2^2 * 2^2
		r = sc.nextInt();
		c = sc.nextInt();
		Math.sqrt(N);
	}
	
	public static void visit(int n) { //한 변의 길이
		if(n==2) {
			for(int i=x; i<x+2; i++) {
				for(int j=y; j<y+2; j++) {
					count++;
					if(i==r && j==c) System.out.println(count);
				}
			}
			x+=2;
			y+=2;
			return;
		}
		
		
		
	}

}
