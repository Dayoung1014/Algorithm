package solving.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트 이동 8곳 
// 몇 번 움직이면 이 칸으로 이동 가능한가

public class Main_나이트의이동 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int L;
    static int[] start;
    static int[] finish;
    static int count;
    
    static class Point {
    	int r,c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}


    	
    }
    private static void bfs() {
    	Queue<Point> q=  new LinkedList<>();
    	boolean[][] v = new boolean[L][L];
    	q.add(new Point(start[0], start[1], 0));
    	v[start[0]][start[1]] = true;
    	count = Integer.MAX_VALUE;
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		if(p.r == finish[0] && p.c == finish[1]) {
    			count = Math.min(count, p.cnt);
    		}
    		
    		for(int d=0; d<8; d++) {
        		int nr = p.r + dr[d];
        		int nc = p.c + dc[d];
        		
        		if(nr<0 || nc<0 || nr>=L || nc>= L) continue;
        		if(!v[nr][nc]) {
        			v[nr][nc] = true;
        			q.add(new Point(nr, nc, p.cnt+1));
    
        			//
        		}
        	}
    	}
    
   
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T =Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			L = Integer.parseInt(br.readLine());
			start = new int[2]; 
			finish = new int[2];
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			finish[0] = Integer.parseInt(st.nextToken());
			finish[1] = Integer.parseInt(st.nextToken());
			//System.out.println(start[0]+ " "+start[1]);
			//System.out.println(finish[0]+ " "+finish[1]);
			bfs();
			System.out.println(count);
		}
		
		
		

	}

}
