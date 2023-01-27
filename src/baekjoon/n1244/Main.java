package baekjoon.n1244;

import java.util.Scanner;

/*
 * 스위치 번호 : 1~N(개수)
 * 스위치 상태 : 1(on) 0(off)
 * num = 학생들에게 1~N의 자연수를 하나씩 나눠줌
 * 남학생 : idx가 num의 배수이면 -> 상태 변경
 * 여학생 : idx==num인 곳을 중심으로 상태가 좌우 대칭인 가장 큰 구간 
 * 			-> idx 포함된 해당 구간 모두 상태 변경
 * 
 * 마지막에 스위치 상태 출력 
 * */

public class Main {
	
	//스위치 상태 변경 메소드
	public static int change(int num) { 
		if(num==0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //스위치 개수
		int[] onoff = new int[N+1];  // 인덱스 오류 방지 위해 onoff[0] 비움.
		
		for(int i=1; i<N+1; i++) { //스위치 상태
			onoff[i] = sc.nextInt();
		}
		
		int students = sc.nextInt(); //학생 수
		for(int i=0; i<students; i++) { 
			int type = sc.nextInt(); //성별 : 1(남학생) 2(여학생)
			int num = sc.nextInt(); //부여받은 자연수
			
			if(type == 1) { //남학생
				for(int idx = 1; idx<N; idx++) {
					if(idx%num == 0) {
						onoff[idx] = change(onoff[idx]);
					}
				}
			}
			else if(type == 2) { //여학생
				onoff[num] = change(onoff[num]); //기준은 무조건 변경
				for(int t=1; t<N/2; t++) { 
					if(num-t>=1 && num+t<=N &&(onoff[num-t] == onoff[num+t])) {
						onoff[num-t] = change(onoff[num-t]); 
						onoff[num+t] = change(onoff[num+t]);
					}
					else {
						break;
					}
				}
			}
		}
		
		 // 인덱스 오류 방지 위해 비운 onoff[0] 제외하고 출력
		// 한줄에 20개씩 출력
		for(int idx = 1; idx<onoff.length; idx++) {
			System.out.print(onoff[idx]+" ");
			if(idx%20 == 0) {
				System.out.println();
			}
		}
		
	}

}
