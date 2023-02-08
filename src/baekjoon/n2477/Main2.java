package baekjoon.n2477;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 참외 총 개수 = 1m^2에서 자라는 참외 개수 * 밭의 총 넓이
 * 밭 넓이 = 큰 사각형 - 작은 사각형
 * 
 * 큰 사각형 가로 : 동(1) 서(2) 중에 큰 길이
 * 작은 사각형 가로 : 동(1) 서(2) 중에 작은 길이
 * 
 * 큰 사각형 세로 : 남(3) 북(4) 중에 큰 길이
 * 작은 사각형 세로 : 남(3) 북(4)  중에 작은 길이
 * */

public class Main2 {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int K = sc.nextInt(); // 1m^2에서 자라는 참외 개수
//		int x = 0; int y =0;
//		HashMap<Integer, Integer> maxMap = new HashMap<>();
//		HashMap<Integer, ArrayList<Integer>> minMap = new HashMap<>();
//		// 1 2 / 3 4 중 한번씩 나온게 큰 사각형의 가로, 세로
//		// 두 번 나온게
//		for(int i=0; i<6; i++) {
//			int dir = sc.nextInt();
//			int len = sc.nextInt();
//			if(!maxMap.containsKey(dir)) { // 존재하지 않는다면
//				maxMap.put(dir, len); // 넣어준다
//			}
//			else { //존재한다면
//				if(!minMap.containsKey(dir)) {
//
//					minMap.put(dir, );
//					maxMap.remove(dir);
//				}
//				else {
//					minMap.put(dir, new int[] {minMap.get(minMap));
//					maxMap.remove(dir);
//				}
//
//			}
//		}
//
//	}

}
