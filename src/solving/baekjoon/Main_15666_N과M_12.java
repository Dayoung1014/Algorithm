package solving.baekjoon;

/*
* N개의 자연수 중 M개를 고른 수열
*
* 중복 허용
* 고른 수열은 비내림차순
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15666_N과M_12 {
    static int N, M;
    static Set<String> set = new HashSet<>();
    static StringBuilder res = new StringBuilder();

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
        combi(arr, new int[M], 0, 0);
        System.out.println(res);

    }

    //뽑을 대상, 뽑아서 저장, 방문 여부, 뽑은 개수
    static void combi(int[] arr, int[] sel, int idx, int count) {
        if(count == M) {
            StringBuilder sb = new StringBuilder();
            for(int s : sel) {
                sb.append(s+" ");
            }
            if(!set.contains(sb.toString())) {
                res.append(sb+"\n");
                set.add(sb.toString());
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[count] = arr[i];
            combi(arr, sel, i, count+1);
        }
    }
}
