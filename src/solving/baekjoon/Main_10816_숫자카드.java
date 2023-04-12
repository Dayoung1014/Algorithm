package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * JAVA Collection 시간 복잡도
 * 참고 https://www.grepiu.com/post/9
 * */

public class Main_10816_숫자카드 {
	 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(!map.containsKey(card)) { //containsKey   : O(1)
    			map.put(card, 1);
    		}
    		else {
    			map.put(card, map.get(card) + 1);
    		}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
    		if(map.containsKey(num)) {
    			sb.append(map.get(num) + " ");
    		}
    		
    		else {
    			sb.append(0 + " ");
    		}
		}
		
		System.out.println(sb);
	}
}
