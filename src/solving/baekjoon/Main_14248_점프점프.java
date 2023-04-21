package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

public class Main_14248_점프점프 {
	static int N, S;
	static int[] map;
	static boolean[] v;
	static int count = 0;
	
	static void dfs(int idx) {
		v[idx] = true;
		count++;
		
		int now = map[idx];
		int[] next = new int[2];
		next[0] = idx-now; //왼쪽 
		next[1] = idx+now; //오른쪽
		for(int n : next) {
			if(n<=0 || n>=N+1 || v[n]) continue;
			dfs(n);
		} 
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1];
		v = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		S = Integer.parseInt(br.readLine());
		
		dfs(S);
		System.out.println(count);
	}

}
