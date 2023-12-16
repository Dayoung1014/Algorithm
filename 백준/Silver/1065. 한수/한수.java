import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	// 한수 : 각 자리가 등차수열을 이루는 정수
    	// N입력 시 1~N 사이의 한수 개수 출력
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int result = 0;
    	for(int i=1; i<=N; i++) {
    		if(hansu(i)) {
    			result += 1;
    		}
    	}
    	System.out.println(result);
    }
    public static boolean hansu(int a) {
    	String aStr = Integer.toString(a);
    	int minus = 0;
    	int nowMinus = 0;
    	for(int i=0; i<aStr.length()-1; i++) { 
    		nowMinus = aStr.charAt(i)-aStr.charAt(i+1);
    		if(i==0) {
    			minus = nowMinus;
    		}
    		else {
    			if(minus != nowMinus) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}