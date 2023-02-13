package solving.baekjoon.n13300;

import java.util.Scanner;

/*
 * 남학생끼리 여학생끼리 배정
 * 같은 학년끼리 배정
 * 한 방에 한 명도 가능
 * 
 * 한 방에 최대 K명 가능
 * 
 * 학생들을 모두 배정하는 최소한의 방 수 구하기
 * */

/*
 * 학년별로 자르고 성별로 자르기 -> num
 * num이 0이 아닌 경우
 * num / K 의 올림
 * 전체 더하기
 * 
 * */

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 여행 참가 학생 수
		int K = sc.nextInt(); // 한 방 최대 인원 수
		int room = 0;
		
		//idx 오류 방지 위해 0학년 추가 생성함
		int [][] stu = new int[6+1][2]; // 학년별 여학생 수, 남학생 수 
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x==0) {
				stu[y][0]++; 
			}
			else {
				stu[y][1]++;
			}
		}
		
		for(int i=1; i<=6; i++) {
			room += Math.ceil((double)stu[i][0]/K);
			room += Math.ceil((double)stu[i][1]/K);
		}
		
		System.out.println(room);
		
	}

}
