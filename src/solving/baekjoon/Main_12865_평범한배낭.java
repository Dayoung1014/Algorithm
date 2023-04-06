package solving.baekjoon;

/*
* 물건은 무게 : W / 가치 : V
* 최대 K 만큼의 무게를 가방에 넣어 최다한 총 가치가 크도록
*
* 냅색 알고리즘
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게

        int w[] = new int[N+1];    // 무게 저장
        int v[] = new int[N+1];    // 가치 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken()); // 물건의 무게
            v[i] = Integer.parseInt(st.nextToken()); // 물건의 가치
        }

        int dp[][] = new int[N+1][K+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];     // 기본적으로 이전 아이템의 가치를 저장
                if(j - w[i]>=0) {    // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재할 때
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]); // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 넣음
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
