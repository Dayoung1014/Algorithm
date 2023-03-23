package solving.baekjoon;

/*
* 글자:1 / 여백:0
* 팔방탐색으로 글자가 몇 개인지 구하기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14716_현수막 {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;

    static int count=0;

    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1}; //상하좌우 좌상 좌하 우상 우하
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void check(int r, int c) {
        Queue<Point> q = new LinkedList<>();

        visited[r][c] = true;
        q.offer(new Point(r, c));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nc<0 || nr>=M || nc>=N) continue;
                if(map[nr][nc]==0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.offer(new Point(nr, nc));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                map[m][n] = Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if(map[m][n]==1 && !visited[m][n]) {
                    count++;
                    check(m,n);
                }
            }
        }

        System.out.println(count);
    }
}
