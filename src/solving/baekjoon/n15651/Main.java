package solving.baekjoon.n15651;


/*
 * 1부터 N까지 자연수중 중복 허용해서 M개 고르는.. 중복 순열
 * */

import java.util.Scanner;

public class Main {
	static int[] output; // 뽑아서 저장하는 곳
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt();
		output = new int[M]; 
		recur(output, 0, N, M);
		System.out.println(sb);
	}

	public static void recur(int[] output, int count, int n, int m) {
	    if (count == m) {
	    	for(int o : output) {
	    		sb.append(o+" ");
	    	}
	    	sb.append("\n");
	        return;
	    }
	 
	    for (int i=0; i<n; i++) {
            output[count] = i+1;
            recur(output, count + 1, n, m);     
	    }
	  

	}

}