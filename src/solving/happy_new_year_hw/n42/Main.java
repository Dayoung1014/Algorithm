package solving.happy_new_year_hw.n42;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt(); // 미로 크기 
			int[][] map = new int[N][N];
			int row = sc.nextInt()-1; // 출발 행 
			int col = sc.nextInt()-1; // 출발 열 
			int jumperCnt = sc.nextInt(); // 점퍼 개수 
			for(int i=0; i<jumperCnt; i++) { //점퍼를 -1로 표시 
				map[sc.nextInt()-1][sc.nextInt()-1] = -1;
			}
			int moveCnt = sc.nextInt();
			for(int i=0; i<moveCnt; i++) {
				int dir = sc.nextInt(); //이동 방향 
				int len = sc.nextInt(); //이동 칸수 
				if(dir == 1) { //up
					if(row-len>=0) {
						for(int j=1; j<=len; j++) {
							if(map[row--][col]== -1) {
								row=-1; col=-1; break;
							}	
						}
					}
					else {
						row = -1; col = -1; break;
					}
				}
				else if(dir == 2) { //right
					if(col+len<N) {
						for(int j=1; j<=len; j++) {
							if(map[row][col++]== -1) {
								row=-1; col=-1; break;
							}	
						}
					}
					else {
						row = -1; col = -1; break;
					}
				}
				else if(dir == 3) { //down
					if(row+len<N) {
						for(int j=1; j<=len; j++) {
							if(map[row++][col]== -1) {
								row=-1; col=-1; break;
							}	
						}
					}
					else {
						row = -1; col = -1; break;
					}
				}
				else if(dir == 4) { //left
					if(col-len>=0) {
						for(int j=1; j<=len; j++) {
							if(map[row][col--]== -1) {
								row=-1; col=-1; break;
							}	
						}
					}
					else {
						row = -1; col = -1; break;
					}
				}
			}
			System.out.println("#"+test_case+" "+(row+1)+" "+(col+1));
		}
		sc.close();

	}

}
 