package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

public class Main_16919_봄버맨2 {
	static int R, C, N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //R * C
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //N초뒤
		map = new int[R][C];
		
		//1. 가장 처음 봄버맨이 폭탄 설치 
		for (int i = 0; i < R; i++) { 
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j) != '.') map[i][j] = 3;
			}
		}
		
		if(N%2 ==0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 0) map[i][j] = N+3;
				}
			}
		}
		else {
			for (int n = 2; n <= N; n++) {
                N = N % 4 + 4;
                // 폭탄 설치
                if (n % 2 == 0) {
                	for (int i = 0; i < R; i++) {
        				for (int j = 0; j < C; j++) {
        					if(map[i][j] == 0) map[i][j] = n+3;
        				}
        			}
                } 
                else {
                	for (int i = 0; i < R; i++) {
    					for (int j = 0; j < C; j++) {
    						if(map[i][j] == n) {
    							map[i][j] = 0;
    							for (int d = 0; d < 4; d++) {
    								int nr = i +dr[d];
    								int nc =j +dc[d];
    								if(nr<0 || nc<0 || nr>=R || nc>=C  || map[nr][nc] == n) continue;
    								map[nr][nc] = 0;
    							}
    						}
    					}
    				} 
                }
            }
		}
		
		//출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 0) System.out.print(".");
				else System.out.print("O");
			}
			System.out.println();
		}
	}
}
