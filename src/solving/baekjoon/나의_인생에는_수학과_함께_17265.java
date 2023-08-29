package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 나의_인생에는_수학과_함께_17265 {
    static int N;
    static char[][] map;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static class Point{
        int r,c,ans;
        char prev;
        public Point(int r, int c, int ans, char prev) {
            this.r = r;
            this.c = c;
            this.ans = ans;
            this.prev = prev;
        }

    }
    static void dfs() {
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(0,0, Character.getNumericValue(map[0][0]), ' '));

        while(!stack.isEmpty()) {
            Point p = stack.pop();
            if(p.r == N-1 && p.c == N-1) {
                max = Math.max(max, p.ans);
                min = Math.min(min, p.ans);
            }
            for(int i=0; i<2; i++) {
                int nr = p.r+dr[i];
                int nc = p.c+dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                char now = map[nr][nc];
                int cal = p.ans;

                //현재 값이 숫자라면 prev와 계산
                if((Character.isDigit(now))) {
                    switch (p.prev) {
                        case '+':
                            cal += Character.getNumericValue(now);
                            break;
                        case '-':
                            cal -= Character.getNumericValue(now);
                            break;
                        case '*':
                            cal *= Character.getNumericValue(now);
                            break;
                    }
                    stack.add(new Point(nr, nc, cal, ' '));
                }
                else stack.add(new Point(nr, nc, cal, now));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        dfs();
        System.out.println(max + " " + min);
    }
}
