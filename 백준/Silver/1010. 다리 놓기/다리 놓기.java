import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BigInteger nPm(long n, long m) {
        BigInteger j =  BigInteger.ONE;
        for (long i = 0; i < m; i++)
          j = j.multiply(new BigInteger(String.valueOf(n - i)));
        return j;
	 }
    
	static BigInteger nCm(long n, long m) {
        BigInteger c = BigInteger.ONE;
        for (long i = 1; i <= m; i++)
           c = c.multiply(new BigInteger(String.valueOf(i)));
        return nPm(n, m).divide(c);
	 }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			BigInteger ncm = nCm(R, L);
	        System.out.println(ncm);	
		}
	}
}