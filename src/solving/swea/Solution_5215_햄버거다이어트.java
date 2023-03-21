package solving.swea;
/*
 * 주어진 것
 * - 햄버거 재료에 대한 점수
 * - 햄버거 재료의 각 칼로리
 * -> 좋아하는 햄버거를 먹으면서 정해진 칼로리 이하가 되는 조합 중 가장 선호하는 햄버거
 * 
 * 재료 조합 구해서 칼로리 미만이 되는 것들 중 점수합이 가장 높은 햄버거의 점수 출력
 * 재료 조합의 개수가 정해져 있지 않으므로 1개~N개 다 해봄
 * 
 * */

import java.util.Scanner;

class Solution_5215_햄버거다이어트   {
	static int maxScore;
	static int kcalLimit;
	
	
	public static void com(int[] selectScore, int[] selectKcal, int[] score, int[] kcal, int count, int idx) {
		if(count == selectScore.length) {
			int tmpScore = 0;
			int tmpKcal = 0;

			for(int i=0; i<count; i++) {
				tmpScore += selectScore[i];
				tmpKcal += selectKcal[i];
			}
			if(tmpKcal <= kcalLimit  & maxScore < tmpScore) {
				maxScore = tmpScore;
			}
			return;
		}
		
		for(int i=idx; i<kcal.length; i++) {
				selectKcal[count] = kcal[i];
				selectScore[count]= score[i];
				com(selectScore, selectKcal, score, kcal, count+1, i+1);
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			maxScore = 0;
			int N = sc.nextInt(); //재료의 수
			kcalLimit = sc.nextInt(); //제한 칼로리
			int[] score = new int[N];
			int[] kcal = new int[N];
			for(int n=0; n<N; n++) {
				score[n] = sc.nextInt();
				kcal[n] = sc.nextInt();
			}
			
			//조합 수 1~N
			for(int comCount =1; comCount<=N; comCount++) {
				com(new int[comCount], new int[comCount], score, kcal, 0,0);
			}
			
			System.out.println("#"+test_case+" "+maxScore);
		}
	}
}