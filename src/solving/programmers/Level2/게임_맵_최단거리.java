package solving.programmers.Level2;
import java.util.*;
public class 게임_맵_최단거리 {
    class Solution {
        int R;
        int C;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        class Point{
            int r, c, cnt;

            public Point(int r, int c, int cnt) {
                super();
                this.r = r;
                this.c = c;
                this.cnt = cnt;
            }
        }

        int bfs(int[][] maps) {
            int ans = -1;
            Queue<Point> q = new LinkedList();
            boolean[][] v = new boolean[R][C];
            v[0][0]=true;
            q.offer(new Point(0, 0, 1));

            breakout:
            while(!q.isEmpty()) {
                Point p = q.poll();
                if(p.r==R-1 && p.c == C-1) {
                    ans = p.cnt;
                    break breakout;
                }
                for(int i=0; i<4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                    if (v[nr][nc] || maps[nr][nc] == 0) continue;
                    v[nr][nc] = true;

                    q.add(new Point(nr, nc, p.cnt + 1));
                }
            }
            return ans;
        }

        public int solution(int[][] maps) {
            int answer = 0;

            R = maps.length;
            C = maps[0].length;
            answer = bfs(maps);
            return answer;
        }
    }
}
