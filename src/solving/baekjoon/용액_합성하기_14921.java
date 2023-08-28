package solving.baekjoon;

/*
* 같은 양의 두 용액 혼합 -> 두 용액 특성값의 합을 특성값으로 갖게됨
* 주어진 용액 중 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 함
* 만들어서 가장 가까운 특성값 B를 출력해라
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_합성하기_14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int diff = Integer.MAX_VALUE; //혼합 용액의 특성값과 0의 차이
        int sum = 0; //혼합 용액의 특성값

        //투포인터
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int now = arr[left] + arr[right];
            if(Math.abs(now) < diff) {
                diff = Math.abs(now);
                sum = now;
            }
            if(now<0) left++;
            else right--;
        }

        System.out.println(sum);
    }
}
