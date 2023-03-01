package solving.baekjoon;

/*
* 건물
* - 빈 공간 + 벽
* - 일부에 불이 남 (매 초마다 동서남북 인접으로 퍼짐)
* - 불은 벽에 붙지 않고 공간에만 퍼짐
* - 상근이는 벽 통과 X, 불이 있는 칸 X, 이제 불이 붙으려는 칸 X (상근이보다 불 먼저 이동시켜야 함)
* - 현재 있는 칸으로 불이 이동은 가능 (상근이는 이제 이동하니까)
*
* 빌딩의 지도가 주어졌을 때 얼마나 빨리 탈출할 수 있는가 구해라
* 탈출 == map 인덱스 벗어나기
*
* w : 건물 너비 / h : 건물 높이
* . : 빈공간
* # : 벽
* @ : 상근이 시작 위치
* * : 불
*
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w, h;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c, time;
        boolean isFire;

        public Point(int r, int c, int time, boolean isFire) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.isFire = isFire;
        }
    }
    private static int bfs(int startR, int startC) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] v = new boolean[h][w];

        for (int i = 0; i < h; i++) { // 불 먼저 넣어주기
            for (int j = 0; j < w; j++) {
                if(map[i][j]=='*') {
                    q.offer(new Point(i, j, 0, true));
                    v[i][j] = true;
                }
            }
        }

        q.offer(new Point(startR, startC, 0, false)); //상근이 넣어주기
        v[startR][startC] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if(p.isFire) { //불인 경우
                for(int d=0; d<4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if(nr<0 || nc<0 || nr>=h || nc>=w) continue; // 불은 외부 이동 불가
                    if(map[nr][nc]=='#') continue; // 불은 벽 이동 불가
                    if(v[nr][nc]) continue; // 방문 여부 확인
                    v[nr][nc] = true;
                    q.offer(new Point(nr, nc, p.time+1, true));
                    map[nr][nc] = '*';
                }
            }
            else { //상근이인 경우
                for(int d=0; d<4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if(nr<0 || nc<0 || nr>=h || nc>=w) return p.time+1; // 탈출
                    if(map[nr][nc]=='#' || map[nr][nc]=='*') continue; // 상근이는 벽, 불 이동 불가
                    if(v[nr][nc]) continue; // 방문 여부 확인
                    v[nr][nc] = true;
                    q.offer(new Point(nr, nc, p.time+1, false));
                    //map[nr][nc] = '*';
                }
            }

        }
        return -1;
    }



    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            int[] person = new int[2]; //상근이 시작 위치 저장

            for (int i = 0; i < h; i++) {
                String floor = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = floor.charAt(j);
                    if(map[i][j]=='@') {
                        person[0] = i; person[1] = j;
                    }
                }
            }

            int result = bfs(person[0], person[1]);

            if(result==-1) System.out.println("IMPOSSIBLE");
            else System.out.println(result);
        }
    }


}
