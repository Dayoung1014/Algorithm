package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 회전 시작 위치는 +1, +1씩 해준다
 * -> 0,0 / 1,1 / 2, 2 / ...
 * 
 * 배열 하나 더 만들어서 원본 값 가져와서 옮길 배열에 각각 적어주고
 * 다 돈 다음에 원본 배열 갱신
 * 
 * [규칙]
 * 윗줄 (왼쪽으로 옮기기 0, -1)
 * 
 * 왼쪽줄 (아래로 내리기 +1, 0) 
 * 
 * 아랫줄 (오른쪽으로 옮기기 0, +1)
 * 
 * 오른쪽줄 (위로 올리기 -1, 0)
 * 
 * [끝 부분처리 -> 원래 규칙대로 한 결과가 배열 범위 벗어난 경우를 끝 부분이라고 침]
 * 좌상이라면 하나 내리기
 * 
 * 좌하라면 오른쪽으로 가기
 * 
 * 우하라면 올리기
 * 
 * 우상이라면 왼쪽으로 가기
 * */

public class Ing_Main_16926_배열돌리기1_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열 크기
		int M = Integer.parseInt(st.nextToken()); // 배열 크기
		int R =  Integer.parseInt(st.nextToken()); // 회전 수
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x = 0; int y = 0;
		
		int height = N; //4
		int width = M; //5
		
		for(int r=0; r<R; r++) {
			int tmp[][] = new int[N][M];
			for(int i=0; i<N; i++) { 
				tmp[i] = arr[i].clone();
			}
			
			// 위
			for(int i=0; i<width; i++) { 
				//System.out.print(arr[x][i]+" ");
				int nextX = x;
				int nextY = i-1;
				if(nextY>= 0) {
					tmp[nextX][nextY] = arr[x][i]; 
				}
				else {
					tmp[x+1][i] = arr[x][i]; 
				}
			}
			
			// 왼쪽
			for(int i=0; i<width; i++) { 
				int nextX = i+1;
				int nextY = y;
				if(nextX < N) {
					tmp[nextX][nextY] = arr[i][y]; 
				}
				else {
					tmp[i][y+1] = arr[i][y]; 
				}
			}
			
			// 아래
			for(int i=0; i<width; i++) { 
				int nowX = i;
				int nowY = y+1;
				if(nowY < N) {
					tmp[nowX][nowY] = arr[x][i]; 
				}
				else {
					tmp[x-1][i] = arr[x][i]; 
				}
			}
			// 오른쪽
			for(int i=0; i<width; i++) { 
				int nowX = i-1;
				int nowY = y;
				if(nowX < N) {
					tmp[i][nowY] = arr[i][y]; 
				}
				else {
					tmp[i][y-1] = arr[i][y]; 
				}
			}
			
			arr = new int[N][M];
			for(int i=0; i<N; i++) { 
				arr[i] = tmp[i].clone();
				System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println();
			}

		}
		


	

}
