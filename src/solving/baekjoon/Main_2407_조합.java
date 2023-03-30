package solving.baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * nCm 구하기
 * n개의 다른 수 중 m개 뽑는 경우의 수
 * BigInteger 사용
 * */

public class Main_2407_조합 {
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		BigInteger ncm = nCm(N, M);
        System.out.print(ncm);
	}
}
