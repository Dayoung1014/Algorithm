package solving.swea;
import java.util.Scanner;

class Solution_7964_부먹왕국의차원관문  {
	public static void main(String args[]) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] city = new int[N+2]; //0번~N+1번 도시의 문 유무 (1 있음 / 0 없음)
			city[0] = 1; city[N+1] = 1; //0번, N+1번은 항상 있음
			int count = 0; //건설할 문 개수
			int nearCity = 0; //가장 가까운 문이 있는 도시 위치 (0~N+1)
			
			for(int i=1; i<=N; i++) 
			{
				city[i] = sc.nextInt();
				if(city[i] == 1) { //현재 문이 있다면 
					nearCity = i; //nearCity를 현재로 갱신
				}
				else { //현재 문이 없다면
					if(i-nearCity < D) { //건설 없이 방문 가능한 도시이므로 지나감
						continue;
					}
					if(i-nearCity == D) { //문 건설 & nearCity를 현재로 갱신
						count += 1;
						nearCity = i;
					}
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
}