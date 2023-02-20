package solving.baekjoon.n1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 흰점 (0) / 검은점 (1)
 * 숫자의 점들이 한 곳에 많이 몰려있으면 쿼드 트리에서 이를 압축하여 간단하게 표현 가능
 * 
 * 쿼드 트리 결과
 * - 모두 0이면 -> 0
 * - 모두 1이면 -> 1
 * - 섞여 있는 경우 왼쪽위 / 오른쪽위/ 왼쪽아래 / 오른쪽아래 4개의 영역을 각 압축
 * 
 * */

public class Main_first {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken()); // 영상의 크기
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = Character.getNumericValue((str.charAt(j)));
			}
		}
		
		int nowW = N; 
		int nowH = N;
		
		quadTree(0,0,N/2);
		System.out.println(sb);
	
	}
	
	public static void quadTree(int x, int y, int len) {
		
		boolean exist0 = false;
		boolean exist1 = false;
		
		if(len==1) {
			return;
		}
		
			// 왼쪽 위
			sb.append("(");
			exist0 = false;
			exist1 = false;
			
			for(int i=x; i<x+len; i++) {
				for(int j=y; j<y+len; j++) {
					if(arr[i][j]==0) exist0 = true;
					else if(arr[i][j]==1) exist1 = true;
				}
			}
			if(exist0 && exist1) quadTree(x, y, len/2);
			else if(exist0 && !exist1)  {
				sb.append(0); System.out.println("x : " +x+" / y : "+y+" / len : "+len );
			}
			else if(!exist0 && exist1) {
				sb.append(1); System.out.println("x : " +x+" / y : "+y+" / len : "+len);
			}
			
			
			exist0 = false;
			exist1 = false;
			// 오른쪽 위
			for(int i=x+len; i<x+len*2; i++) {
				for(int j=y; j<y+len; j++) {
					if(arr[i][j]==0) exist0 = true;
					else if(arr[i][j]==1) exist1 = true;
				}
			}
			if(exist0 && exist1) quadTree(x, y, len/2);
			else if(exist0 && !exist1)  {
				sb.append(0); System.out.println("x : " +x+" / y : "+y+" / len : "+len);
			}
			else if(!exist0 && exist1) {
				sb.append(1); System.out.println("x : " +x+" / y : "+y+" / len : "+len);
			}
			
			
			exist0 = false;
			exist1 = false;
			// 왼쪽 아래
			for(int i=x; i<x+len; i++) {
				for(int j=y+len; j<y+len*2; j++) {
					if(arr[i][j]==0) exist0 = true;
					else if(arr[i][j]==1) exist1 = true;
				}
			}					
			if(exist0 && exist1) quadTree(x, y, len/2);
			else if(exist0 && !exist1)  {
				sb.append(0); System.out.println("x : " +x+" / y : "+y+" / len : "+len);
			}
			else if(!exist0 && exist1) {
				sb.append(1); System.out.println("x : " +x+" / y : "+y+" / len : "+len);
			}
			
			
			exist0 = false;
			exist1 = false;
			// 오른쪽 아래
			for(int i=x+len; i<x+len*2; i++) {
				for(int j=y+len; j<y+len*2; j++) {
					if(arr[i][j]==0) exist0 = true;
					else if(arr[i][j]==1) exist1 = true;
				}
			}					
			if(exist0 && exist1) quadTree(x, y, len/2);
			else if(exist0 && !exist1)  {
				sb.append(0); System.out.println("x : " +x+" / y : "+y+" / len : "+len);
			}
			else if(!exist0 && exist1) {
				sb.append(1); System.out.println("x : " +x+" / y : "+y+" / len : "+len);
			}
			
			
			quadTree(x+len, y+len, len/2);
			sb.append(")");
		
		
	}

}
