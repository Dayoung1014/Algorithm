package happy_new_year_hw.n22;

import java.util.Scanner;

// 연못 밖으로 나가면 죽음
// 도착 시 이미 다른 소금쟁이가 있다면 죽음
// 시작 시 이미 다른 소금쟁이가 있다면 죽음

// 방향 (1:상 2:하 3:좌 4:우)


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt(); //연못 크기 
			int bugs = sc.nextInt(); //소금쟁이 수
			int result = bugs; //살아있는 소금쟁이 수  
			
			int[] row = new int[bugs];
			int[] col = new int[bugs];
			int[] dir = new int[bugs];
			boolean[][] map = new boolean[N][N]; //소금쟁이 유무 
			
			for(int i=0; i<bugs; i++) {
				row[i] = sc.nextInt(); //2차원 위치 
				col[i] = sc.nextInt(); //2차원 내 1차원 위치 
				dir[i] = sc.nextInt();
				map[row[i]][col[i]] = true;
			}
			
			for(int bug=0; bug<bugs; bug++) {
				if(dir[bug] == 1) { // up
					for(int i=3; i>=1; i--) { // 3 2 1
						if(row[bug]-i >= 0) { // 점프 가능 시 
							map[row[bug]][col[bug]] = false;
							row[bug] = row[bug]-i; //위치 이동 
							if(map[row[bug]][col[bug]]) { //해당 위치에 소금쟁이 있으면 
								result--; //소금쟁이 죽음 
								break;
							}
							map[row[bug]][col[bug]] = true;
						}
						else { // 점프 불가 시 
							result--; //소금쟁이 죽
							break;
						}
					}
				}
				else if(dir[bug] == 2) { // down
					for(int i=3; i>=1; i--) { 
						if(row[bug]+i < N) { 
							map[row[bug]][col[bug]] = false;
							row[bug] = row[bug]+i;  
							if(map[row[bug]][col[bug]]) { 
								result--; 
								break;
							}
							map[row[bug]][col[bug]] = true;
						}
						else { 
							result--; 
							break;
						}
					}
				}
				else if(dir[bug] == 3) { // left
					for(int i=3; i>=1; i--) { 
						if(col[bug]-i >= 0) { 
							map[row[bug]][col[bug]] = false;
							col[bug]=col[bug]-i; 
							if(map[row[bug]][col[bug]]) { 
								result--;
								break;
							}
							map[row[bug]][col[bug]] = true;
						}
						else { 
							result--;
							break;
						}
					}
				}
				else if(dir[bug] == 4) { // right
					for(int i=3; i>=1; i--) { 
						if(col[bug]+i < N) { 
							map[row[bug]][col[bug]] = false;
							col[bug]=col[bug]+i; 
							if(map[row[bug]][col[bug]]) { 
								result--;
								break;
							}
							map[row[bug]][col[bug]] = true;
						}
						else { 
							result--;
							break;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
		sc.close();

	}

}
