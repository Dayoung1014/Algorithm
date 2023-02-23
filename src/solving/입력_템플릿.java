package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class 입력_템플릿 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
	public static void main(String args[]) throws Exception {
		int T= Integer.parseInt(br.readLine()); ;
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N행
			int M = Integer.parseInt(st.nextToken());  // M열
			
			int[][] map = new int[N][M];
			
		}
	}
}
