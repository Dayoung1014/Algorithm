package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * M*N 크기의 보드의 각 칸이 검은색, 흰색으로 칠해져 있음
 * 이 보드를 잘라 8*8 크기 체스판 1개 만들려함
 * 
 * 왼위가 흰 / 왼위가 검
 * 
 * 일단 8*8 크기로 잘라낸 후 몇곳은 칠하려고 할 때->최소로 칠하려면?
 * 
 * -> 완탐하면서 해당 곳을 왼위로 보고 잘랐을 때 칠해야 하는 값 -> 최소 갱신
 * 
 * */

public class Ing_Main_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		
		for (int n = 0; n < N; n++) {
			String in = br.readLine();
			for (int m = 0; m < M; m++) {
				board[n][m] = in.charAt(m);
			}
		}
		int count = Integer.MAX_VALUE; //다시 칠해야 하는 정사각형 개수의 최솟값
		char prev;
		
		for (int n = 0; n <= N-8; n++) {
			for (int m = 0; m <= M-8; m++) {
				int white=0;
				int black=0;
				
				//시작 왼위 설정
				if(board[n][m]=='W') {
					prev='W'; //왼위가 W라면
					white=0; //W인거로 만들때 
					black=1; //B인거로 만들때 -> 처음꺼 바꾸고 시작하기
				}
				else {
					prev='B'; //왼위가 W라면
					white=1; //W인거로 만들때 -> 처음꺼 바꾸고 시작하기
					black=0; //B인거로 만들때 
				}
				
				for (int i = n; i < n+8; i++) {
					for (int j = m; j < m+8; j++) {
						if(i==n&&j==m) continue;
						
						char now = board[i][j];
						if(now=='W') { //지금 W인경우
							if(prev=='W') { //이전이 W였다면
								white++;
								black++;
							}
						}
						else {
							if(prev=='B') {
								white++;
								black++;
							}
						}
						if(prev=='W') prev='B';
						else prev='W';
					}
					if(prev=='W') prev='B';
					else prev='W';
				}
				
				if(white<count) count=white;
				if(black<count) count=black;
				
			}
		}
		
		System.out.println(count);
		
	}
}
