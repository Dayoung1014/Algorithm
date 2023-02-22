package solving.swea.n1949;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 등산로 부지 N*N  (숫자는 지형의 높이)
 * 최대한 긴 등산로 만들려함
 * 
 * 등산로 만드는 규칙
 * - 가장 높은 곳에서 시작해야함
 * - 높은 지형 -> 낮은 지형 / 가로 세로만 연결 가능 (높이가 같거나 낮거나 대각선 불가)
 * - 딱 한곳은 최대 K 깊이만큼 지형을 깎을 수 있음
 * 
 * */
class Solution {
	static int N;
	static int K; 
	static int[][] map;
	static ArrayList<int[]> location;
	static int maxLen;
	static boolean cut;
	
	static int[] dx = {-1, 1, 0, 0}; 
	static int[] dy = {0, 0, -1, 1};
	static class Point{
		int x, y, data;

		public Point(int x, int y, int data) {
			super();
			this.x = x;
			this.y = y;
			this.data = data;
		}
	}
	
	static void bfs(int x, int y) {
		int count=0;
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N]; 
		q.offer(new Point(x, y, map[x][y]));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int[] arr = new int[4];
			int min = Integer.MAX_VALUE;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || ny <0 || nx>=N || ny >=N || v[nx][ny] ) arr[i] = -1;
				else {
					arr[i] = map[x][y]-map[nx][ny];
					if(min > arr[i]) min=arr[i];
				}
			}
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(arr[i]==min) q.offer(new Point(nx, ny, map[nx][]));
				break;
			}
			

			
		}
		if(maxLen < count) maxLen = count;
	}
	
	
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			maxLen = 0;
			N = sc.nextInt(); // 한 변 길이
			K = sc.nextInt(); // 공사 가능 깊이
			map = new int[N][N];
			int max = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(max < map[i][j]) max = map[i][j];
				}
			}
			
			location = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == max) location.add(new int[] {i, j});
				}
			}
		
			for(int[] l: location) {
				System.out.println(Arrays.toString(l));
			}
			
			for(int[] l: location) {
				cut = true;
				bfs(l[0], l[1]);
				System.out.println(maxLen);
				System.out.println();
			}
			
			System.out.println(maxLen);
			

		
		}
	}
}