package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 트리의 루트를 1
 * 트리상 연결된 간선 번호들 주어졌을 때
 * 각 노드의 부모를 구해 
 * 노드 번호 2번부터 출력해라
 * */

public class Main_11725_트리의부모찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] tree = new ArrayList[N+1]; // 0 비우기 위해
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			tree[start].add(end);
			tree[end].add(start);
		}
		
//		for (int i = 1; i < N; i++) {
//			System.out.println(i+" "+tree[i].toString());
//		}
		
		// 부모 번호 저장
		int[] parents = new int[N+1]; // 0 비우기
		
		// bfs 시작
		Queue<Integer> q = new LinkedList();
		boolean[] visited = new boolean[N+1]; // 0 비우기
		
		// 1의 자식 확인 (1은 무조건 자식만 연결하고 있음)
		visited[1] = true;
		for(int i=0; i<tree[1].size(); i++) { 
			int child = tree[1].get(i);
			visited[child] = true;
			parents[child] = 1;
			q.add(child);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<tree[now].size(); i++) { // now에 연결된 것 확인 (연결된 것은 자식이거나 부모)
				int next = tree[now].get(i);
				if(visited[next]) continue; //이미 확인한 것 (부모)->부모에서 q에 넣어져서 왔으므로
				visited[next] = true;
				parents[next] = now;
				q.add(next);
			}
		}
		
		for (int i = 2; i < parents.length; i++) {
			System.out.println(parents[i]);
		}
		

		
		
	}
}
