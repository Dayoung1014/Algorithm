package solving.other;

import java.util.Scanner;

/*
 * 층별로 파, 노 칠하려함
 * 노 : 인접한 두 층에 연속하여 사용할 수 있음
 * 파 : 인접한 두 층에 연속하여 사용할 수 없음
 * 
 * 칠할 수 있는 방법의 수 : f(n)
 * */

public class 아파트색칠하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		int[] yellow_last = new int[n+1]; //마지막이 yellow (다음에 아무거나 가능)
		int[] blue_last = new int[n+1]; //마지막이 blue (다음에 yellow만 가능)
		
		yellow_last[0] = blue_last[0] = 0;
		yellow_last[1] = blue_last[1] = 1;
		
		for (int i = 2; i <=n; i++) {
			yellow_last[i] = blue_last[i-1] + yellow_last[i-1]; //이전에 파랑인 것 + 이전에 노랑인 것
			blue_last[i] = yellow_last[i-1]; //이전이 노랑인 것
			//System.out.println(yellow_last[i]+blue_last[i]);
		}
		
		System.out.println(yellow_last[n]+blue_last[n]);
	
	}
}
