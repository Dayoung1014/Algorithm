package solving.baekjoon;

import java.util.Scanner;

/* 스위치 N개 1~N번까지
 * 1(켜져 있음) 0(꺼져 있음)
 * 학생 몇 명에게 자연수 나눠주고 
 * 
 * 남학생 : 	받은 수의 배열인 것들의 상태를 변경
 * 여학생 : 받은 수를 중심으로 좌우 대칭이 최대가 되는 구간 모두 변경
 * 
 * 스위치 마지막 상태 출력
 * */

public class Main_1244_스위치켜고끄기 {
	static int[] arr;
	public static void change(int i) { //현재 위치의 스위치 변경
		if(arr[i] == 0)  {
			arr[i] = 1;
		}
		else {
			arr[i] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N+1]; //index 실수 방지 위해 1 크게 설정
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int stu = sc.nextInt(); //학생수
		for(int s=0; s<stu; s++ ) {
			int sexual = sc.nextInt(); //1(남자) 2(여자)
			int n = sc.nextInt(); //받은 수
			
			if(sexual == 1) { //남학생
				for(int idx=n; idx<arr.length; idx=idx+n) {
					change(idx);
				}
			}
			else {
				int LR = 1;
				change(n); //일단 해당 자리는 바꿔줌
				while(n-LR >= 1 && n+LR<arr.length && arr[n-LR]==arr[n+LR] ) {
					change(n-LR);
					change(n+LR);
					LR++;
				}
			}
		}
		
		int p=1;
		while(p<arr.length) {
			System.out.print(arr[p]+" ");
			if(p%20 == 0) {
				System.out.println();
			}
			p++;
		}
		

	}

}
