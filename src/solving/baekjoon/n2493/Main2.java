package solving.baekjoon.n2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 일직선 위에 N개의 높이가 서로 다른 탑을 수평으로 왼~오 차례로 세움
 * 탑에서 레이저 왼쪽으로 발사
 * 가장 먼저 만나는 하나의 탑에서만 수신 받음
 * 
 * 앞에서부터 보면서 스택이 비어있다면 0 
 * 현재 지나가면 스택에 넣어줌
 * 스택의 탑 값이 현재보다 작으면 pop하고 현재 넣어줌
 * 
 * 현재보다 크다면 그 인덱스 넣어줌
 * */

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
	
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		for(int i=0; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[0] < arr[i]) {
					stack.pop();
				}
				else {
					sb.append(stack.peek()[1]+" ");
					break;
				}
			}
			if(stack.isEmpty()) {
				sb.append(0+" ");
			}
			stack.push(new int[] {arr[i], i+1});
			
			
		}
		
		
		
		System.out.println(sb);
		
	}

}
