package solving.baekjoon;

import java.util.Scanner;

public class Main_9655_돌게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean sang = true; //상근이 차례인지 아닌지
		while(true) {
			//System.out.println(sang + " "+n);
			if(n==1 || n==3) break;
			
			if(n-3>=1) n-=3;
			else if(n-1>=1) n-=1;
			sang = !sang; //차례 바꿔주기
		}
		
		if(sang) System.out.println("SK");
		else System.out.println("CY");
	}
}
