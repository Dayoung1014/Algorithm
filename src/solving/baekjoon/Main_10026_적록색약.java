package solving.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 적록색약 : 빨 / 초 차이를 못느낌
 * 
 * 각 칸에 R G B 하나를 칠한 그림이 있음
 * 
 * 그림은 구역 별로 같은 그림으로 이루어져 있음
 * 
 * 
 * 일반인 R/ G /B 구역 구하기 
 * 
 * 적록색약 R+G /B 구역 구하기 
 * 
 * */


public class Main_10026_적록색약 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static Character[][] map1;
    static Character[][] map2;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int res1=0;
    static int res2=0;
    
    static class Point {
    	int r, c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
    }
    
    private static void bfs_normal(int r, int c, Character color) {
    	Queue<Point> q = new LinkedList<>();
    	boolean[][] v = new boolean[N][N];
    	
    	q.add(new Point(r, c));
    	v[r][c] = true;
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		map1[p.r][p.c] = ' ';
    		for(int i=0; i<4; i++) {
    			int nr = p.r + dr[i];
    			int nc = p.c + dc[i];
    			
    			if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc] || color!=map1[nr][nc]) continue;
    			v[nr][nc] = true;
    			q.add(new Point(nr, nc));
    		}
    	}
    	
    }
    
    private static void bfs_weakness(int r, int c, Character color) {
    	Queue<Point> q = new LinkedList<>();
    	boolean[][] v = new boolean[N][N];
    	
    	q.add(new Point(r, c));
    	v[r][c] = true;
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		map2[p.r][p.c] = ' ';
    		for(int i=0; i<4; i++) {
    			int nr = p.r + dr[i];
    			int nc = p.c + dc[i];
    			
    			if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc]) continue;
    			if((color == map2[nr][nc]) 
    					|| (color == 'G' && map2[nr][nc]=='R')
    					|| (color == 'R' && map2[nr][nc]=='G')) {
        			v[nr][nc] = true;
        			q.add(new Point(nr, nc));
    			}

    		}
    	}
    	
    }
    
	public static void main(String args[]) throws Exception {
		N= Integer.parseInt(br.readLine()); 
		map1 = new Character[N][N];
		map2 = new Character[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map1[i][j] = str.charAt(j);
				map2[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Character color1 =map1[i][j];
				Character color2 =map2[i][j];
				if(color1!=' ') {
					res1++;
					bfs_normal(i, j, color1);
				}
				if(color2!=' ') {
					res2++;
					bfs_weakness(i, j, color2);
				}
			}
		}
		
		System.out.print(res1 + " ");
		System.out.println(res2);
		
	}

}
