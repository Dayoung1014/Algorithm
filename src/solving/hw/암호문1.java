package solving.hw;

import java.util.ArrayList;

import java.util.Scanner;

class  암호문1{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=10; //테스트케이스 개수
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); //원본 암호문 길이
			ArrayList<Integer> pw = new ArrayList<>();
			for(int i=0; i<N; i++) { //원본 암호문
				pw.add(sc.nextInt());
			}
			
			int order = sc.nextInt(); //명령어 개수
			for(int i=0; i<order; i++) {
				sc.next(); // I 받기 위해
				int x = sc.nextInt();  // x위치 바로 다음에 (위치는 1부터 시작)
				int y = sc.nextInt(); 
				for(int j=0; j<y; j++) { // 해당 숫자들 삽입
					pw.add(x++, sc.nextInt());
				}
			}
			
			System.out.print("#"+test_case+" ");
			for(int i=0; i<10; i++) {
				System.out.print(pw.get(i)+" ");
			}
			System.out.println();
		}
	}
}