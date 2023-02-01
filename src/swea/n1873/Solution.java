package swea.n1873;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc#

/*
 * 사용자의 전차 하나만 등장
 * 사용자 입력에 따라 격자판 맵에서 다양한 동작을 함
 * 
 * 
문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)

문자 동작 (전차가 바라보는 방향 바꾸기 / 가는게 아니라 바라보는 방향을)
U UP : 위 / 한 칸 위가 평지라면 그 칸으로 이동
D Down : 아래 / 한 칸 아래가 평지라면  그 칸으로 이동
L Left : 왼 / 한 칸 왼쪽이 평지라면  그 칸으로 이동
R Right : 오 / 한 칸 오른쪽이 평지라면  그 칸으로 이동
S Shoot  : 전차가 바라보는 방향으로 포탄 발사


전차 : 맵 밖이라면 이동 X
발사된 포탄 : 벽돌or강철 벽에 충돌(포탄 소멸) / 맵 밖 나갈 때 까지 직진(아무 일도 없음)
강철 벽은 남아있음
벽돌 벽은 평지로 변경

입력 : 높이H , 너비W (H*W 격자판) > 길이가 W인 문자열 H번 주어짐
게임 맵 구성요소들이 나오고 전차는 한대만 나옴
N : 사용자 입력 개수 (동작 주어짐)

입력 받으면서 게임은 할 수 없음
전차 위치만 저장해두자
 * 
 * */


import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		char[] rule = {'.', '*', '#', '-'};
		char[] move = {'U', 'D', 'L', 'R', 'S'};
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int H = sc.nextInt(); 
			int W = sc.nextInt();
			char [][] map = new char[H][W];
			int[] idx = new int[2]; // 전차의 h w 위치
			int view = 0; //전차의 방향
			
			for(int h=0; h<H; h++) {
				String str = sc.next();
				for(int w=0; w<W; w++) {
					map[h][w] = str.charAt(w);
					//전차 위치 저장
					
				}
			}
		
		
		}
	}
}
