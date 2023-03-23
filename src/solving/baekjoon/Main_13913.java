package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// visited[현재 위치] = 바로 직전의 위치

public class Main_13913 {
	static int start, end;
	
	static void move() {
		Queue<Integer> q = new LinkedList();
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);
		
		visited[start] = start;
		q.add(start);
		
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			int[] next = {p-1, p+1, p*2};
			for(int n : next) {
				if(n<0 || n>100000 || visited[n] != -1) continue; //인덱스 벗어나거나 이미 방문한 경우
				visited[n] = p; //다음 위치 index에 현재 위치 넣음
				q.add(n);		
			}
			
			if(visited[end]!=-1) {
				Stack<Integer> stack = new Stack<Integer>();
				int cur=end;
				int time = 0;
				
				while(true) {
					stack.add(cur); //현재 위치 
					if(cur == start) break;
					cur = visited[cur]; //현재 위치의 직전 위치를 현재 위치로 변경
					time++; //시간 증가
				}
				
				System.out.println(time);
				while(!stack.isEmpty()) {
					System.out.print(stack.pop()+" ");
				}
				return;
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		move();
		
		
	}

}