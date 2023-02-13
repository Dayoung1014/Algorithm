package solving.swea.n7272;

/*
 * str1 str2 길이가 다르면 DIFF
 * 
 * str1 str2 길이가 같다면 순회하며
 * str1, str2의 i번째 문자 zero.contains / one.contains / b.equals 결과가 다르다면 DIFF
 * 
*/
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		String zero = "CEFGHIJKLMNSTUVWXYZ"; //구멍0 
		String one = "ADOPQR"; //구멍1 
		String b = "B"; 
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#"+test_case+" ");
			String str1 = sc.next();
			String str2 = sc.next();
			boolean res = true;
			
			
			if(str1.length() != str2.length()) res = false;
			else {
				for(int i=0; i<str1.length(); i++) {
					if(zero.contains(String.valueOf(str1.charAt(i))) != zero.contains(String.valueOf(str2.charAt(i)))
							||  one.contains(String.valueOf(str1.charAt(i))) != one.contains(String.valueOf(str2.charAt(i))) 
							|| b.equals(String.valueOf(str1.charAt(i))) != b.equals(String.valueOf(str2.charAt(i)))) {
						res = false;
						break;
					}
				}
			}
			if(res) System.out.println("SAME");
			else System.out.println("DIFF");
			
		}
	}
}
