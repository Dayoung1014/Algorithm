package solving.baekjoon.n6593;

/*
* 상범 빌딩 : 각 변의 길이가 1인 정육면체로 이루어짐
* 각 정육면체는 지나갈 없거나 / 찌나갈 수 있음
*
* 인접(동서남북상하) 로 1분의 시간을 들여 이동할 수 있다 (대각선 이동은 불가)
*
* # : 지나갈 수 없음
* . : 지나갈 수 있음
* S : 시작 지점
* E : 출구
*
* 탈출 시 : Escaped in x minute(s).
* 탈출 불가능 : Trapped!
*
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int L, R, C;
    static char[][][] building;
    static int[] startIdx = new int[3];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            L = sc.nextInt(); //빌딩 층 수
            R = sc.nextInt(); //한 층의 행
            C = sc.nextInt(); //한 층의 열

            if(L==0 && R==0 & C==0) return;
            building = new char[L][R][C];
            for(int l=0; l<L; l++) {
                for(int r=0; r<R; r++) {
                    String str = sc.next();
                    for(int c=0; c<C; c++) {
                        building[l][r][c] =str.charAt(c);
                        if(building[l][r][c] == 'S') {
                            startIdx[0] = l;
                            startIdx[1] = r;
                            startIdx[2] = c;
                        }
                    }
                }
            }
            bfs();
        }





    }
    static  int[] dl = {0, 0, 0, 0, 1, -1}; //동서남북상하
    static int[] dr = { 0, 0, 1, -1, 0, 0};
    static int[] dc = { 1, -1, 0, 0, 0, 0 };


    static class Point {
        int l, r, c, time;

        public Point(int l, int r, int c, int time    ) {
            super();
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Escaped in " + time + " minute(s).";
        }
    }

    private static void bfs() {
        Queue<Point> Q = new LinkedList();
        // 방문배열
        boolean[][][] v = new boolean[L][R][C];
        boolean succes = false;
        v[0][0][0]=true;
        Q.offer(new Point(startIdx[0], startIdx[1], startIdx[2], 0));
        L:while(!Q.isEmpty()) {
            Point p = Q.poll();
            //System.out.println(p.time);
            if(building[p.l][p.r][p.c] == 'E') {
                System.out.println(p.toString());
                succes = true;
                break L;

            }
            for (int d = 0; d <6; d++) { //동서남북상하
                int nl = p.l+dl[d];
                int nr = p.r+dr[d];
                int nc = p.c+dc[d];

                if(nl>=0 && nl<L && nr>=0 && nr<R && nc>=0 && nc<C && !v[nl][nr][nc] && (building[nl][nr][nc]=='.'|| building[nl][nr][nc]=='E')) {
                    v[nl][nr][nc]=true;
                    Q.add(new Point(nl, nr, nc,p.time+1));
                }
            }
        }

        if(!succes) System.out.println("Trapped!");

    }

}
