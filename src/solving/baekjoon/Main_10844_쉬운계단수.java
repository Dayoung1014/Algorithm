package solving.baekjoon;

/*
* 1<= N <= 100
* 길이가 N인 게단 수가 총 몇 개 있는지 구해라
* 길이가 N인수
* */

import java.util.Scanner;

public class Main_10844_쉬운계단수 {
    static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long dp[][] = new long[N+1][10]; // dp[i][j] : i번째 자릿수의 값이 j일때의 계단 수

        //첫번째 자릿수는 경우의 수가 1
        for(int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        // 두번째~N번째 자릿수 확인
        for(int i=2; i<=N; i++) {
           // 현재 자릿값을 0부터 9까지 탐색
            for(int j=0; j<10; j++) {
                // 현 자릿값이 9라면 이전 자릿값은 8만 가능
                if(j == 9) {
                    dp[i][9] = dp[i-1][8]%mod;
                }
                // 현 자릿값이 0이라면 이전 자릿값은 1만 가능
                else if(j==0) {
                    dp[i][0] = dp[i-1][1]%mod;
                }
                // 그 외는 현 자릿값의 -1, +1 가능
                else {
                    dp[i][j] = (dp[i-1][j-1]+ dp[i-1][j+1])%mod;
                }
            }
        }

        long ans = 0;
        for(int i=0; i<10; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans%mod);

    }
}
