package solving.swea;

/*
 * 메모리 bit 중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리 끝까지 덮어씌워짐
 * ex) 0100 -> 0110 하려했는데 0111 (메모리 번호가 왼쪽부터 1)
 * 
 * 원래 상태가 주어질 때 초기화 상태(다 0으로 된 상태) 에서 
 * 원래 상태로 돌아가는데 최소 몇 번 고쳐야 하나
 * */

import java.util.Scanner;

class Solution_1289_원재의메모리복구하기  {
	static char[] now; //현재 메모리 값
	static char[] origin; //메모리 원래 값
	static int cnt; //최소 수정 횟수
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			cnt = 0;
			 origin = sc.next().toCharArray();
			 now = new char[origin.length];
			 for(int i=0; i<origin.length; i++) {
				 now[i] = '0';
			 }
			 memoryChange(0);
			System.out.println("#"+test_case + " "+cnt);
		}
	}
	
	public static void memoryChange(int idx) {
		if(new String(origin).equals(new String(now))) { // 현재 상태 == 원래 상태
			return;
		}
		
		if(now[idx] != origin[idx]) { // 현재 위치의 값이 다를 때
			for(int i=idx; i<now.length; i++) { // 변경할 값을 메모리 끝까지 덮어씌움
				now[i] = change(now[i]);
			}
			cnt++; // 수정 횟수 올리기
		}
		memoryChange(idx+1);
	}
	
	public static char change(char a) { // 현재 위치의 값 변경 메소드
		if(a == '1') return '0';
		else return '1';
	}
	
}