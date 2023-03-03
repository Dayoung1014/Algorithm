package solving.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 프로세서 
 * - N*N (1~N) 
 * - 가장 자리에 전원 흐르고 있음 (가장자리의 core는 전선 없어도 연결됨)
 * - core와 전원을 연결하는 전선은 직선으로만 설치 가능
 * - 전선은 교차 불가
 * 
 * 
 * cell 
 * - 각 칸을 의미
 * - 1개의 core / 전선이 올 수 있다.
 * 
 * 
 * 최대한 많은 core연결, 전선 길이 합이 최소가 될때 -> 길이 합 구하기
 * 0은 빈셀 
 * 1은 코어있는셀
 * 
 * */

public class Solution_1767_프로세서연결하기 {
	static int N;
	static int[][] map;
	
	static int maxCnt = Integer.MIN_VALUE; // 최대연결개수 저장
	static int minLen = Integer.MAX_VALUE; // 최대연결개수가 같을 때 적은 길이 저장
	
	private static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			print();
		}
	}
}
