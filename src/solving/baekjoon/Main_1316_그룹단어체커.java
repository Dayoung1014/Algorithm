package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우
 * 
 * 같은 문자끼리 인덱스가 연속되어 있어야 함
 * */

public class Main_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		int count = 0;
		
		out:
		for (int i = 0; i < N; i++) {
			HashMap<Character, ArrayList<Integer>> dict = new HashMap<>();
			String word = br.readLine();
			
			for (int j = 0; j < word.length(); j++) {
				char w = word.charAt(j);

				if(!dict.containsKey(w)) { // 처음 나온 알파벳
					ArrayList<Integer> list = new ArrayList<>();
					list.add(j);
					dict.put(w, list); 
				}
				else { // 이미 나온 알파벳이라면 제일 최근값과 인덱스 비교
					ArrayList<Integer> idx = dict.get(w);
					if(idx.get(idx.size()-1) + 1 == j) {
						idx.add(j);
						dict.put(null, idx);
					}
					else {
						continue out;
					}
				}
			}
			count++;
		}
		
		System.out.println(count);
		
	}
}
