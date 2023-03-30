package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 상향식 : 점화식 (유사한 문제 많이 풀어보며 뽑아내는 능력 키우기)
 * 
 * return식의 재귀로 memo 사용하기
 * -> 상태공간트리 되돌아오면서
 * */

/*
 * 각 칸에 높이가 적혀 있음
 * 칸 사이 이동은 상하좌우 이웃한 곳끼리만 가능
 * 
 * 왼쪽위 -> 오른쪽아래 
 * 높이가 낮은 지점으로만 이동해서 가고자 함
 * 
 * 이렇게 이동할 수 있는 경로의 가지수 구하기
 * 
 * 
 * 상향식 X -> 점화식 불가
 * 재귀 + memo 사용
 * */

/*
 *  시작 지점 [0][0] ~ 끝 지점 [m-1][n-1]로 이동하면서,
경로 개수를 DP 배열에 채워나감
현재 지점 [y][x]가 끝 지점이면, DFS 탐색 종료
현재 보고있는 경로가 이미 끝 지점까지 탐색 완료된 경우 (finished), 더 탐색하지 않고 종료

 * */

public class Main_1520_내리막길 {
	static int M, N;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //세로
		N = Integer.parseInt(st.nextToken()); //가로
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
				dp[m][n] = -1;
			}
		}
		
		dp[M - 1][N - 1] = 1;
		System.out.println(recursive(0, 0));
		
	}
	
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	private static int recursive(int r, int c) {
		if(r==M-1 && c==N-1) return 1; //도착한 경우
	
	
		if(dp[r][c] != -1) {
			return dp[r][c]; //현재 보고있는 경로~끝 지점까지 이미 탐색 완료되었다면 저장된 값 반환
		}
		else dp[r][c]=0;
		
		// 이동 시도
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
		
			if(nr<0 || nc<0 || nr>=M || nc>=N) continue;	 //인덱스 벗어난 경우 
			
			//이동할 수 있다면 
			if(map[nr][nc] < map[r][c]) {
				dp[r][c] += recursive(nr, nc);
			}
		}
		
		return dp[r][c];
	}
}
