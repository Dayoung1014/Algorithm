package solving.baekjoon;

/*
* 수열 A가 주어졌을 때 가장 긴 증가하는 부분 수열의 길이 구하기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0; //가장 긴 증가하는 수열의 길이
        int[] dp = new int[N];
        Arrays.fill(dp, 1); //dp 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) //현재 값이 앞에 값보다 크다면
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            count = Math.max(count, dp[i]); // 가장 긴 증가하는 수열 길이 갱신
        }
        System.out.println(count);
    }
}
