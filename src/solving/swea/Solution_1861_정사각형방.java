package solving.swea;
/*
* 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.

처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램을 작성하라.

처음에 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지를 공백으로 구분하여 출력한다.

이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력한다.
*/

import java.util.Scanner;

class Solution_1861_정사각형방 
{
    static int N;
    static int[][] map;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int maxCnt;
    static int maxRoom;
    public static int dfs(int x, int y, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = x+dr[i];
            int ny = y+dc[i];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if (map[x][y]+1 != map[nx][ny]) continue;
            count = dfs(nx, ny, count+1);

            if (maxCnt < count) {
                maxCnt = count;
                maxRoom = map[x][y];
            } //최대가 같은 경 방번호가 작은거
            else if (maxCnt == count && maxRoom > map[x][y]) {
                maxRoom = map[x][y];
            }

            //break;
        }

        return count;

    }




    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            maxCnt=0;
            maxRoom=0;
            N = sc.nextInt();
            map = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dfs(i,j, 1);
                }
            }
            System.out.println("#"+test_case+" "+maxRoom+" "+maxCnt);

        }
    }
}