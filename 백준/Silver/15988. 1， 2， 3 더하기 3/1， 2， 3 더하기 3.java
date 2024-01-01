import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            long [] dp = new long[n+1];
            dp[1]=1;
            if(n>=2) dp[2] = 2;
            if(n>=3) dp[3] = 4;
            for (int j = 4; j <=n; j++) {
                dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1_000_000_009;
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}