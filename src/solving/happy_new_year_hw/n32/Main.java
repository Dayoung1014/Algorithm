package solving.happy_new_year_hw.n32;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int Y = sc.nextInt(); //2차원 
			int X = sc.nextInt(); //1차원 
			int N = sc.nextInt(); //참가자수 
			int[][] map = new int[Y][X];
			int result = 0; //상
			
			int[] row = new int[N]; //참가자 시작 행 
			int[] col = new int[N]; //참가자 시작 열 
			int[] cnt = new int[N]; //참가자 참여 횟수
			
			for(int i=0; i<Y; i++) { //숫자판 정
				for(int j=0; j<X; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) { //참가자 시작 행, 열, 횟수
				row[i] = sc.nextInt()-1;  
				col[i] = sc.nextInt()-1;
				cnt[i] = sc.nextInt();
			}
			
			int trap = sc.nextInt(); //함정 수
			
			for(int i=0; i<trap; i++) { //함정의 좌표  
				map[sc.nextInt()-1][sc.nextInt()-1] = 0;
			}
			
			// 게임 시작
			for(int i=0; i<N; i++) { //참가자
				boolean success = true;
				int nowPrize = -1000; //현참가자 상금에서 참가비 제외 
				int now = map[row[i]][col[i]];
				//System.out.println("before "+i+"="+now);
				for(int jump=0; jump<cnt[i]; jump++) {
					if(now/10==1) { //right
						if(col[i] + now%10 < X) {
							col[i] = col[i] + now%10;
							now = map[row[i]][col[i]];
							//System.out.println("right");
							if(now==0) {
								//System.out.println("함정");
								success = false;
								break;
							}
						}
						else {
							//System.out.println("경계 벗어남");
							success = false;
							break;
						}
					}
					else if(now/10==2) { //down
						if(row[i] + now%10 < X) {
							row[i] = row[i] + now%10;
							now = map[row[i]][col[i]];
							//System.out.println("down");
							if(now==0) {
								//System.out.println("함정");
								success = false;
								break;
							}
						}
						else {
							//System.out.println("경계 벗어남");
							success = false;
							break;
						}
					}
					else if(now/10==3) { //left
						if(col[i] - now%10 >= 0) {
							col[i] = col[i] - now%10;
							now = map[row[i]][col[i]];
							//System.out.println("left");
							if(now==0) {
								//System.out.println("함정");
								success = false;
								break;
							}
						}
						else {
							//System.out.println("경계 벗어남");
							success = false;
							break;
						}
					}
					else if(now/10==4) { //up
						if(row[i] - now%10 >= 0) {
							row[i] = row[i] - now%10;
							now = map[row[i]][col[i]];
							//System.out.println("up");
							if(now==0) {
								//System.out.println("함정");
								success = false;
								break;
							}
						}
						else {
							//System.out.println("경계 벗어남");
							success = false;
							break;
						}
					}
					//System.out.println(jump+" : "+i+"="+now+" ");
				}
				//System.out.println(success);
				if(success) {
					nowPrize += now*100;
				}
				result += nowPrize;
				//System.out.println(result);
			}
			
			
			System.out.println("#"+test_case+" "+result);
		}
		sc.close();

	}

}
