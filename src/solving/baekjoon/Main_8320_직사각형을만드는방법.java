package solving.baekjoon;

import java.util.Scanner;

public class Main_직사각형을만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		
		for(int i=1; i<=n; i++) { //가로
			for(int j=i; j<=n; j++) { //세로
				if(i*j <= n) {
					res+=1;
				}
			}
		}
		System.out.println(res);
	}

}
