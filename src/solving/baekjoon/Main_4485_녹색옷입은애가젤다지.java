package solving.baekjoon;

/*
* 동굴
* - map[N][N] (0, 0 ~ N-1, N-1)
* - 칸에서 도둑루피 만나면 그 크기만큼 소지금 잃음
* - 잃는 금액을 최소로 하여 도착했을 때 최소로 잃는 금액은 ?
* 이동은 사방으로만 가능
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4485_녹색옷입은애가젤다지 {
    static int N, result;
    static int[][] map;

    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};

    static class Point implements Comparable<Point>{
        int r, c, cost;

        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost-o.cost;
        }
    }

    static void bfs() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        boolean[][] v = new boolean[N][N];
        v[0][0] = true;
        q.add(new Point(0, 0, map[0][0]));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if(p.r==N-1 && p.c==N-1){
                result = Math.min(result, p.cost);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.add(new Point(nr, nc, p.cost+map[nr][nc]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = 1;

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            map = new int[N][N];
            // 동굴의 각 칸에 도둑루피의 크기 세팅 (0~9)
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MAX_VALUE;
            bfs();
            System.out.println("Problem "+test_case+": "+result);
            test_case++;
        }
    }
}
