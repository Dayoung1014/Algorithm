package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 계단은 한번에 1개, 2개씩 오를 수 있음
 * 
 * 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않음
 * 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 
 * 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
 * 
 * 마지막은 반드시 밟아야 함
 * 이 게임에서 얻을 수 있는 점수의 최댓값
 * */

public class Main_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sum = new int[n+1];
		sum[0] = 0;
		boolean jump=false;
		
		for (int i = 1; i <= n; i++) {
			int now = Integer.parseInt(br.readLine());
			if(i==1) sum[i]=now;
			else {
				if(jump) { //이번에 무조건 jump 해야 한다면
					sum[i] = now + sum[i-2];
				}
				else {
					int i_1 = now + sum[i-1];
					int i_2 = now + sum[i-2];
					if(i_1 > i_2) { //걷는게 크면
						jump = true; //다음은 무조건 점프
						sum[i] = i_1;
					}
					else sum[i] = i_2;
				}	
			}
		}
		
		
		System.out.println(sum[n]);
		
		
	}
}
