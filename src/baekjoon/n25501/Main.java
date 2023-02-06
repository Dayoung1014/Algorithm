package baekjoon.n25501;

import java.util.Scanner;

// 팰린드롬 문자열 : 앞에서 읽었을 때 == 뒤에서 읽었을 때
// 함수 반환값(팬린드롬이면 1 / 아니면 0) 
// recursion 함수의 호출 횟수

public class Main {
	static int cnt;
	
	public static int recursion(String s, int left, int right) {
		if(s.charAt(left) != s.charAt(right)) return 0;
		else if(left>=right) return 1;
		else {
			cnt++;
			return recursion(s, left+1, right-1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			String str = sc.next();
			cnt=1;
			System.out.println(recursion(str, 0, str.length()-1) + " " + cnt);
		}

	}

}
