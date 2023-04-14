package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2193_이친수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] fin0 = new long[N+1];
		long[] fin1 = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			if(i==1) fin1[i] = 1;
			else if(i==2) fin0[i] = 1;			
			else {
				 fin0[i] = fin0[i-1] + fin1[i-1];
				 fin1[i] =  fin0[i-1];
			}
		}
		
		System.out.println(fin0[N] + fin1[N]);
	}
}
