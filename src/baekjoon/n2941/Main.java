package baekjoon.n2941;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> croatia = new ArrayList<>(Arrays.asList("c=", "c-","dz=", "d-", "lj", "nj", "s=", "z="));
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int res = 0;
		
		int idx = 0;   
		while(idx<str.length()) {
			if(croatia.contains(str.charAt(idx))) {
				res++;
				idx++;
			}
			else if(idx+1<str.length() && croatia.contains(str.substring(idx, idx+2))) {
				res++;
				idx += 2;
			}
			else if(idx+2<str.length() && croatia.contains(str.substring(idx, idx+3))) {
				res++;
				idx += 3;
			}
			else {
				res++;
				idx++;
			}
		}
		
		System.out.println(res);

	}

}
