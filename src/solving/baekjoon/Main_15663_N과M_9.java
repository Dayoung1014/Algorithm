package solving.baekjoon;

/*
* N개의 자연수 중 M개를 고른 수열
*
* 중복되는 수열 여러 번 출력하지 않기
* 수열은 사전 숮ㄴ으로 증가하는 순서로 출력
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15663_N과M_9 {
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
        permu(arr, new int[M], new boolean[N], 0);
        System.out.println(res);

    }

    //뽑을 대상, 뽑아서 저장, 방문 여부, 뽑은 개수
    static void permu(int[] arr, int[] sel, boolean[] visited, int count) {
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

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                sel[count] = arr[i];
                visited[i] = true;
                permu(arr, sel, visited, count+1);
                visited[i] = false;
            }
        }
    }
}
