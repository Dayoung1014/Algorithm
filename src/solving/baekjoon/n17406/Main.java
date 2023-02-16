package solving.baekjoon.n17406;

import java.util.Scanner;

/*
 * [ N*M 배열 A의 값 ] 
 * - 각 행에 있는 모든 수의 합 중 최소값
 * 
 * [ 배열의 회전 ]
 * - r과 c는 1부터 시작 !! 
 * - (r, c, s) 주어졌을 때 좌상값(r-s, c-s) / 우하값(r+s, c+s) 정사각형
 * - 시계 방향으로 한칸씩 돌림
 * 
 * - 회전 연산이 여러개 주어졌을 때 각 연산 완료 후 배열 A의 값 구해서 최소값 갱신
 * 
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int [][] order = new int[K][3];
		int[][] A = new int[N][M];
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				A[n][m] = sc.nextInt();
			}
		}
		for(int k=0; k<K; k++) {
			for(int i=0; i<3; i++) {
				order[k][i] = sc.nextInt();
			}
		}
		
		

	}

}
