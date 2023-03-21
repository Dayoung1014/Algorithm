package solving.swea.n4012;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 두 명의 손님에게 비슷한 맛의 음식을 제공해야 함
 * N개의 식재료를 반으로 나눠 각각 요리
 * A와 B의 마스이 차가 최소가 되도록
 * 
 * 음식의 맛 : 식재료의 시너지들의 합
 * 
 * 식재료 1, 2의 시너지 (index 1부터라고 생각했을 때)
 * - s[1][2] + s[2][1]
 * 
 * 식재료를 N/2개씩 나누는 모든 경우 안에서
 * N/2개의 식재료를 2개씩 조합해서 모든 경우의 시너지 합 구하기 
 * 요리1, 요리2 다 구해서 최소의 차를 저장하면서 갱신
 * */


class Solution{
	static int N;
	static int[] num; //식재료 번호
	static int [][] table; //식재료 맛 테이블
	static int foodSum;
	static int min;
	
	public static int synergy(ArrayList<Integer> food) { //식재료에서 2가지 뽑는 조합 구해서 음식별 시너지 합 확인
		int sum = 0;
		for(int i=0; i<food.size(); i++) {
			for(int j=i+1; j<food.size(); j++) {
				sum += table[food.get(i)][food.get(j)];
				sum += table[food.get(j)][food.get(i)];
			}
		}
		return sum;
	}
	
	public static void setFood(ArrayList<Integer> select) { //음식 별 식재료 선정
		ArrayList<Integer> food1 = new ArrayList<>();
		ArrayList<Integer> food2 = new ArrayList<>();
		for(int i=0; i<num.length; i++) {
			if(select.contains(num[i])) food1.add(num[i]);
			else food2.add(num[i]);
		}
	
		//System.out.println(Math.abs(synergy(food1) - synergy(food2)));
		if(min > Math.abs(synergy(food1) - synergy(food2))) {
			min =  Math.abs(synergy(food1) - synergy(food2));
		}
	}
	
	public static void combi(ArrayList<Integer> select , int[] num, int howmany, int idx) { // 식재료 조합 구성하기 
		if(howmany == select.size() ) {
			 setFood(select);
			return;
		}
		
		for(int i=idx; i<num.length;i++) {
			select.add(num[i]);
			combi(select, num, howmany, i+1);
			select.remove(select.size()-1);
		}
	}
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			min = Integer.MAX_VALUE;
			N = sc.nextInt(); //식재료 수
			table = new int[N][N];
			num = new int[N];
			for(int i=0; i<N; i++) {
				num[i] = i; 
				for(int j=0; j<N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
		
			combi(new ArrayList<Integer>(), num, N/2, 0);
		
			
			System.out.println("#"+test_case+" "+min);
			
		
		}
	}
}