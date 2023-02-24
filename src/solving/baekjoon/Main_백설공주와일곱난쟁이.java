package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 9개의 정수중 총 합이 100이 되는 7개의 수 찾기
 * 
 * */

public class Main_백설공주와일곱난쟁이 {
	static void combi(int[] select, int[] arr, int count, int idx, int sum) { //선택한 배열, 선택한 갯수, 볼 idx, 현재 합
		if(count==7) {
			if(sum == 100) {
				for(int s:select) {
					System.out.println(s);
				}
			}
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			select[count] = arr[i];
			combi(select, arr, count+1, i+1, sum+arr[i]);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		combi(new int[7], arr, 0, 0, 0);
	}

}
