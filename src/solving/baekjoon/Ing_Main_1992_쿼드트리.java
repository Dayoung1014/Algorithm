package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Ing_Main_쿼드트리 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 영상의 크기
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = Character.getNumericValue((str.charAt(j)));
			}
		}
		
		
		cut(0,0, N);
	
		System.out.println(sb);
	
	}
	
	static void cut(int r, int c, int size) {

		int sum = 0;
		for (int i = r, rEnd = r+size; i < rEnd; i++) {
			for (int j = c, cEnd = c+size; j< cEnd; j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size*size) { //모두1
			sb.append("1");
		} 
		else if(sum==0) { //모두0
			sb.append("0");
		}
		else { //혼합된 상황 
			// 사분할
			sb.append("(");
			int half = size/2;
			cut(r, c, half);
			cut(r,c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			sb.append(")");
		}
		
	}

	
}
