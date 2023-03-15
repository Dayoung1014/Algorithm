package solving.baekjoon;

import java.util.Scanner;

/*
 * 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수
 * 숌이 만든 N번째 영화의 제목에 들어간 수를 출력
 * */

public class Main_1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count=0;
		int number=1;
		while(true) {
			if(Integer.toString(number).contains("666")) count++;
			if(count==N) break;
			number++;
		}
		System.out.println(number);
	}
}
