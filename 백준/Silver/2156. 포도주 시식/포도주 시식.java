import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n+1];
		for (int i = 1; i < dp.length; i++) {
			if(i==1) dp[1] = arr[1];
			else if(i==2) dp[2] = dp[1] + arr[2];
			else {
				dp[i] = Math.max(Math.max(dp[i-2] + arr[i] , dp[i-1]), dp[i-3]+arr[i-1]+arr[i]);
			}
		}
		System.out.println(dp[n]);
	}

}