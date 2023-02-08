package baekjoon.n2477;

import java.util.Scanner;

/*
 * 참외 총 개수 = 1m^2에서 자라는 참외 개수 * 밭의 총 넓이
 * 밭 넓이 = 큰 사각형 - 작은 사각형
 * 
 * 큰 사각형 가로 : 동(1) 서(2) 중에 큰 길이
 * 작은 사각형 가로 : 동(1) 서(2) 중에 작은 길이
 * 
 * 큰 사각형 세로 : 남(3) 북(4) 중에 큰 길이
 * 작은 사각형 세로 : 남(3) 북(4)  중에 작은 길이
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 1m^2에서 자라는 참외 개수
		int maxW = 0; int maxH = 0; // 큰 사각형 가로 세로
		int minW = 0; int minH = 0;  // 작은 사각형 가로 세로
		
		for(int i=0; i<6; i++) {
			int dir = sc.nextInt(); //방향
			int len = sc.nextInt();
			if(dir==1 || dir==2) { //가로
				if(maxW<len) maxW=len;
				if(minW==0 | minW>len) minW=len;
			}
			else { //세로
				if(maxH<len) maxH=len;
				if(minH==0 | minH>len) minH=len;
			}
		}

		System.out.println(minH);
		System.out.println(maxH);
		System.out.println(minW);
		System.out.println(maxW);
		int area = maxH*maxW - minH*minW;
		int count = K * area;
		System.out.println(count);
	}

}
