package solving.swea;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * BC의 충전 범위 
 * - 주어진 위치값에서 사방으로 +C만큼
 * 
 * 
 * 사용자 A  B의 이동 궤적이 주어짐 
 * 매초마다 특정 BC 충전 범위에 들어오면 해당 BC 접속 가능함
 * 
 * BC는 성능만큼 배터리 충전 가능
 * 여러 사용자가 접속한 경우 균등하게 충전량 분배
 * 
 * 
 *                                            
 * 모든 사용자가 충전한 양의 합의 최대 구하기
 * */

class Solution_5644_무선충전  {
	static boolean[][][] map;
	static int[] dx = {0, -1, 0, 1, 0}; // 이동 X 상 우 하 좌
	static int[] dy = {0, 0,1, 0, -1};
	
	static int M, A;
	static int[] a, b;
	static int[][]  bc;
	
	static int[] aPos;
	static int[] bPos;
	
	static int total; //충전 합

	static void setMap(int x, int y, int c, int num) {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				 if(Math.abs(x-i) + Math.abs(y-j) <= c) map[i][j][num] = true;
			}
		}
	}
	
	static void move() {
		for(int t=0; t<M+1; t++) {
			aPos[0] += dx[a[t]];
			aPos[1] += dy[a[t]];
			
			bPos[0] += dx[b[t]];
			bPos[1] += dy[b[t]];
			
			boolean same=false;
			
			for(int m=0; m<A; m++) {
				if(map[aPos[0]][aPos[1]][m] && map[bPos[0]][bPos[1]][m]) same=true;
			}
			if(!same) { // 다른 구역인 경우
				int amax=0; int bmax=0;
				for(int i=0; i<A; i++) {
					if(map[aPos[0]][aPos[1]][i] && amax < bc[i][3]) amax = bc[i][3];
					if (map[bPos[0]][bPos[1]][i] && bmax < bc[i][3]) bmax = bc[i][3];
				}
				total += amax; total += bmax;
			}
			else { // 같은 구역인 경우
				//겹치는 구역 2곳을 찾아서 각각 더해준것 vs 나눈것 대소 비교
				//나눠가졌을 때
				int max=0;
				int[] sameBc = new int[A];
				int[] aBc = new int[A]; 
				int[] bBc = new int[A];
				
				for(int i=0; i<A; i++) {
					if(map[aPos[0]][aPos[1]][i] && map[bPos[0]][bPos[1]][i] && max < bc[i][3]) max = bc[i][3];
					
					if(map[aPos[0]][aPos[1]][i]) aBc[i] = bc[i][3];
					if(map[bPos[0]][bPos[1]][i]) bBc[i] = bc[i][3];
				} //수정 필요
				Integer sameBcList[] = Arrays.stream(sameBc).boxed().toArray(Integer[]::new); 
				Arrays.sort(sameBcList, Collections.reverseOrder());

				if(max > sameBcList[0]+sameBcList[1]) total+= max;
				else total+= sameBcList[0]; total +=sameBcList[1];
			}
			System.out.print("   :    "+total);
			System.out.println();
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			total = 0; //충전 합 초기화
			
			M = sc.nextInt(); //총 이동 시간
		    A = sc.nextInt(); //BC의 개수
			
			a = new int[M+1]; 
			b = new int[M+1];
			a[0] = 0; b[0]=0; //0초일때 추가 
			
			for(int i=1; i< M+1; i++) {
				a[i] = sc.nextInt();
			}
			for(int i=1; i< M+1; i++) {
				b[i] = sc.nextInt();
			}
	
			bc = new int[A][4];
			// 일단 map 먼저 설정
			map = new boolean[10][10][A];
			
			for(int i=0; i<  A; i++) {
				bc[i][0] = sc.nextInt()-1; // 위치 Y
				bc[i][1] = sc.nextInt()-1; //위치  X
				bc[i][2] = sc.nextInt(); // 충전 범위
				bc[i][3] = sc.nextInt(); //성능
				map[bc[i][0]][bc[i][1]][i] = true;
				setMap(bc[i][0], bc[i][1], bc[i][2], i);
			}
			
//			for(int i=0; i<10; i++) {
//				for(int j=0; j<10; j++) {
//					System.out.print(Arrays.toString(map[i][j]) + "	");
//				}
//				System.out.println();
//			}
			
			// 시작 위치 설정
			aPos = new int[] {0,0}; 
			bPos = new int[] {9, 9};
			
			move();
			System.out.println("#"+test_case+" "+total);
		}
	}
}