package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int start, end;
	
	static LinkedList<Integer>[] adj;
	static boolean[] v;
	static int result = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine()); //전체 사람수
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()); //촌수 계산할 사람
		end = Integer.parseInt(st.nextToken()); //촌수 계산할 사람
		
		adj = new LinkedList[n+1];
		v = new boolean[n+1];
		
		for(int i=0; i<n+1; i++) {
			adj[i] = new LinkedList<>();
		}
		
		int m = Integer.parseInt(br.readLine()); // 부모 자식간의 관계
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int parents = Integer.parseInt(st.nextToken()); // 부모
			int child = Integer.parseInt(st.nextToken()); // 자식
			
			adj[parents].add(child);
			adj[child].add(parents);
		}
		
//		for(int i=0; i<n+1; i++) {
//			System.out.print(i + " ");
//			System.out.println(adj[i]);
//		}
		
		dfs(start, 0);
		System.out.println(result);
		
	}
	private static void dfs(int now, int count) {
		v[now] = true;
		if(now == end) {
			result = count;
			//return result; 
			// 바로 return 해줘도 해당 재귀만 나가는 것이고 다른 재귀는 진행중 -> 만족 할 때만 전역 변수 변경
		}
		
		for(int a : adj[now]) {
			if(!v[a]) {
				dfs(a, count+1);
			}
		}
	}

}
