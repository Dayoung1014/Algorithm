package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer;


public class Main_2477_참외밭 {
	static int[] len = new int[6];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		int maxH = 0;
		int maxW = 0;
		int idxH = 0;
		int idxW = 0;
		
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			len[i] = l;
			if(d==3 || d==4) {
				if(maxH < l) {
					maxH = l;
					idxH = i;
				}
			}
			else  {
				if(maxW < l) {
					maxW = l;
					idxW = i;
				}
			}
		}
		
		
		//idxH 양옆 구해서 차가 빈사각형 가로
		//idxW 양옆 구해서 차가 빈사각형 세로
		int big = maxH*maxW;
		int small = getMin(idxH)*getMin(idxW);
		int result = (big-small) * K;
		System.out.println(result);
	}
	
	static int getMin(int idx) {
		if(idx==0) return Math.abs(len[5]-len[1]);
		else if(idx==5) return Math.abs(len[4]-len[0]);
		else return Math.abs(len[idx-1]-len[idx+1]);
	}
}
