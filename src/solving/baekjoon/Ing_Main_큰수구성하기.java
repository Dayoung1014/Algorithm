package solving.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// 런타임 에러 (NoSuchElement)

public class Ing_Main_큰수구성하기 {
	static int N; static int len; static int K; 
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> perArr = new ArrayList<>();
	static int maxNum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		len = Integer.toString(N).length();
		for(int i=0;i<len;i++) {
			arr.add(sc.nextInt());
		}
		
		permutation(0);
		System.out.println(maxNum); 
	}

	public static void permutation(int idx) {
		if(perArr.size()==len) {
			int result = Integer.parseInt(perArr.toString().replaceAll("[^0-9]",""));
			if(result < N & maxNum < result) {
				maxNum = result;
			}
			return;
		}
		
		for(int i=idx; i<len; i++) {
			perArr.add(arr.get(i));
			permutation(idx);
			perArr.remove(perArr.size()-1);
		}
		
	}

}
