package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문자열 S, 특정 알파벳 a, 문자열 구간 l, r
 * S의 l번째 문자 ~ r번째 문자 사이에 a가 몇 번 나타나는가
 * 부분성공 -> 효율적인 방법 찾아보기
 * */

public class Ing_Main_16139 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String S = br.readLine(); //문자열
		int q = Integer.parseInt(br.readLine()); //질문의 수
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0); // 알파벳
			int l = Integer.parseInt(st.nextToken()); //왼쪽 번째
			int r = Integer.parseInt(st.nextToken()); //오른쪽 번째
			
			int cnt=0;
			for (int idx = l; idx <= r; idx++) {
				if(S.charAt(idx)==a) cnt++;
			}
			System.out.println(cnt);
		}
	}
}
