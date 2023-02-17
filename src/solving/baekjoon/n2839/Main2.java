package solving.baekjoon.n2839;

import java.util.Arrays;

/*
 * 손님이 지불한 금액에서 물건값을 뺀 차액을 
 * 최소한의 개수로 줄 때 몇개로 주는지
 * */

public class Main2 {
	static int[] coin = {500, 400, 100, 50, 10};
	static int result = 0;
	static int give = 800;
	
	public static void main(String[] args) {
		int maxCnt = give/10;
		for(int c=1; c<=maxCnt; c++) {
			combi(new int[c], 0,0, 0);
			if(result != 0) break;
		}
		System.out.println(result);

	}
	
	public static void combi(int[] select, int count, int sum, int idx) { 
		if(count == select.length) {
			if(sum == give) {
				result = count;
			}
			return;
		}
		
		for(int i=idx; i<coin.length;i++) {
			select[count] = coin[i];
			combi(select, count+1, sum+coin[i], i);
		}
	}

}
