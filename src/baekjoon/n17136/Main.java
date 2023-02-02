package baekjoon.n17136;

import java.util.Scanner;

/*
 * 1*1 / 2*2 / 3*3 / 4*4 / 5*5 색종이를 각 5장씩 갖고 있음 
 * 크기가 10*10 곳에 색종이를 붙여야 함
 * 칸에 1 -> 모두 색종이 붙여야 함
 * 칸에 0 -> 색종이 붙이면 안됨
 * 1인 칸 모두 채우는 데 필요한 색종이의 최소 개수 (모두 덮는거 불가능한 경우 -1)
 * 
 * 최소 개수로 사용하려면 큰 것들 먼저 사용해야함 
 * 
 * 
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] rec = {5, 5, 5, 5, 5};
		int [][] map = new int[10][10];
		int result = 0;
		
		for(int i=0; i<10;i++) {
			for(int j=0; j<10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		breakout:
		for(int h=0; h<10;h++) {
			for(int w=0; w<10;w++) {
				if(map[h][w]==1){
					int len = 0;
					int one = 1;
					int idx = 1;
					while (idx <=5 && h+idx<=9 && w+idx<=9) {
						int space = map[h+ idx][w + idx] + map[h + idx][w] + map[h][w + idx]+ map[h ][w];
						idx++;
						//System.out.println("space : "+space);
						if (space != idx * idx) {
							break;
						}
						len = idx-1;
					}
					for(int i=0; i<=len; i++) {
						map[h][w] = 0;
						map[h+i][w] = 0;
						map[h][w+i] = 0;
						map[h+i][w+i] = 0;
					}
					
					rec[len]--;  result++;
					if(rec[len] < 0) {
						result = -1;
						break breakout;
					}
				
					//System.out.println("h : "+h+" / w : "+w+" / len : "+len);
					//System.out.println(Arrays.toString(rec));
				}
			}
		}
		//System.out.println(Arrays.toString(rec));
		System.out.println(result);

	}

}
