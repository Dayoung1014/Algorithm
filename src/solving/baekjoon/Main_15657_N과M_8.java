package solving.baekjoon;

/*
* N개의 자연수 중 M개를 고른 수열
* (중복 허용, 수열은 비내림차순)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M_8 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        combi(arr, new int[M], 0, 0);
    }

    // 뽑을 대상, 뽑은거 저장, 뽑을 때 기준 idx, 뽑은 개수
    static void combi(int[] arr, int[] sel, int idx, int count) {
        if(count==sel.length) {
            for(int s : sel) {
                System.out.print(s+" ");
            }
            System.out.println();
            return;
        }

        for(int i=idx; i<arr.length; i++) {
            sel[count] = arr[i];
            combi(arr, sel, i, count+1);
        }

    }
}
