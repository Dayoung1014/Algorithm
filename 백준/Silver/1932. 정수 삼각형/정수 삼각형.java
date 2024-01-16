import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] tri;
	static ArrayList<Integer>[] dp;
	
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