package solving.swea;

/*
 * 달팽이 1~N*N까지의 숫자가 시계 방향
 * 
 * 큰 문제 해결하기 어려움 -> 일반화 시켜서 재귀 -> 작은 문제에서 return ...
 * */

import java.util.Scanner;

class Solution_1954_달팽이숫자 {
	static int[][] arr;
	static int[] d1 = {0, 1, 0, -1}; //상하
	static int[] d2= {1, 0, -1, 0}; //좌우

	public static void rec(int x, int y, int num, int len) { //시작 위치들, 적을 숫자, 현재 사각형 변 길이
		if(len==0) {
			print(arr);
			return;
		}
		else if(len == 1) {
			arr[x][y] = num;
			print(arr);
			return;
		}
		else {
			for(int i=0; i<4; i++) { // 각 변 순회
				for(int j=0; j<len-1; j++)  {// 한변길이보다-1 만큼 가야함
					arr[x][y] = num++;
					x += d1[i];
					y+= d2[i];
				}
			}
		}
		rec(x+1, y+1, num, len-2);
	}
	
	public static void print(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); // 달팽이 크기
			arr = new int[N][N];
			System.out.println("#"+test_case);
			rec(0,0, 1, N);
		}
	}
	
}