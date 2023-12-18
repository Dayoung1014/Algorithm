import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer; 

public class Main {

	static class Road {
		int finish, time;

		public Road(int finish, int time) {
			super();
			this.finish = finish;
			this.time = time;
		}
	}
	static int N, M, X, min;
	static ArrayList<Road>[] arr;
	
	static void go(int start, int finish) {
		min = Integer.MAX_VALUE; // 경로 최소값 갱신
		
		Queue<Road> q = new LinkedList<>();
		int[] dist = new int[N+1]; //index까지 가는 최소값
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		for(Road next : arr[start]) {
			dist[next.finish] = next.time;
			q.add(new Road(next.finish, next.time));
		}
		
		while(!q.isEmpty()) {
			Road now = q.poll();
			if(now.finish == finish) {
				min = Math.min(min, now.time);
				continue;
			}
			
			for(Road next : arr[now.finish]) {
				if(dist[next.finish] < now.time+next.time) continue;
				
				dist[next.finish] = now.time+next.time;
				q.add(new Road(next.finish, now.time+next.time));
			}
			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 (마을 수)
		M = Integer.parseInt(st.nextToken()); // 도로 수
		X = Integer.parseInt(st.nextToken()); // 파티 장소
		
		arr = new ArrayList[N+1]; //0 비우기
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			arr[start].add(new Road(finish, time));
		}
		
		ArrayList<Integer> result = new ArrayList<>(); // 0비우고 사용 (학생별 최단 시간 저장)
		 
		for (int i = 1; i <= N; i++) {
			if(i==X) {
				result.add(0);
				continue;
			}
			int sum = 0;
			//각 학생이 본인 마을에서 X까지 가는 최단거리
			go(i, X);
			sum = min;
			
			//각 학생이 X에서 본인 마을로 오는 최단거리
			go(X, i);
			sum += min;
			
			result.add(sum);
		}
		System.out.println(Collections.max(result));
		

	}

}