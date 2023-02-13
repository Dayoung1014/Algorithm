package solving.baekjoon.n2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 *
 *  */

public class Main {

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
				if(stack.peek()[0] < arr[i]) { //현재보다 작으면 pop
					stack.pop();
				}
				else { // 현재보다 큰 값 만나면
					sb.append(stack.peek()[1]+" "); //해당 값 위치
					break; // 끝내야 함
				}
			}

			if(stack.isEmpty()) {
				sb.append(0+" ");
			}
			stack.push(new int[] {arr[i], i+1}); //현재 값과 위치 저장

		}



		System.out.println(sb);

	}

}
