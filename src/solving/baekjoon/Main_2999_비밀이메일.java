package solving.baekjoon;

import java.util.Scanner;

/*
 * R<=C / R*C =N 만족하는 경우 중 가장 R이 큰 경우
 * -> R=N부터 감소시켜가며 만족하는 경우 break;
 * int[C][R]에서 for(R) {for(C)} 읽기
 */

public class Main_2999_비밀이메일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg = sc.next();
		int N = msg.length();
		int R=0; int C=0;
		
		for(int i=N; i>0; i--) {
			R = i;
			C = N/R;
			if(R<=C && R*C==N) {
				break;
			}
		}
		
		int idx=0;
		char[][] arr = new char[C][R];
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				arr[c][r] = msg.charAt(idx++);
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(arr[c][r]);
			}
		}
		
	}

}
