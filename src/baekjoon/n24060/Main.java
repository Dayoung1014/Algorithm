package baekjoon.n24060;

import java.util.Scanner;

/*
 * 배열 A : N개의 서로 다른 양의 정수가 저장되어 있음
 * 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K번째 저장되는 수 구하기 
 * 
 * 배열 A에 K번째 저장되는 수 출력
 * 저장 횟수가 K보다 작으면 -1 출력
 * 
 * */
/*
 * 병합 정렬 
 * - 주어진 리스트를 절반으로 분할하여 부분 리스트로 나눔
 * - 해당 부분 길이가 1이 아니라면 위 과정을 되풀이함
 * - 인접한 부분리스트끼리 정렬하여 합친다
 * */

public class Main {

	public static void merge_sort(int [] arr, int left, int right) { //부분리스트 왼쪽 시작, 오른쪽 시작
		if(left >= arr.length) {
			return;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //배열 A의 크기
		int K = sc.nextInt(); //저장 횟수
		int [] A = new int[N];
		for(int a : A) {
			a = sc.nextInt();
		}
		
	}

}
