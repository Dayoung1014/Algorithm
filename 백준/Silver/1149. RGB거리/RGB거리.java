import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //집의 수
		int[][] RGB = new int[N][3];
		
		for (int i = 0; i < RGB.length; i++) {
			st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
			
			if(i>0) {
				RGB[i][0] += Math.min(RGB[i-1][1], RGB[i-1][2]);
				RGB[i][1] += Math.min(RGB[i-1][0], RGB[i-1][2]);
				RGB[i][2] += Math.min(RGB[i-1][0], RGB[i-1][1]);
			}
		}
		
		System.out.println(Math.min(RGB[N-1][0], Math.min(RGB[N-1][1], RGB[N-1][2])));

		
	}
}