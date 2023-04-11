package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816_숫자카드 {
	 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		int[] plus = new int[1_000_000];
		int[] minus = new int[1_000_000];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			if(cards[i] >= 0) plus[cards[i]]++;
			else minus[Math.abs(cards[i])]++;
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		//System.out.println(Arrays.toString(cards));
		
		int[] count = new int[M];
		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N-1;
			int mid;
			
			while(left<=right) {
				mid = (left+right)/2;
				
				if(cards[mid] == nums[i]) {
					if(nums[i] >= 0) count[i] = plus[cards[mid]];
					else count[i] = minus[Math.abs(cards[mid])];
					break;
				}
				else if(cards[mid] < nums[i]) {
					left = mid + 1;
				}
				else if(cards[mid] > nums[i]) {
					right = mid - 1;
				}
			}
		}
		
		for(int c : count) System.out.print(c+ " ");
	}
}
