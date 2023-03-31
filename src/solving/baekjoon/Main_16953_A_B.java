package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 정수 a를 b로 바꾸려고 함
 * 가능한 연산 
 * - 2를 곱함
 * - 1을 수의 가장 오른쪽에 추가
 * 
 * a를 b로 바꾸는데 필요한 연산의 최솟값 구하기
 * */

public class Main_16953_A_B {
	static class Num {
		long n, cnt;

		public Num(long n, long cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
	}
	
	static long a, b;
	static long result = Long.MAX_VALUE;
	
	static void change() {
		Queue<Num> q = new LinkedList<>();
		boolean[] v = new boolean[(int) (b+1)]; //0~b까지 
		
		v[(int) a] = true;
		q.add(new Num(a, 0));
		
		while(!q.isEmpty()) {
			Num now = q.poll();
			//System.out.println();
			//System.out.println(now.n);
			if(now.n == b) {
				if(result > now.cnt) result = now.cnt;
				continue;
			}
			
			long[] next = new long[2];
			next[0] = now.n * 2;
			next[1] = Long.parseLong(Long.toString(now.n)+"1");
			
			for (long i : next) {
				//System.out.println(i);
				if(i > b || v[(int) i]) continue;
				v[(int) i] = true;
				q.add(new Num(i, now.cnt+1));
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		change();
		if(result == Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(result+1);
	}
}
