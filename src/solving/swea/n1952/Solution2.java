package solving.swea.n1952;

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

class Solution2 {
	static int day;
	static int month1;
	static int month3;
	static int year;
	static int[] plan;
	static int result;

	static void check_price(int month, int price) { // 월, 지금까지 누적 가격
		if(month > 12) {
			if(price<result) result = price;
			return;
		}

		if(plan[month]!=0) { //이용한 달
			check_price(month+1, price+day*plan[month]); //1일
			check_price(month+1, price+month1); //1달
			check_price(month+3, price+month3); //3달
		}
		else { //이용하지 않은 달
			check_price(month+1, price);
		}
	}
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		// 1. month_min 합계
		// 2. 1년 이용권
		// 3. 3달 이용권 가능한 경우 + 1번
		// -> 1, 2, 3 중 min 값 반환

		for(int test_case = 1; test_case <= T; test_case++)
		{
			day = sc.nextInt();
			month1 = sc.nextInt();
			month3 = sc.nextInt();
			year = sc.nextInt();

			plan = new int[13]; //index 에러 방지 위해 하나 크게 설정
			for(int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
			}

			result = year; //check_price에서 일, 1달, 3달 비교 ... year도 비교해주기 위해 변수 설정
			check_price(1, 0);
			System.out.println("#"+test_case+" "+result);

		
		}
	}
}