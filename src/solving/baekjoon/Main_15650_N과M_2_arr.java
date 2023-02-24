package solving.baekjoon;


/*
 * 1부터 N까지 자연수중 M개 고르는 조합
 * 오름차순 출력
 * */

import java.util.Scanner;

public class Main_15650_N과M_2_arr {
	static int[] output; // 뽑아서 저장하는 곳
	static boolean [] visited ; // 1~N의 방문 여부
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt();
		output = new int[M]; 
		visited = new boolean[N]; 
		recur(output, visited, 0, N, M);
	}

	public static void recur(int[] output, boolean[] visited, int count, int n, int m) {
	    if (count == m) {
	    	for(int o : output) {
	    		System.out.print(o+ " ");
	    	}
	    	System.out.println();
	        return;
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	        	if(count>0) {
	        		if(output[count-1] < i+1) {
	    	            visited[i] = true;
	    	            output[count] = i+1;
	    	            recur(output, visited, count + 1, n, m);       
	    	            visited[i] = false;
	        		}
	        	}
	        	else {
		            visited[i] = true;
		            output[count] = i+1;
		            recur(output, visited, count + 1, n, m);       
		            visited[i] = false;
	        	}

	        }
	    }

	}

}