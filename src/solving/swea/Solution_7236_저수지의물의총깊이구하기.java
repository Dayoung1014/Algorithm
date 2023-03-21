package solving.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N*N 저수지의 물W 깊이를 구하려 함
 * 
 * 물W 깊이
 * - 구획을 둘러싼 W의 개수(주변 G제외, 구획 본인 제외)
 * - 구획을 모두 G가 둘러싸고 있는 경우 = 1
 * 
 * 지역에서 가장 큰 구획(깊은 곳) 값 반환해라
 * 
 * 
 * bfs 돌면서 구획이 == w일때 인접한 곳 체크하기 (8방)
 * */

class Solution_7236_저수지의물의총깊이구하기  {
	static int N;
	static char[][] map;
	static boolean[][] v;
	
	static int result = 1;
	//상하 좌우 상좌 상우 좌하 좌우
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1};
	
	static void bfs(int r, int c) {
		int area = 0;
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
		
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			if(map[nr][nc] == 'G') continue;
			area++;
		}
		if(area > result) result = area;
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			result = 1;
			
			N = Integer.parseInt(br.readLine());
            map = new char[N][N];
           
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

			for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 'W') {
                    	bfs(i, j);
                    	//System.out.println(i+" "+j+" : "+  result);
                    }
                }
            }
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}