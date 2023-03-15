package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 덩치 (몸무게, 키)
 * 
 * 몸무게, 키 둘다 큰 경우 -> 덩치가 크다
 * 둘 중 하나만 큰 경우 -> 비교 불가
 * 
 * 덩치 등수 
 * - 자신보다 더 큰 덩치의 사람의 수 (같은 등수 여러명 가질 수 있음)
 * - 자신보다 큰 사람이 K일때 -> K+1등
 * - 자신보다 큰 사람이 없을 때 -> 1등
 * 
 * */

public class Main_7568_덩치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int[] w = new int[N];
		int[] h = new int[N];
		for (int i = 0; i < N; i++) {	
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken()); //몸무게
			h[i] = Integer.parseInt(st.nextToken()); //키
		}
		
		for (int i = 0; i < N; i++) {	//i의 등수 확인
			int count=0;
			for(int j=0; j<N; j++) {
				if(i!=j && w[i]<w[j] && h[i]<h[j]) count++;
			}
			sb.append((count+1)+" ");
		}
		System.out.println(sb);
	}

}
