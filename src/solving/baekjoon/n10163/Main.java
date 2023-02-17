package solving.baekjoon.n10163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 평면에 색깔이 다른 직사각형 모양 색종이가 차례로 놓여있음
 * 서로 평행하거나 수직이도록
 * 
 * N장의 색종이가 주어진 위치에 차례로 (앞 번호가 아래로 감) 놓이는 경우
 * 각 색종이가 보이는 부분의 면적을 구해라
 * 
 * -> 마지막부터 해당하는 부분을 true로 변경
 * -> 마지막 사각형 넓이는 그냥 계산
 * -> 그 다음부터는 넓이 = true변경 후 개수 -  true로 변경 전 개수 
 * 
 * */

public class Main {
	static boolean[][] map = new boolean[1001][1001];
	
	static int countTrue() { // boolean 배열에서 true 개수 세기
		int cnt = 0;
		for(int h=0; h<1001; h++) {
			for(int w=0; w<1001; w++) {
				if(map[h][w]) cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		if(N==0) {
			System.out.println(0);
		}
		else {
			int[][] arr = new int[N][4];
			
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] result = new int[N];
			
			for(int i=N-1; i>=0; i--) {
				int pre = countTrue();
				
				for(int h=arr[i][1]; h<arr[i][1]+arr[i][3]; h++) {
					for(int w=arr[i][0]; w<arr[i][0]+arr[i][2]; w++) {
						map[h][w] = true;
					}
				}
				
				int after = countTrue();
				if(i==N-1) {
					result[i] = arr[i][2]*arr[i][3];
				}
				else {
					result[i] = after - pre;
				}
			}
			
			for(int i:result) {
				System.out.println(i);
			}
		}
		

	}

}
