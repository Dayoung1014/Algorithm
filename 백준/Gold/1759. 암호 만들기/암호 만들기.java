import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays; 
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alpha;
	static StringBuilder sb = new StringBuilder(); 
	
	static void combi(char[] select, int count, int idx, int gather, int consonant) {
		if(count==select.length) {
			if(gather>=1 && consonant>=2) {
				for (int i = 0; i < select.length; i++) {
					sb.append(select[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = idx; i < alpha.length; i++) {
			select[count] = alpha[i];
			if(alpha[i]=='a' || alpha[i]=='e' || alpha[i]=='i' || alpha[i]=='o' || alpha[i]=='u') 
				combi(select, count+1, i+1, gather+1, consonant);
			else combi(select, count+1, i+1, gather, consonant+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); //암호의 길이
		C = Integer.parseInt(st.nextToken()); //사용할 수 있는 알파벳의 수
		
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int c = 0; c < C; c++) {
			alpha[c] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha); 
		combi(new char[L], 0, 0, 0, 0);
		System.out.println(sb);
		
	}
}