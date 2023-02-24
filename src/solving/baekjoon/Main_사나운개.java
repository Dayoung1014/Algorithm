package solving.baekjoon;

import java.util.Scanner;

public class Main_사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); //개1 공격 (분 단위)
		int B = sc.nextInt(); //개1 쉼 
		int C = sc.nextInt(); //개2 공격 
		int D = sc.nextInt(); //개2 쉼 
		
		int[] PMN = new int[3];
		for(int i=0; i<3; i++) { // P M N 입
			PMN[i] = sc.nextInt();
		}
		
		int res;
		for(int i=0; i<3; i++) {
			res = 0;
			if(PMN[i] % (A+B)>0 && PMN[i] % (A+B)<=A) { //개1 공격 시간에 포함되는지 
				res++;
			}
			if(PMN[i] % (C+D)>0 && PMN[i] % (C+D)<=C) { //개2 공격 시간에 포함되는지 
				res++;
			}
			System.out.println(res);
		}
	}
}
