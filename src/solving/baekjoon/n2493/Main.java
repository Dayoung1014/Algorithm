package solving.baekjoon.n2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 일직선 위에 N개의 높이가 서로 다른 탑을 수평으로 왼~오 차례로 세움
 * 탑에서 레이저 왼쪽으로 발사
 * 가장 먼저 만나는 하나의 탑에서만 수신 받음
 * 
 * 수신한 탑의
 * */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		StringBuilder sb = new StringBuilder();
	
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		for(int i=0; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		breakout:
		for(int i=N-1; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(arr[i] <= arr[j]) {
					sb.replace(i*2, i*2+1, Integer.toString(j+1));
					break;
				}
			}
		}
		
		System.out.println(sb);
		
	}

}
