package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀과_사다리_게임_16928 {
    static int N, M;
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int minCnt = Integer.MAX_VALUE;

    static Map<Integer, Integer> NMap;
    static Map<Integer, Integer> MMap;
    static class Point {
        int idx, cnt;

        public Point(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    static void play() {
        Queue<Point> q = new LinkedList<>();
        boolean[] v = new boolean[100+1];
        v[1] = true;
        q.add(new Point(1, 0)); // 시작점에서 출발

        while (!q.isEmpty()) {
            Point p = q.poll();
            if(p.idx == 100) minCnt = Math.min(minCnt, p.cnt); // 도착점 도착
            for(int d : dice) {
                int next = p.idx+d;

                // 도착 지점이 사다리인 경우 사다리 적용 결과로 변경
                if(NMap.get(next) != null) next = NMap.get(next);

                // 도착 지점이 뱀인 경우 사다리 적용 결과로 바로 가기
                else if(MMap.get(next) != null) next = MMap.get(next);

                if(next > 100 || v[next] ) continue; //범위 벗어나거나 이미 방문한 곳인 경우
                q.add(new Point(next, p.cnt+1));
                v[next] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //사다리 수
        M = Integer.parseInt(st.nextToken()); // 뱀의 수

        NMap = new HashMap(); //사다리 정보
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            NMap.put(start, finish);
        }

        MMap = new HashMap(); //뱀 정보
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            MMap.put(start, finish);
        }

        play();
        System.out.println(minCnt);

    }
}
