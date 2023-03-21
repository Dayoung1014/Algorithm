package solving.swea.n2001;


// https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

/* 
 * N*N 배열 안 숫자 = 해당 영역에 존재하는 파리의 개수 
 * M*M 파리채를 사용해 최대한 많은 파리 죽이고자 함
 * 
 * 현재 위치에서 M*M 구간 구해서 max값 갱신
 * */


import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt(); 
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int maxKill = 0;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					int sum = 0;
					for(int x=i; x<i+M; x++) {
						for(int y=j; y<j+M; y++) {
							sum += arr[x][y];
						}
				}
				if(sum > maxKill) maxKill = sum;	
				}
			}
			
		
			System.out.println("#"+test_case+" "+maxKill);
		}
	}
}