package happy_new_year_hw.n21;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt(); //연못 크기 
			int bugs = sc.nextInt(); //소금쟁이 수
			int result = 0; //정답 소금쟁이 번호 
			
			int[] row = new int[bugs];
			int[] col = new int[bugs];
			int[] dir = new int[bugs];
			boolean[][] map = new boolean[N][N]; //점프 확인 false
			
			for(int i=0; i<bugs; i++) {
				row[i] = sc.nextInt(); //2차원 위치 
				col[i] = sc.nextInt(); //2차원 내 1차원 위치 
				dir[i] = sc.nextInt();
			}
		
			breakout:
			for(int bug=0; bug<bugs; bug++) {
				System.out.println(bug);
				if(dir[bug] == 1) { // down
					for(int i=3; i>=1; i--) { // 3 2 1
						if(row[bug]+i < N) { // 점프 가능 시 
							row[bug] = row[bug]+i; //위치 이동  
							if(map[row[bug]][col[bug]]) { //해당 위치가 true
								result = bug+1; //번호는 1부터 시작이므로 +1
								break breakout;
							}
							map[row[bug]][col[bug]] = true;
						}
						else { // 점프 불가 시 그만 이동 
							break;
						}
					}
				}
				else if(dir[bug] == 2) { // right
					for(int i=3; i>=1; i--) { // 3 2 1
						if(col[bug]+i < N) { 
							col[bug]=col[bug]+i; 
							if(map[row[bug]][col[bug]]) { 
								result = bug+1; 
								break breakout;
							}
							map[row[bug]][col[bug]] = true;
						}
						else { 
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
