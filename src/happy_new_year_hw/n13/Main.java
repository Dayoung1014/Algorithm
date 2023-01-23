package happy_new_year_hw.n13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int maxHeight = 0;
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int height = 0;
				
					if(map[i][j]=='B') {
						// 좌 우 상 하 좌하 좌상 우하 우상 
						if((j>0 && map[i][j-1] =='G') || (j<N-1 && map[i][j+1] == 'G') 
								|| (i>0 && map[i-1][j] =='G') || (i<N-1 && map[i+1][j] =='G') 
								|| (i<N-1 && j>0 && map[i+1][j-1]=='G') || (i>0 && j>0 && map[i-1][j-1]=='G') 
								|| (i>0 && j<N-1 && map[i-1][j+1]=='G') || (i<N-1 && j<N-1 && map[i+1][j+1]=='G')) { 
							height = 2;
						}
						else { 
							height--; //현 위치의 B
							for(int row =0; row<N; row++) {
								if(map[i][row]=='B') {
									height++;
								}
							}
							for(int col =0; col<N; col++) {
								if(map[col][j]=='B') {
									height++;
								}
							}
						}	
					}
					if(height > maxHeight) {
						maxHeight = height;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+maxHeight);
		}
		sc.close();
	}
}
