package solving.hw;

import java.util.Scanner;

public class 등산로 {

	static int T, N, K;
	static int [][] map;
	static int hight;
	static int length;
	static boolean[][] visited;
	static int [] dr= {-1,0,1, 0};
	static int [] dc= { 0,1,0,-1};// 상우하좌
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			K=sc.nextInt();
			map=new int[N][N];
			visited=new boolean[N][N];
			hight=-100;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
					hight=Math.max(hight, map[i][j]);
				}
			}
			length=-1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==hight) { // 가장 높은곳에서 시작한다.
						dfs(i,j, 1, false); //  길이 ,산을 깎은 적이 없다.
					}
				}
			}
			System.out.println("#"+t+" "+length);
		}

	}

	static void dfs(int r, int c, int cnt, boolean usingK) {
		visited[r][c]=true;
		length=Math.max(length, cnt);
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc))continue;
			if(visited[nr][nc])continue;
			if(map[nr][nc]<map[r][c]) {  
				dfs(nr,nc, cnt+1, usingK);
			}else {
				if(!usingK) {  //깎은 적없다.
					for (int k = 1; k <= K; k++) {
						if(map[nr][nc]-k<map[r][c] ) {  
							map[nr][nc]-=k; // 백트랙킹
							dfs(nr,nc, cnt+1, true);
							map[nr][nc]+= k; // 백트랙킹
						}
					}
				}
			}
		}
		//---- 백트랙킹
		visited[r][c]=false;
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}