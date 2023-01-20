package swea.n1979;

import java.util.Scanner;
class Solution {
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = 0;  //단어가 들어갈 수 있는 자리 수
			int one = 0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N][N];
			
			
			//단어 퍼즐 입력 받기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			//가로줄 확인
			for(int i=0; i<N; i++) { 
				one = 0; //줄 바뀌면 초기화
				for(int j=0; j<N; j++) {
					
					if(arr[i][j] == 1) {  
						one++;
					}
					else {
						one = 0;
					}
					
					if(one==K) { 
						if(j==N-1) { //끝 자리인 경우 
							cnt++;
							one = 0;
						}
						else if(arr[i][j+1] == 0) { //오른쪽 확인
							cnt++;
							one = 0;
						}
					}
					
				}
			}
			
			//세로줄 확인
			for(int i=0; i<N; i++) { 
				one = 0; //줄 바뀌면 초기화
				for(int j=0; j<N; j++) {
					
					if(arr[j][i] == 1) {
						one++;
					}
					else {
						one = 0;
					}
					
					if(one==K) { 
						if(j==N-1) { //끝 자리인 경우 
							cnt++;
							one = 0;
						}
						else if(arr[j+1][i] == 0) { //밑 확인
							cnt++;
							one = 0;
						}
					}
					
				}
			}
			System.out.println("#"+test_case + " "+cnt);
			
		}
	}
}