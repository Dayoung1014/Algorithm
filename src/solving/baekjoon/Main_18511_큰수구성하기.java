package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer;


public class Main_18511_큰수구성하기 {
	static int N, K;
	static Integer arr[];
	static int result = 0;
	
	static void permu(String str, int count) { //뽑은거 저장, 뽑은 개수 
		if(count == 0) {
			if(Integer.parseInt(str) <= N) {
				result = Math.max(result, Integer.parseInt(str)); 
			}
			return;
		}
		
		for(int i = 0; i<arr.length; i++) {
			permu(str+arr[i], count-1); //뽑은 개수 하나 올려서 넘겨줌->select 다음 인덱스에 저장 가능
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new Integer[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = Integer.toString(N).length();
		for (int i = len; i >= len-1; i--) {
			permu("", i);
		}
		
		System.out.println(result);
	}
}
