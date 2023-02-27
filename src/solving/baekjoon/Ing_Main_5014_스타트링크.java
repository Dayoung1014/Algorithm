package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * F층으로 이루어진 건물
 * 스타트링크는 G층
 * 
 * 엘리베이터 버튼 U( 위로  U층 ) / D( 아래로 D층 ) -> 해당하는 층 없으면 움직이지 않음
 * 
 * */


public class Ing_Main_5014_스타트링크 {
	static int F, S, G, U, D;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int result = 0;
	
	private static int elivator(int now, int count) {
		System.out.println("now : "+ now + " cont : "+count);
		if(now == G) return count;
		
		if(now - D >= 1) {
			elivator(now-D, count+1);
		}
		else return -1;
		
		if(now + U <= F) {
			elivator(now+U, count+1);
		}
		else return -1;


	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 건물 총 층수
		S= Integer.parseInt(st.nextToken()); // 현재 위치 층
		G = Integer.parseInt(st.nextToken()); //목적지 층
		U = Integer.parseInt(st.nextToken()); //위로 U칸 버튼
		D = Integer.parseInt(st.nextToken()); //위로 D칸 버튼
		
		if(S == G) System.out.println(0);
		else {
			result = elivator(S, 0);
		}
		System.out.println(result);
	}

}
