package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 백준시 
 * - N개의 구역 (1~N)
 * 
 * 구역을 두 개의 선거구로 나누고 둘 중 하나에 포함되어야 함
 * 
 * 선거구는 구역을 적어도 하나 이상 포함해야함
 * 선거구 내의 구역은 모두 연결되어 있어야 함
 * 
 * 구역 A에서 인접한 구역을 통해 구역 B로 갈 수 있을 때
 * -> 두 구역이 연결되었다고 함
 * 
 * 같은 선거구이려면 인접해있어야 함
 * 
 * 
 * 
 * 백준시의 구역이 주어지면 구역들을 반으로 나눠 두 선거구 만들었을 때
 * 두 선거구의 인구 차의 최솟값 출력
 * 
 * ========
 * 구역을 반으로 나누는 경우의 수 모두 구함
 * (단 각 선거구는 인접한 것들 끼리 이루어져야 함)
 *  -> 각 인구 차 구하고 -> 최솟값 갱신
 * 
 * */

public class Main_17471_게리맨더링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static LinkedList<Integer>[] adj;
	static int[] population;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine()); // 구역 수
		adj = new LinkedList[N+1];
		population = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int n=1; n<N+1; n++) { //1~N 구역의 각 인구수 
			population[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int n=0; n<N+1; n++) {
			adj[n] =new LinkedList<>();
		}
		
		for(int n=1; n<N; n++) { //1~N 구역의 각 인접 정보
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int c=0; c<count; c++) {
				int where = Integer.parseInt(st.nextToken());
				adj[n].add(where);
				//adj[where].add(n);
			}
		}
		
		for(int n=1; n<N; n++) { //1~N 구역의 각 인구수 
			System.out.print(n + " : ");
			System.out.println(adj[n].toString());
		}
		
		
	}

}
