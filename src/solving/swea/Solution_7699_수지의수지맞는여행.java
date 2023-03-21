package solving.swea;

/*
 * 섬 : 1행 1열 ~ R행 C열 (R*C)
 *
 * 시작 지점 : 1행 1열
 *
 * 명물
 * - 각 칸에 알파벳으로 적힘 (각은 알파벳은 같은 명물)
 *
 * 수지의 목표
 * - 1행 1열에서 여행 시작
 * - 같은 알파벳 명물을 두 번 이상 보지 않도록
 * -> 명물의 최대 개수 구하기
 *
 * */

import java.util.Scanner;


class Solution_7699_수지의수지맞는여행  {
	static int R;
	static int C;
	static char[][] map;
	static boolean[] alpha;
	static boolean[][] visited;
	static int maxCnt;


	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];

			for(int r=0; r<R; r++) { //지도 입력 받기
				String str = sc.next();
				for(int c=0; c<C; c++) {
					map[r][c] = str.charAt(c);
				}
			}

			maxCnt = 0;
			visited = new boolean[R][C];
			alpha = new boolean[26];
			dfs(0,0, 0);
			System.out.println("#"+test_case+" "+maxCnt);

		}
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	public static void dfs(int x, int y, int count) {
		//System.out.println(maxCnt);
		for (int i = 0; i < 4; i++) {
			if(x>=0 && x<R && y>=0 && y<C && !alpha[map[x][y]-'A'] && !visited[x][y]) {
				//System.out.println("in");
				alpha[map[x][y]-'A'] = true;
				visited[x][y] = true;
				dfs(x+dr[i], y+dc[i], count+1);
				alpha[map[x][y]-'A'] = false;
				visited[x][y] = false;
			}
			else {
				if(count > maxCnt) {
					maxCnt = count;
					return;
				}
			}
		}



	}


}