package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2차원 배열이 주어졌을 때 
 * i, j ~ x, y 까지 저장된 수들의 합을 구하는 프로그램
 * 
 * 위치 값은 1부터 시작
 * 
 *  배열의 합은 231-1보다 작거나 같다. -> long 사용
 * */

public class Main_2167_2차원배열의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		int pre = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());

			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1; //0부터 시작해주기 위해 -1씩
			int j = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			long sum=0;
			for(int start=i; start<=x; start++) {
				for(int end=j; end<=y; end++) {
					
					sum += map[start][end];
				}
			}
			System.out.println(sum);
		}
		
//		for (int n = 0; n < N; n++) {
//			System.out.println(Arrays.toString(map[n]));
//		}
		
	}

}
