import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
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