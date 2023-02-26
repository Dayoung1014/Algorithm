package solving.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 다른 섬과의 다리를 가장 짧게 놓으려 함
 * 섬 : 4방으로 육지인 곳
 * 
 * 1. 섬 별로 숫자 다르게 두기
 * 2. 한 숫자에서 시작해서 다른 숫자로 끝나는 다리 중 가장 짧은 길이 구하기 
 * 2-1. 구한 뒤 (숫자 부분 길이 2 빼야함)
 * 
 * 길이 반환
 * 
 * 몇개의 섬인지 먼저 구한 후
 * map배열을 해당 섬 길이로 변경 
 * */

public class Ing_Main_다리만들기2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int number;
    static int cnt;
    static int len;
    static boolean[][] visited;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Point {
    	int r, c, area;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int area) {
			super();
			this.r = r;
			this.c = c;
			this.area = area;
		}

    	

    }
    
    // 섬 개수 구하기 & 섬별로 넘버링하기
    private static void map_set(int r, int c, int number) {
    	Queue<Point> q = new LinkedList<>();
    	boolean[][] v = new boolean[N][N];
    	
    	q.offer(new Point(r, c));
    	v[r][c] = true;
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
        	for(int d=0; d<4; d++) {
        		
        		map[p.r][p.c] = number;
        		int nr = p.r + dr[d];
        		int nc = p.c + dc[d];
        		
        		if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc]) continue;
        		if(map[nr][nc]==1) {
        			v[nr][nc] = true;
        			q.offer(new Point(nr, nc));
        		}
        	}
    	}

    }
     
   
    //finish가 0이 아니고 start와 다른 숫자여야 함
    private static void bfs(int r, int c, int start) {
    	//System.out.println(" / "  +r + " " +c);
    	Queue<Point> q = new LinkedList<>();
    	boolean[][] v = new boolean[N][N];
    	
    	q.offer(new Point(r, c, 1));
    	v[r][c] = true;
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		if(map[p.r][p.c] != start && map[p.r][p.c] != 0 ) { //
    			//System.out.println(start + " / " + p.r + " " +p.c);
    			//System.out.println("len : "+ (p.area-2));
    			//System.out.println();
    			len = Math.min(len, p.area-2);
    			return;
    		}
    		
        	for(int d=0; d<4; d++) {
        		int nr = p.r + dr[d];
        		int nc = p.c + dc[d];
        		
        		if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc]) continue;
        		if(map[nr][nc]!=start) {
        			//System.out.println(nr + " " + nc);
        			v[nr][nc] = true;
        			q.offer(new Point(nr, nc, p.area+1));
        		}
    			
        	}
    	}

    }
    
	public static void main(String args[]) throws Exception {
		N= Integer.parseInt(br.readLine()); 
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0; number = 2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					map_set(i, j, number++);
				}
			}
		}
		
		len = Integer.MAX_VALUE;
		
		
		for(int island=2; island<2+cnt; island++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == island) {
						bfs(i, j, island);
						//System.out.println();
						//System.out.println();
					}
				}
			}
		}
		
		
		
		
		System.out.println(len);
		
	}

}
