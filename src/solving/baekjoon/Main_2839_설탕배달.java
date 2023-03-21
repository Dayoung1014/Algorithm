package solving.baekjoon;

import java.util.Scanner;

/*
 * 설탕을 정확히 Nkg 배달해야 함
 * 설탕은 3kg, 5kg 있다
 * 최대한 적은 봉지 들고가고 싶을 때 몇 봉지 가져가는지
 *
 * 5를 최대한 많이, 3을 최대한 적게
 * 만들 수 없다면 -1
 * */

public class Main_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int result = -1; // 배달하는 봉지의 최소 개수 (만들 수 없다면 -1)
		
		// 5를 최대한 많이 들고 가야함
		if(N%5 == 0) result = N/5;
		else {  
			int max3 = N/3;
			for(int i=1; i<=N/3; i++) {  //3을 점점 늘려가며 찾음 
				if((N-3*i) % 5 ==0) {
					result = i + ((N-3*i))/5;
					break;
				}
			}
		}
		System.out.println(result);
	}
	


}
