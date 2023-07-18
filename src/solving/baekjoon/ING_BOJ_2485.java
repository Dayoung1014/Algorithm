package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ING_BOJ_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] diff = new int[N-1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N-1; i++) {
            diff[i] = arr[i+1] - arr[i];
            max = Math.max(max, diff[i]);
        }

        // diff 들의 최대공약수 구하기
        while(true) {
            if(max==1) break;
            boolean chk = true;
            for (int d : diff) {
                if(d%max != 0) chk = false;
            }

            if(chk) break;
            max--;
        }

        System.out.println(max);

        int cnt = 0;


    }
}
