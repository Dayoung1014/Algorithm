package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 맨 위층부터 시작해서 아래에 있는 수 중 하나를 선택하여 내려옴
 * 이제까지 선택된 수의 합이 최대가 되도록
 * 
 * 아래층에 있는 수는 현재 층에서 선택된 수(인덱스 i) 의 대각선 왼(i) / 오(i+1)만 선택 가능
 * 
 * dfs로 모든 경우 해서 max값 갱신
 * */

public class Main_1932_정수삼각형 {
	static int N;
	static ArrayList<Integer>[] tri;
	static ArrayList<Integer>[] dp;
	
/* dfs 사용 시 시간 초과
	static void dfs(int pre, int depth, int sum) { //이전 선택값 인덱스, 현재 깊이, 총 합
		if(depth==N+1) {
			max = Math.max(max, sum);
			return;
		}
		
		int left = sum+tri[depth].get(pre);
		dfs(pre, depth+1, left);
		
		int right = sum+tri[depth].get(pre+1);
		dfs(pre+1, depth+1, right);
	}
*/
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		tri = new ArrayList[N+1]; //0비움
		dp = new ArrayList[N+1]; //0비움
		
		for (int i = 1; i < N+1; i++) {
			tri[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				tri[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		for (int i = 1; i < N+1; i++) {
			dp[i] = new ArrayList<>();
			if(i==1) dp[1].add(tri[1].get(0));
			else {
				for (int j = 0; j < i; j++) {
					int now = tri[i].get(j);
					if(j==0) dp[i].add(dp[i-1].get(j) + now);
					else if(j==i-1) dp[i].add(dp[i-1].get(j-1) + now);
					else dp[i].add(Math.max(dp[i-1].get(j-1) + now, dp[i-1].get(j) + now));
				}
			}
		}
		System.out.println(Collections.max(dp[N]));
	}
}
