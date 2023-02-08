package baekjoon.n11660;

import java.util.Arrays;
import java.util.Scanner;

/*
 * (x1, y1)부터 (x2, y2)까지 합 구하기
 * 각 구간도 포함해서 구해야함
 * 행, 열 번호가 1부터 시작함에 주의
 * 
 * arr : 가로세로 모두 누적합
 * arrH : 세로만 누적합
 * arr(x2, y2) - arr(x2, y1) - arrH(x1, y2) + arr(x1, y1)
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //표의 크기
		int M = sc.nextInt(); //합을 구하는 횟수
		int[][] arr = new int[N][N]; // 전체 누적합
		int[][] arrH = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==0&j==0) {
					int first = sc.nextInt();
					arr[0][0] = first; 
					arrH[0][0] = first;
				}
				else if(i==0) {
					int now = sc.nextInt();
					arr[i][j] = arr[i][j-1] + now; //전의 누적값과 더해줌
					arrH[i][j] = now;
				}
				else if(j==0) {
					int now = sc.nextInt();
					arr[i][j] = arr[i-1][N-1] + now; //위의 줄 마지막 누적값과 더해줌
					arrH[i][j] = arrH[i-1][j] + now;
				}
				else if(i==N-1) {
					int now = sc.nextInt();
					arr[i][j] = arr[i][j-1] + now; //전의 누적값과 더해줌
					arrH[i][j] = arrH[i-1][j] + now;
				}
				else {
					int now = sc.nextInt();
					arr[i][j] = arr[i][j-1] + now; //전의 누적값과 더해줌
					arrH[i][j] = arrH[i-1][j] + now;
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(arrH[i]));
		}
		for(int i=0; i<M; i++) {
			int x1 = sc.nextInt()-1;
			int y1 = sc.nextInt()-1;
			int x2 = sc.nextInt()-1;
			int y2 = sc.nextInt()-1;
			//arr(x2, y2) - arr(x2, y1) - arrH(x1, y2) + arr(x1, y1)
			//System.out.println(arr[x2][y2] - arr[x2][y1] - arrH[x1][y2] + arr[x1][y1]);
			//arr(x2, y2) - arrH(x2+1, y2-1) - arr(x2, y1) - arrH(x1-1, y2) + arr(x1, y1)
			System.out.println(arr[x2][y2] - arrH[x2+1][y2-1] - arr[x2][y1] - arrH[x1-1][y2]+ arr[x1][y1]);
		}
	}

}
