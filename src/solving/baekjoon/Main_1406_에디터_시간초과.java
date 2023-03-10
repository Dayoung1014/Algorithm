package solving.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/*
 * ArrayList
 * - 기본 add : O(1)
 * - 인덱스 add : O(n)
 * - 인덱스 remove : O(n)
 * - 검색 : O(1)
 * 
 * LinkedList 
 * - 기본 add : O(1)
 * - 기본 remove : O(1)
 * - 인덱스 add : O(n)
 * - 인덱스 remove : O(n)
 * - 검색 : O(n)
 * */

public class Main_1406_에디터_시간초과 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int N = str.length();
		
		LinkedList<Character> list = new LinkedList<>();
		
		for(int n=0; n<N; n++) {
			list.add(str.charAt(n));
		}
		
		int cursor = list.size(); // 명령 수행 전 커서는 문장의 맨뒤에 위치함
		
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			String line = br.readLine();
			char order = line.charAt(0);
			
			if(order=='L' && cursor>0)  cursor-=1;
			
			else if(order=='D' && cursor<list.size())  cursor+=1;
			
			else if(order=='B' && cursor>0) list.remove(--cursor);

			else if(order=='P') {
				char word = line.charAt(2);
				list.add(cursor, word);
				cursor++;
			}
		}
		
		for(Character chr : list) {
			bw.write(chr);
		}
		bw.flush();
		bw.close();
	}



}
