import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map = new char[5][5];
	
	static int result = 0; //경우의 수
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 1. 25자리 중 7개 뽑기 (자리 번호 조합)
	public static void combi(int[] arr, int[][] select, int count, int idx, int cnt_S, int cnt_Y) { 
		if(count == select.length) {
			if(cnt_S >= 4) { // 2. 7개 중 S가 4개 이상인지 확인
				bfs(select);
			}
			return;
		}
		
		for(int i=idx; i<arr.length;i++) {
			int r = (int) arr[i]/5;
			int c = arr[i]%5;
			
			select[count][0] = r;
			select[count][1] = c;
			
			if(map[r][c]=='S') combi(arr, select, count+1, i+1, cnt_S+1, cnt_Y);
			else combi(arr, select, count+1, i+1, cnt_S, cnt_Y+1);
		}
	}
	
	// 3. 7개가 모두 연결되어 있는지 확인 bfs ( 맨 처음 값만 넣고 모두 방문할 수 있어야 함 )
	static void bfs(int[][] select) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[5][5];
		boolean[] selV = new boolean[7];

		v[select[0][0]][select[0][1]] = true;
		selV[0] = true;
		q.add(new int[] {select[0][0], select[0][1]}); 
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int r = p[0];
			int c = p[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr<0 || nc<0 || nr>= 5 || nc>=5 || v[nr][nc]) continue;
				
				for (int i = 0; i < select.length; i++) {
					if(nr==select[i][0] && nc==select[i][1]) {
						v[nr][nc] = true;
						selV[i] = true;
						q.add(new int[] {nr, nc}); 
					}
				}
			}
		}
		
		int check=0;
		for(boolean s : selV) {
			if(s) check++;
		}
		if(check==7) result++;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int[] arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
		combi(arr, new int[7][2], 0, 0, 0, 0);
		System.out.println(result);
	}
}