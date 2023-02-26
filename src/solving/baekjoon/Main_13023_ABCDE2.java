package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_13023_ABCDE2 {

	static class Person{
		int idx;
		ArrayList<Person> adj;

		public Person(int idx) {
			this.idx = idx;
			this.adj = new ArrayList<>();
		}
	}

	static Person[] people;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		people = new Person[n];
		for(int i=0; i<n; i++){
			people[i] = new Person(i);
		}

		for(int i=0; i<m; i++){
			inputs = br.readLine().split(" ");

			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);

			people[a].adj.add(people[b]);
			people[b].adj.add(people[a]);
		}

		flag = false;
		for(int i=0; i<n; i++){
			visited = new boolean[n];
			visited[i] = true;
			dfs(i, 1);
			if(flag) { // 5명이 이어진 경로가 있다면 1 출력 후 종료
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

	public static void dfs(int now, int count){

		if(count==5){ // count는 이어진 사람의 수
			flag = true;
			return;
		}

		for(Person p : people[now].adj){
			if(!visited[p.idx]){
				visited[p.idx] = true;
				dfs(p.idx, count + 1);
				visited[p.idx] = false;
			}
		}

	}
}