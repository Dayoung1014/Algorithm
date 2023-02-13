package solving.baekjoon.n1592;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt(); 
		 int M = sc.nextInt(); 
		 int L = sc.nextInt(); 
		 int ball = 0; //공 던진 횟수 
		 
		 int[] cntM = new int[N]; //인원 별 공 받은 횟수  (idx 오류 방지를 위해 0번~ N-1번으로 생각)
		 cntM[0] = 1; //1번이 게임 시작 
		 int now = 0; //현재 공의 위치 저장
		 
		
		 while(true) {
			 if(cntM[now] < M && cntM[now] % 2 != 0) { 
				 //현재 위치에서 시계방향 L번째로 패스
				 now = (now+L)%N;
				 cntM[now]++;
				 ball++;
			 }
			 else if(cntM[now] < M && cntM[now] % 2 == 0) {
				 //현재 위치에서 반시계방향 L번째로 패스
				 now = (now+(N-L))%N;
				 cntM[now]++;
				 ball++;
			 }
			 else if(cntM[now] == M) {
				 break;
			 }
		 }

		 System.out.println(ball);
	}

}
