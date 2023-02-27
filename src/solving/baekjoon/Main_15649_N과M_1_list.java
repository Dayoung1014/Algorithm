package solving.baekjoon;


import java.util.ArrayList;

/*
 * 1부터 N까지 자연수중 M개 고르는 순열
 * */

import java.util.Scanner;

public class Main_15649_N과M_1_list {
	static ArrayList<Integer> select = new ArrayList<>(); // 뽑아서 저장하는 곳
	static int M;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt();
		
		per(select, M);
	}

	public static void per(ArrayList<Integer> select, int count) { //담을 곳, 뽑은 개수
	    if (count == 0) {
	    	for(int s : select) {
	    		System.out.print(s+" ");
	    	}
	    	System.out.println();
	        return;
	    }
	    for (int i=1; i<=N; i++) {
	        if(!select.contains(i)) { //담겨 있지 않다면
	        	select.add(i);
	        	per(select, count-1);
	        	select.remove(select.size()-1);
	        }
	    }

	}

}