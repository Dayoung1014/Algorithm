package solving.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int res = Integer.MIN_VALUE;
		for (int i = 0; i <= N-K; i++) {
			int tmp=0;
			for (int k = 0; k < K; k++) {
				tmp += arr[i+k];
			}
			if(tmp>res) res=tmp;
		}

		System.out.println(res);
	}

}
