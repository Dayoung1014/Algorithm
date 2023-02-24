package solving.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> s = new Stack<>();
		for(int k=0; k<K; k++) {
			int now = sc.nextInt();
			if(now == 0) s.pop();
			else s.push(now);
		}
		int sum = 0;
		while(!s.isEmpty()) {
			sum += s.pop();
		}

		System.out.println(sum);
	}

}
