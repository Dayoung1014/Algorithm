package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] dict = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < dict.length; i++) {
			dict[i] = Long.parseLong(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		long[] search = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < search.length; i++) {
			search[i] = Long.parseLong(st.nextToken());
		}
		
		// search 원소가 dict 안에 있는가 (있으면 1 없으면 0)
		// 이분탐색 
		Arrays.sort(dict);
		
		for(long num : search) {
			int left = 0;
			int right = N-1;
			int mid;

			int answer = 0;
			
			while(left <= right) {	
				mid = (left + right) / 2;
				if(dict[mid] == num) { // 존재
					answer = 1;
					break;
				}
				else if(dict[mid] > num) { // 왼쪽에 존재
					right = mid - 1;
				}
				else if (dict[mid] < num){ // 오른쪽에 존재
					left = mid + 1;
				}
			}
			System.out.println(answer);
		}
	}
}
