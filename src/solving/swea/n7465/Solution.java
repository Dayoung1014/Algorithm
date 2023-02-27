package solving.swea.n7465;

import java.util.ArrayList;
import java.util.Scanner;



  
class Solution {
	static class Node {
		int vertex; //정점 번호
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}

	static Node[] adjList;
	
	public static void main(String args[]) throws Exception {
	 
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
	
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); //마을에 사는 사람의 수
			int M = sc.nextInt(); //서로를 알고 있는 사람의 관계 수
			
			adjList = new Node[N];
			
			int from, to;
			for(int m=0; m<M; m++) {
				from = sc.nextInt();
				to = sc.nextInt();
				
				//무향 그래프
				adjList[from] = new Node(to, adjList[from]);
				adjList[to] = new Node(from, adjList[to]);
			}
		}
	}
	
	private static void dfs(int current, boolean[] visited) { //current : 탐색 정점
		visited[current] = true;
		//System.out.println((char) (current+65)); // 탐색할 때 해야 할 일
		
		// 자신의 인접 리스트 확인
		for (Node temp=adjList[current]; temp !=null; temp=temp.link) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex, visited);
			}
		}
	}
}