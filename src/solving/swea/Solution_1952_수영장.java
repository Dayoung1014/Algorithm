package solving.swea;

import java.util.ArrayList;

/*
 * 1년 동안 각 달의 이용 계획 수립 후 가장 적은 비용으로 수영장 이용하고 싶음
 * 
 * 수영장
 * - 1일 이용권 : 1일 이용 가능
 * - 1달 이용권 : 1달 이용 가능 (매달 1일 시작)
 * - 3달 이용권 : 연속된 3달 이용 가능 (매달 1일 시작) / 11, 12월도 사용 가능하지만 내년 넘어가게는 불가능
 * - 1년 이용권 : 1년 동안 이용 가능 (매년 1월 1일 시작) 
 * 
 * 
 * 각 이용권 요금 / 각 달 수영장 이용 횟수 
 * -> 가장 적은 비용 구하기
 * 
 * -----
 * 모든 경우의 수 다 구해서 가장 적은 비용 출력
 * */

import java.util.Scanner;

class  Solution_1952_수영장 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		// 1. month_min 합계
		// 2. 1년 이용권
		// 3. 3달 이용권 가능한 경우 + 1번
		// -> 1, 2, 3 중 min 값 반환

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int day = sc.nextInt();
			int month1 = sc.nextInt();
			int month3 = sc.nextInt(); 
			int year = sc.nextInt();
			
			int[] plan = new int[12]; //월별 이용일
			int[] month_min =new int[12]; //해당하는 월에 원데이 vs 1달 중 min 저장
			int month_min_sum = 0; // 원데이 vs 1달 중 min 값들의 합

			for(int i=0; i<12; i++) {
				int now = sc.nextInt();
				plan[i] = now;
		
				// 해당 달에서 1일 이용권 / 1달 이용권 중 싼 값 저장
				if(now*day < month1) { //원데이가 더 싼 경우
					month_min[i] = now*day;
					month_min_sum += now*day;
				}
				else  { //1달 이용권이 더 싼 경우
					month_min[i] = month1;
					month_min_sum += month1;
				}
			}



			int i=0;
			int price = 0;
			while(i<12) {
				if(plan[i]!=0) { //수영 가는 달일때 
					if(i<=9 && plan[i+1]!=0 && plan[i+2]!=0) { //3달로 묶을 수 있을 때
						if (month3 < month_min[i] + month_min[i + 1] + month_min[i + 2]) { //3달 금액이 더 싸다면
							price += month3;
							i += 3;
						} else { //3달 금액이 더 비싸다면 일단 이번 달은 원데이 or 월별 중 min으로
							price += month_min[i];
							i += 1;
						}
					}
					else { //3달로 묶을 수 없을 때 (해당 달만 결제하면 됨)
						if(month3 < month_min[i]) { // 3달 가격 자체가 더 쌀 때
							price += month3;
							i += 3;
						}
						else { // 원데이 or 월별 중 min으로
							price += month_min[i];
							i += 1;
						}

					}
				}
				else { //수영 가는 달이 아니라면 다음 달로 가기
					i += 1;
				}

			}


			System.out.println("#"+test_case+" "+Math.min(Math.min(month_min_sum, year), price));

		
		}
	}
}