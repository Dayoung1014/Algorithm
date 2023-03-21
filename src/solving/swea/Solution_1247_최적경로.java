package solving.swea;

import java.util.Arrays;

/*
 * 회사 -> N명의 고객 모두 방문 -> 집
 * 각 위치는 2차원 정수 좌표로 주어짐
 * 두 위치 사이 거리 :  |x1-x2| + |y1-y2|
 * 
 * 가장 짧은 경로의 이동 거리
 * */

import java.util.Scanner;

class Solution_1247_최적경로 {
	
	static int [] output; // 뽑은 순열
	static boolean[] visited; // 방문 여부
	static int min;
	static int N;
	static int[] company;
	static int[] home;
	static int[][] arr;
	public static void recur(int[] output, boolean[] visited, int count, int n) { //뽑은거 / 방문확인/ 뽑은수 / 고객수
	    if (count == n) {
	    	//System.out.println(Arrays.toString(output));
	    	// output 돌면서 거리 구해서 min 갱신
	    	int sum = 0;
	    	sum += Math.abs(company[0]-arr[output[0]][0]);
	    	sum += Math.abs(company[1]-arr[output[0]][1]);
	    	//System.out.println(sum);
	    	for(int idx=0; idx<=N-2; idx++) { //1~
	    		sum += Math.abs(arr[output[idx]][0]-arr[output[idx+1]][0]);
	    		sum += Math.abs(arr[output[idx]][1]-arr[output[idx+1]][1]);
	    		//System.out.println(sum);
	    	}
	    	sum += Math.abs(home[0]-arr[output[N-1]][0]);
	    	sum += Math.abs(home[1]-arr[output[N-1]][1]);
	    	//System.out.println(sum);
	    	if(min > sum) {
	    		min = sum;
	    	}
	        return;
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[count] =i;
	            recur(output, visited, count + 1, n);
	            visited[i] = false;
	        }
	    }

	}
	
	public static void main(String args[]) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			min = Integer.MAX_VALUE;
			N = sc.nextInt(); // 고객의 수
			company = new int[2]; // 회사
			home = new int[2]; // 집
			arr = new int[N][2]; // 고객
			for(int i=0; i<N+2; i++) {
				if(i==0) {
					company[0] = sc.nextInt();
					company[1] = sc.nextInt();
				}
				else if(i==1) {
					home[0] = sc.nextInt();
					home[1] = sc.nextInt();
				}
				else {
					arr[i-2][0] = sc.nextInt();
					arr[i-2][1] = sc.nextInt();
				}
			}
			
			// 회사와 집  순서는 고정
			// 고객 좌표의 순열 (N개 중 N개) 다 구해서
			// 각자 돌면서 길이 구래서 최단 경로 찾기
			output = new int[N];
			visited = new boolean[N];
			recur(output, visited, 0, N);
			System.out.println("#"+test_case+" "+min);
		
		}
	}
	
	

}