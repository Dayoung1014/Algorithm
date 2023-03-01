package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17471_게리맨더링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 지역 개수
	static ArrayList<Integer>[] adj; // 연결리스트
	static int[] population; // 지역별 인구수 저장
	static int[] areaNum; // 부분집합 구하기 위한 지역 번호 저장
	static int minResult; // 인구 차 min

	public static void subset_area(boolean[] sel, int cnt, int idx) {
		if(idx==areaNum.length) {
			if(cnt!=0 && cnt!=N) { //공집합 & 전체 아닌 경우에만
				ArrayList<Integer> area1 = new ArrayList<>();
				ArrayList<Integer> area2 = new ArrayList<>();
				for(int i=0; i<sel.length; i++) { // list에 부분집합 true / false 선거구 각 저장
					if(sel[i]) area1.add(areaNum[i]);
					else area2.add(areaNum[i]);
				}
				if(check(area1) && check(area2)) { // 두 선거구가 각 이어져 있는지 확인
					int aCnt=0;
					for(int i=0; i<area1.size(); i++) { // 인구수 확인
						aCnt += population[area1.get(i)];
					}
					int bCnt=0;
					for(int i=0; i<area2.size(); i++) { // 인구수 계산
						bCnt += population[area2.get(i)];
					}
					minResult = Math.min(minResult,  Math.abs(aCnt-bCnt));
				}
			}
			return;
		}

		// 부분집합 담는 경우
		sel[idx] = true;
		subset_area(sel, cnt+1, idx+1);

		// 부분집합 안담는 경우
		sel[idx] = false;
		subset_area(sel, cnt, idx+1);
	}

	private static boolean check(List<Integer> list) { // 선거구 안에서 연결되어 있는지 확인
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N]; // 0~N 지역 방문 여부
		visited[list.get(0)] = true; // 처음꺼부터 방문 시작해도 모두 방문할 수 있어야 함
		q.offer(list.get(0));
		int count = 1; // 방문한 지역 개수

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < adj[now].size(); i++) {
				int next = adj[now].get(i); // now지역과 연결된 지역
				if(list.contains(next) && !visited[next]) { // 뽑은 선거구에 포함 & 미방문 (연결되었더라도 list에 포함되어있지 않다면 넣지 않아야 함)
					q.offer(next);
					visited[next] = true;
					count ++;
				}
			}
		}
		if(count==list.size()) // 뽑은 선거구 지역 수 == 방문한 지역수
			return true;
		else
			return false;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine()); // 구역 수

		adj = new ArrayList[N]; // 인접리스트
		population = new int[N]; // 인구수 저장
		areaNum = new int[N]; // 부분집합 구하기 위해 지역 번호 arr

		st = new StringTokenizer(br.readLine());  //1~N 구역의 각 인구수
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken()); // 지역별 인구수 저장
			areaNum[i] = i; // 지역 번호 저장
		}

		for(int n=0; n<N; n++) { //1~N 구역의 각 인접 정보
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int c=0; c<count; c++) {
				int where = Integer.parseInt(st.nextToken()) - 1; //지역 번호 변경해도 문제에서는 상관 x-> 1씩 줄여서 저장
				adj[n].add(where);
			}
		}

		minResult = Integer.MAX_VALUE;
		subset_area(new boolean[areaNum.length], 0, 0);

		if(minResult==Integer.MAX_VALUE) System.out.println(-1); // 두 선거구로 나눌 방법이 없는 경우
		else System.out.println(minResult); // 있는 경우 차가 가장 적은 방법
	}

}
