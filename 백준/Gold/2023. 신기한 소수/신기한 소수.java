import java.util.Scanner;

/*
 * 신기한 소수 : arr[:n] arr[:n-1] ... arr[0] 각각 모두 소수인 것
 * 소수 = 나누어 떨어지는게 본인, 1 말고 없음
 *
 * */



public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt(); //자리수 
        getResult(0,N);
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
