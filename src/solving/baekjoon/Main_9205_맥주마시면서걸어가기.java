package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 상근이네 집 -> 락페
 * 맥주 한박스(20병) 들고 출발
 * 50m에 한 병씩 마셔야 함(50m 가려면 그 전에 맥주 한 병 마셔야 함)
 * 
 * 가다가 편의점 들릴 수 있음
 * - 빈 병 버리고 새 맥주 병 살 수 있음
 * - 단 들고있는 병수가 20병을 넘을 수 없다.
 * 
 * 좌표 사이 거리 : x의 차 + y의 차
 * 
 * 
 * -----
 * 편의점 몇 개 들리든 상관 없음
 * dfs로 모든 경로 완탐하면서 하나라도 성공하면 happy
 * 다 돌았는데 못한다면 sad
 * 
 * 현재 위치에서 가까운 순으로 가서 맥주 채우면 됨...
 * 
 * 틀린 코드임
 * */

public class Main_9205_맥주마시면서걸어가기 {	
	static int store_cnt;
	static int[] start, end;
	static int[][] store;
	
	static int beer;
	
	static boolean[] visited;
	
	static boolean finish;
	
	static void move(int n) { //현재 위치
		//System.out.println(n+"방문");
		visited[n] = true; //현재 위치 방문 완료
		beer = 20; //맥주 충전

		if(check(store[n][0], store[n][1])) { //현재 위치에서 end로 갈 수 있는 경우
			finish=true;
			return;
		}
		
		int near = Integer.MAX_VALUE; //현재 위치에서 가까운 편의점 번호 저장
		int nearDist = 0; //현재 위치에서 가까운 편의점과의 거리
		for (int i = 0; i < store_cnt+1; i++) {
			//System.out.println(i);
			if(visited[i]) continue;
			int dist = Math.abs(store[i][0]-store[n][0]) + Math.abs(store[i][1]-store[n][1]); 
			//System.out.println(i+"번째 편의점 "+dist);
			if(near > dist) {  //몇 번째 store인지 저장(가까운 store저장)
				near=i;
				nearDist = dist;
			}
		}
		
		beer -= (int) Math.ceil(nearDist/50);
		if(beer < 0) { //가장 가까운 편의점 방문 전 맥주 다 떨어지는 경우 
			finish = false;
			return;
		} 
		move(near); //가장 가까운 편의점을 방문하기
	}
	
	static boolean check(int nowX, int nowY) { //현재 위치에서 현재 맥주로 도착 가능한지
		int dist = end[0]-nowX + end[1]-nowY;
		if(dist/50 <= beer) return true;
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			beer = 20;
			
			store_cnt = Integer.parseInt(br.readLine()); //편의점 개수
			
			store = new int[store_cnt+1][2];
			
			for (int i = 0; i < store_cnt+1; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken()); // x좌표
				store[i][1] = Integer.parseInt(st.nextToken()); // y좌표
			}
			
			st = new StringTokenizer(br.readLine());
			end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
	
			finish = false;
			visited = new boolean[store_cnt+1];
			move(0);
			
			if(finish) System.out.println("happy"); 
			else System.out.println("sad"); 
		}
	}

}
