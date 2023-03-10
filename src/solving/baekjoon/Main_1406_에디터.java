package solving.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * Stack 시간 복잡도
 * 삽입(Push): 맨 위에 데이터를 넣으면 되기 때문에 O(1) 
 * 삭제(Pop): 맨 위에 데이터를 삭제하면 되기 때문에 O(1) 
 * 읽기(Peek): 맨 위의 데이터를 읽으면 되기 때문에 O(1)
 * 탐색(Search): 맨 위의 데이터부터 하나씩 찾아야 하기 때문에 O(n)
 * */

public class Main_1406_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int N = str.length();
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for(int n=0; n<N; n++) {
			left.add(str.charAt(n));
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			String line = br.readLine();
			char order = line.charAt(0);
			
			if(order=='L' && left.size()>0)  right.push(left.pop());
			
			else if(order=='D' && right.size()>0)  left.push(right.pop());
			
			else if(order=='B' && left.size()>0) left.pop(); 

			else if(order=='P') {
				char word = line.charAt(2);
				left.push(word);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while(!left.isEmpty()) {
			sb.append(left.pop());
		}
		String left_str = sb.reverse().toString();
		
		sb = new StringBuffer();
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		String right_str = sb.toString();
		
		bw.write(left_str+right_str);
		bw.flush();
		bw.close();
	}



}
