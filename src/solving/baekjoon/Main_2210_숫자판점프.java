package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 5*5 크기의 숫자판에 0~9 적혀있음
 * 사방탐색으로 이동하며 (중복 탐색 가능)
 * 숫자를 차례로 붙여서 6자리 수 만들기 
 * 
 * 만들 수 있는 6자리 수의 개수 -> 중복 방지하게 set하기
 * */

public class Main_2210_숫자판점프 {

	static String[][] map;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	static Set<String> set = new HashSet<>();

	static void dfs(int r, int c, String str) {
		if(str.length() == 6) {
			set.add(str);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr<0 || nc<0 || nr>=5 || nc>=5) continue; 
			dfs(nr, nc, str+map[nr][nc]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new String[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, map[i][j]);
			}
		}

		System.out.println(set.size());
	}

}
