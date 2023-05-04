package solving.baekjoon;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays; 
import java.util.StringTokenizer;

/*
 * 암호
 * - L개의 서로 다른 소문자로 구성됨
 * - 최소 한 개의 모음(a, e, i, o, u)
 * - 최소 두 개의 자음
 * - 암호에서 알파벳이 증가하는 순서로 배열됨
 * 
 * ------------------------
 * alpha에서 L개 골라서 
 * 모음 갯수 1개 이상 , 자음 갯수 2개 이상인지 확인해서 출력
 * 
 * algorithm : 조합론
 * start time : 23.05.04 12:00
 * finish time : 23.05.04 12:20
 * */

public class Main_1759_암호만들기 {
	static int L, C;
	static char[] alpha;
	static StringBuilder sb = new StringBuilder(); 
	
	static void combi(char[] select, int count, int idx, int gather, int consonant) {
		if(count==select.length) {
			if(gather>=1 && consonant>=2) {
				for (int i = 0; i < select.length; i++) {
					sb.append(select[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = idx; i < alpha.length; i++) {
			select[count] = alpha[i];
			if(alpha[i]=='a' || alpha[i]=='e' || alpha[i]=='i' || alpha[i]=='o' || alpha[i]=='u') 
				combi(select, count+1, i+1, gather+1, consonant);
			else combi(select, count+1, i+1, gather, consonant+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); //암호의 길이
		C = Integer.parseInt(st.nextToken()); //사용할 수 있는 알파벳의 수
		
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int c = 0; c < C; c++) {
			alpha[c] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha); 
		combi(new char[L], 0, 0, 0, 0);
		System.out.println(sb);
		
	}
}
