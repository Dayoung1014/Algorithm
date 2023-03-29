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

public class Ing_Main_14501_퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] day = new int[N];
		int[] cost = new int[N];
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
		}
		
	}
}
