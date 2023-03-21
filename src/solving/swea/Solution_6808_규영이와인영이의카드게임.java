package solving.swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 카드 게임
 * - 1~18 까지 적힌 카드
 * - 섞어서 9장씩 나눠 갖음
 * - 한 장씩 카드를 내서 9라운드 진행 후 총점이 높은 사람이 이김 (같을 시 무승부)
 * - 점수 : 높은 수 카드를 낸 사람이 두 카드의 합만큼 얻음
 * 
 * 
 * 규영이가 내는 카드의 순서를 고정했을 때 인영이가 내는 순서에 따라 규영이 승패 정해짐
 * 규영이가 이기는 경우의 수, 지는 경우의 수 구하기
 * 
 * 
 * 인영이의 카드 9개 중 9를 순서 상관 있게 꺼냄
 * 각 케이스 별로 점수 구해서 이기는 경우/지는 경우 계산
 * 
 * */

class Solution_6808_규영이와인영이의카드게임 {
	static int[] card1; //규영이 카드 (순서 고정)
	static int[] card2; // 인영이 카드 
	static boolean[] cards;
	static int win;
	static int lose;
	
	public static void per(int[] select, boolean[] visited, int count) { 
		if(count == select.length) {
	        int player1=0; //점수합
	        int player2=0; //점수합
	        
	        for(int i=0; i<9; i++) {
	        	int p1 = card1[i];
	        	int p2 = select[i];
	        	if(p1>p2) player1 += (p1+p2);
	        	else player2 += (p1+p2);
	        }
	        
	        if(player1>player2) win++;
	        else lose++;
			return;
		}
		for(int i = 0; i<card2.length; i++) {
			if(!visited[i]) { //방문하지 않았다면
				visited[i] = true;
				select[count] = card2[i];
				per(select, visited, count+1); 
				visited[i] = false;
			}
		}
	}
	
//	public static void permu(ArrayList<Integer> select, ArrayList<Integer> card, int count) { 
//	    if (count == 0) {  // 다 뽑았을 때
//	        int player1=0; //점수합
//	        int player2=0; //점수합
//	        for(int i=0; i<9; i++) {
//	        	int p1 = card1.get(i);
//	        	int p2 = select.get(i);
//	        	if(p1>p2) player1 += (p1+p2);
//	        	else player2 += (p1+p2);
//	        }
//	        if(player1>player2) win++;
//	        else lose++;
//	        return;
//	    }
//
//	    for(int i = 0; i < card.size(); i++) {
//	        if(select.contains(card.get(i))) {
//	            continue;
//	        }
//	        select.add(card.get(i));
//	        permu(select, card, count - 1);
//	        select.remove(select.size() - 1); 
//	    }
//	}
	// https://www.grepiu.com/post/9 Collection 사용 시 시간복잡도 상승에 유의
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			cards = new boolean[19]; //1~18 (0 비움)
			card1 = new int[9]; 
			card2 = new int[9]; 
			int idx = 0;
			
			for(int i=0; i<9;i++) { //규영이 카드
				int c = sc.nextInt();
				cards[c] = true;
				card1[i] = c; 
			}
			for(int i=1; i<=18;i++) {
				if(!cards[i]) card2[idx++] = i;
			}
			
			win = 0; lose=0;
			per(new int[9], new boolean[9],  0);
			System.out.println("#"+test_case+" "+win + " "+lose);
			

		}
	}
}