import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static boolean[][] map, visit;
    static int maxArea;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if(map[n][m] && !visit[n][m]) bfs(n, m);
            }
        }

        System.out.println(maxArea);

    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static void bfs(int r, int c) {

        Queue<Point> q = new LinkedList<>();
        visit[r][c] = true;
        q.add(new Point(r, c));
        int area = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(!map[nr][nc] || visit[nr][nc]) continue; //방문한 곳이거나 음식이 없으면 넘김
                q.add(new Point(nr, nc));
                visit[nr][nc] = true;
                area++;
            }
        }
        maxArea = Math.max(maxArea, area);
    }
}