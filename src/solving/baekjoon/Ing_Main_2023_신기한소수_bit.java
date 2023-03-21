package solving.baekjoon;

import java.util.Scanner;

/*
 * 신기한 소수 : arr[:n] arr[:n-1] ... arr[0] 각각 모두 소수인 것
 * 소수 = 나누어 떨어지는게 본인, 1 말고 없음
 * 
 * 첫 번째로 등장할 수 있는 수 -> 2, 3, 5 ,7
 * 이후에는 홀수중에서만 따져야함
 * 
 * 참고 블로그
 * https://jaimemin.tistory.com/879
 * https://velog.io/@taeho97/BaekJoon-2023-%EC%8B%A0%EA%B8%B0%ED%95%9C-%EC%86%8C%EC%88%98
 
 * 비트 연산으로 원하는 자리의 숫자가 뭔지 알게된 후 소수인지 확인 
 * 뒤의 자리 하나씩 더해줘서 소수인지 확인
 * */


public class Ing_Main_2023_신기한소수_bit {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
	
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt(); //자리수 
		int start = (int) (Math.pow(10, N-1) + 1);
		int finish = (int) (Math.pow(10, N) - 1);
		
//		for(int i=start; i<=finish; i++) {
//			String str = Integer.toString(i);
//			if(isPrime(i) & (Integer.valueOf(str.charAt(0)) == 2 | Integer.valueOf(str.charAt(0)) == 3 | Integer.valueOf(str.charAt(0)) == 5 | Integer.valueOf(str.charAt(0)) == 7)) { //수 자체가 소수인 경우에만
//				boolean is = true;
//				for(int idx=2; idx<N; idx++) {
//					if(!isPrime(Integer.valueOf(str.substring(0, idx)))) {
//						is = false;
//						break;
//					}
//				}
//				if(is)
//					sb.append(i+"\n");
//			}
//		}
//		System.out.println(sb);
		
        getResult(0,4);
        System.out.println(sb);
	}
	
	public static boolean isPrime(int n) {
		if(n == 0 | n == 1 ) return false;
		
		for(int i=2; i<=(int) Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	
	public static void getResult(int num, int len) {
		if(len == 0) {
			if(isPrime(num)) sb.append(num).append("\n");
			return;
		}
		for(int i=0; i<10; i++) {
			int next = num * 10 + i;
			 if(isPrime(next)) getResult(next, len-1);
		}
	}

}
