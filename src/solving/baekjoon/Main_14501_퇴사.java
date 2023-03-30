package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 오늘부터 N+1 되는날 퇴사를 하기 위해 남은 N일동안 최대한 많은 상담을 하려 함
 * 하루에 상담 하나씩 진행 (한 사람이 여러 날 걸릴 수 있음)
 * 얻을 수 있는 최대 수익 구해라
 * */

public class Main_14501_퇴사 {
	static int N;
	static int[] day;
	static int[] price;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		day = new int[N+1]; // 1 2 3 4 5 6 7
		price = new int[N+1]; 
	
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			day[i] =  Integer.parseInt(st.nextToken());
			price[i] =  Integer.parseInt(st.nextToken());
		}
		
		// 완탐
		recursive(1, 0); //날짜 기준으로 완탐 (1일부터 시작, 0원부터 시작)

		System.out.println(res);
	}

	static int res = Integer.MIN_VALUE;
	private static void recursive(int d, int p) {
		if(d==N+1) { //퇴사날
			res = Math.max(res, p);
			return ;
		}
		
		// 해당 날 일을 하는 경우 
		if(d+day[d] <= N+1) { //퇴사하는 날까지 일이 끝난다면
			recursive(d+day[d], p+price[d]);
		}
		
		// 해당 날 일을 하지 않는 경우 
		recursive(d+1, p);
	}
}
