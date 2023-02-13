package solving.baekjoon.n15651;


import java.util.ArrayList;

/*
 * 1부터 N까지 자연수중 중복 허용해서 M개 고르는.. 중복 순열
 * */

import java.util.Scanner;

public class Main2 {
	static ArrayList<Integer> select = new ArrayList<>(); // 뽑아서 저장하는 곳
	static int N; static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void per(ArrayList<Integer> select, int count) { //뽑아서 저장, 뽑을 개수
	    if (count == 0) {  // 다 뽑았을 때
	    	for(int s : select) {
	    		sb.append(s+" ");
	    	}
	    	sb.append("\n");
	        return;
	    }

	    for(int i = 1; i <= N; i++) {
	    	select.add(i);
	        per(select, count - 1); // 뽑을 때 마다 count - 1
	        select.remove(select.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt();

		per(select, M);
		System.out.println(sb);
	}
	
	

}