package solving.baekjoon.n1158;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] res = new int[N];
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++) list.add(i);
		int now = -1;
		
		for(int i=0; i<N; i++) {
			now = (now+K)%list.size();
			res[i] = list.get(now);
			list.remove(now);
			 if(now==0) now=list.size()-1;
			 else now -= 1;
		}

		
		System.out.print("<");
		for(int i=0; i<N; i++) { 
			System.out.print(res[i]);
			if(i!=N-1) System.out.print(", ");
		}
		System.out.print(">");
	}

}
