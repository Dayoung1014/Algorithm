package baekjoon.n2023;

import java.util.Scanner;

/*
 * 신기한 소수 : arr[:n] arr[:n-1] ... arr[0] 각각 모두 소수인 것
 * 소수 = 나누어 떨어지는게 본인, 1 말고 없음
 * */



public class Main {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); //자리수 
		int start = (int) (Math.pow(10, N-1) + 1);
		int finish = (int) (Math.pow(10, N) - 1);
		
		for(int i=start; i<=finish; i++) {
			String str = Integer.toString(i);
			if(isPrime(i) & (Integer.valueOf(str.charAt(0)) == 2 | Integer.valueOf(str.charAt(0)) == 3 | Integer.valueOf(str.charAt(0)) == 5 | Integer.valueOf(str.charAt(0)) == 7)) { //수 자체가 소수인 경우에만
				boolean is = true;
				for(int idx=2; idx<N; idx++) {
					if(!isPrime(Integer.valueOf(str.substring(0, idx)))) {
						is = false;
						break;
					}
				}
				if(is)
					sb.append(i+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public static boolean isPrime(int n) {
		if(n == 0 | n == 1 ) return false;
		if(n==2) return true;
		
		for(int i=2; i<=(int) Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
