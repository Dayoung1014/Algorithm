package swea.n2007;

import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{
	
	Scanner sc = new Scanner(System.in);
	int T, len;
	T=sc.nextInt();
	String words; 
	for(int test_case = 1; test_case <= T; test_case++){
		words = sc.next(); //길이 30
		len = 0;
		
		for(int i=9; i>=0; i--) { //마디의 길이가 10, 9, 8... 1까지 검사
			if(words.substring(0, i+1).equals( words.substring(i+1, (i+1)*2))) {
				len = i+1;
			}
		}
		System.out.println("#"+test_case+" "+len);
	}
	}
}
