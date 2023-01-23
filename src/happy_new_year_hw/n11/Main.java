package happy_new_year_hw.n11;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int cnt = 0;
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) { //S(공백) W(벽) ABC(로봇)
				for(int j=0; j<N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 'A') { // 우 
						cnt += right(map, i, j, N);
					}
					else if(map[i][j] == 'B') { // 좌 우 
						cnt += left(map, i, j, N);
						cnt += right(map, i, j, N);			
					}
					else if(map[i][j] == 'C') { // 좌 우 상 하 
						cnt += left(map, i, j, N);
						cnt += right(map, i, j, N);		
						cnt += top(map, i, j, N);
						cnt += down(map, i, j, N);
					}
				}
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}
	
	static int right(char[][] map, int i, int j, int N) {
		int tmp = 0;
		for(int t=j+1; t<N; t++) {
			if(map[i][t]=='W' || map[i][t]=='A' || map[i][t]=='B' || map[i][t]=='C') {
				break;
			}
			else {
				tmp++;
			}
		}
		return tmp;
	}
	
	static int left(char[][] map, int i, int j, int N) {
		int tmp = 0;
		for(int t=j-1; t>=0; t--) {
			if(map[i][t]=='W' || map[i][t]=='A' || map[i][t]=='B' || map[i][t]=='C') {
				break;
			}
			else {
				tmp++;
			}
		}
		return tmp;
	}

	static int top(char[][] map, int i, int j, int N) {
		int tmp = 0;
		for(int top=i-1; top>=0; top--) { // 
			if(map[top][j]=='W' || map[top][j]=='A' || map[top][j]=='B' || map[top][j]=='C') {
				break;
			}
			else {
				tmp++;
			}
		}
		return tmp;
	}
	static int down(char[][] map, int i, int j, int N) {
		int tmp = 0;
		for(int donw=i+1; donw<N; donw++) { // 
			if(map[donw][j]=='W' || map[donw][j]=='A' || map[donw][j]=='B' || map[donw][j]=='C') {
				break;
			}
			else {
				tmp++;
			}
		}
		return tmp;
	}
}
