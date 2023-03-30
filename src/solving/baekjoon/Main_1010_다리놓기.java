package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * 다리를 짓기 적합한 곳 : 사이트 
 * 서쪽 사이트 : N
 * 동쪽 사이트 : M
 * 
 * 서-동 연결하려고 함
 * 한 사이트에 하나의 다리만 연결 가능
 * 서쪽의 사이드 개수만큼 다리를 지으려 함
 * 
 * -> mCn
 * */

public class Main_1010_다리놓기 {
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
