package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 영어 소문자만을 기록할 수 있는 편집기
 * 
 * 커서 가능한 위치
 * - 문장의 맨 앞 (첫번째 문자의 왼쪽)
 * - 문장의 맨 뒤 (마지막 문자의 오른쪽)
 * - 문장 중간 임의의 곳 (모든 연속돈 두 문자 사이)
 * 
 * L : 왼쪽으로 한 칸 (맨앞이면 명령 무시)
 * D : 오른쪽으로 한 칸 (맨뒤면 명령 무시)
 * B : 커서 왼쪽의 문자 삭제 (맨앞이면 명령 무시)
 * P $ : 커서 왼쪽에 $라는 문자 추가
 * */

public class Main_1406_에디터2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		int N = str.length();
		LinkedList<Character> list = new LinkedList<>();
		for(int n=0; n<N; n++) {
			list.add(str.charAt(n));
		}
		
		// 명령 수행 전 커서는 문장의 맨뒤에 위치함
		int cursor = N;
		
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			String[] line = br.readLine().split(" ");
			char order = line[0].charAt(0);
			if(order=='L' && cursor>0)  cursor--;

			else if(order=='D' && cursor<N-1)  cursor++;

			else if(order=='B' && cursor>0) {
				list.remove(--cursor);
				//cursor--;
			}
			
			else if(order=='P') {
				char word = line[1].charAt(0);
				//ArrayList<Character> tmp = new ArrayList<>();
//				if(cursor==0) {
//					tmp.add(word);
//					cursor++;
//					tmp.addAll(cursor, list);
//					list = (ArrayList<Character>) tmp.clone();
//				}
//				else {
////					tmp = (ArrayList<Character>) list.clone();
////					cursor++;
////					tmp.add(cursor, word);
////					tmp.addAll(cursor+1, )
////					//cursor++;
//				}
				
				//
				
				list.add(cursor, word);
				cursor++;
				
			}
			System.out.println(cursor);
			System.out.println(list.toString());
		}
		
		

	}



}
