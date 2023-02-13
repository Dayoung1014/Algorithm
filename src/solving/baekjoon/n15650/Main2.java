package solving.baekjoon.n15650;


import java.util.ArrayList;

/*
 * 1부터 N까지 자연수중 M개 고르는 조합 중 오름차순인 것들
 * */

import java.util.Scanner;

public class Main2 {
	static ArrayList<Integer> select = new ArrayList<>();// 뽑아서 저장하는 곳
	static int N; static int M;
	public static void com(ArrayList<Integer> select, int start, int count) { //start 1부터 count는 M
	    if (count == 0) { // 다 뽑았을 때
	    	for(int s : select) {
	    		System.out.print(s+" ");
	    	}
	    	System.out.println();
	        return;
	    }

	    for(int i = start; i <= N; i++) {
	    	if(select.size()>0 && select.get(select.size()-1) > i) 
	    		continue;
	    	select.add(i);
	    	com(select, i + 1, count - 1); // 뽑을 때 마다 count - 1
	    	select.remove(select.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt();

		com(select, 1, M);
	}

}