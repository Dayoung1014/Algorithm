package solving.swea.n1859;

import java.util.Scanner;

/*
 * 연속된 N일의 매매가 알고 주어짐
 * 하루에 최대 1만큼 구입 가능
 * 판매는 얼마든지 가능
 * 최대한의 이익 구하기 (안사는게 이익인 경우 0)
 * */

/*
 * 앞에서부터 볼 경우 
 * 오늘이 앞으로 매매가 중 최대일 때 지금까지 구매한 것 모두 판매
 * 그게 아니라면 구매
 * 판매 시 최대값 확인을 위해 추가 for문이 필요..
 * 
 * 뒤에서부터 볼 경우
 * nowMax : 지금까지 본 매매가 중 최대값 저장 (판매하는 날의 가격)
 * 현재가 nowMax보다 작은 경우 : 바로 차액을 이득에 추가
 * 아닌 경우 : nowMax 갱신
*/

// int ~21억 ~ 21억

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); //N일
			int[] price = new int[N]; //매매가
			for(int i=0; i<N; i++) {
				price[i] = sc.nextInt();
			}
			
			int nowMax = price[price.length-1]; // 현재까지의 최대값
			long profit = 0; //총 이득
			
			for(int i=price.length-2; i>=0; i--) {
				if(nowMax < price[i]) { //현 최고가 갱신
					nowMax = price[i];
				}
				else { // 추후 판매가 - 현재가 -> 이익에 추가
					profit += nowMax-price[i];
				}
			}
		
			System.out.println("#"+test_case+" "+profit); 
		}
	}
}