package solving.swea.n1952;

import java.util.ArrayList;
import java.util.Arrays;

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

class  Solution{
	public static void combi(ArrayList<Integer> select, int[] arr, int index, int count) { //뽑아서 저장, 뽑을 대상, 시작 위치, 뽑을 개수
	    if (count == 0) { // 다 뽑았을 때
	        System.out.println(select);
	        return;
	    }

	    for(int i = index; i < arr.length; i++) {
	        select.add(arr[i]);
	        combi(select, arr, i + 1, count - 1); // 뽑을 때 마다 count - 1
	        select.remove(select.size() - 1); // 재귀 위해 마지막에 넣은 원소 제거 
	    }
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int day = sc.nextInt();
			int month1 = sc.nextInt();
			int month3 = sc.nextInt(); 
			int year = sc.nextInt();
			
			int[] plan = new int[12];
			int[] month_min =new int[12];

			for(int i=0; i<12; i++) {
				int now = sc.nextInt();
				plan[i] = now;
		
				// 해당 달에서 1일 이용권 / 1달 이용권 중 싼 값 저장
				if(now*day < month1) month_min[i] = now*day;
				else month_min[i] =month1;
			}
			
			// 1. month_min 합계
			// 2. 1년 이용권 
			// 3. 3달 이용권 가능한 경우 + 1번 
			// -> 모든 조합 구해서 만족되는 경우만 가격 구하기
			
			int price =0;
			int i=0;
			while(i<12)
				if(plan[i]!=0) { //수영 가는 달일때 
					if(i<=9 & plan[i+1]!=0 & plan[i+2]!=0) { //3달로 묶을 수 있다면 
						if(month3 < month_min[i]+month_min[i+1]+month_min[i+2])  { //묶어보고 
							price += month3;
							i += 3;
						}
						else {
							price += month1;
							i += 1;
						}
					
				}
			}
		
		}
	}
}