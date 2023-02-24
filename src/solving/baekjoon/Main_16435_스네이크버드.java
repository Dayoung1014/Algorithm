package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 스네이크버드
 * - 과일 하나를 먹으면 길이가 1만큼 늘어남
 * - 과일은 지상으로부터 h(i) 높이에 있음
 * - 자신의 길이보다 작거나 같은 높이의 과일을 먹을 수 있음
 * - 처음 길이가 L일 때 과일들을 먹어 늘릴 수 있는 최대 길이 구해라
 * 
 * */

public class Main_16435_스네이크버드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과일의 개수
		int L = Integer.parseInt(st.nextToken()); // 스네이크 초기 길이
		
		ArrayList<Integer> fruit = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			fruit.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(fruit);

		for(int f : fruit) {
			if(L>=f) {
				L+=1;
			}
		}
		System.out.println(L);
	}

}
