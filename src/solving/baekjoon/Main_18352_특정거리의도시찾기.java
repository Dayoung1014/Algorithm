package solving.baekjoon;
/*
* 1~N까지의 도시
* 도시간의 M개의 단방향 도로(거리는 1)
*
* 특정한 도시 X에서 출발해 도착할 수 있는 도시 중 최단 거리가 K인 모든 도시들의 번호를 출력
* (K보다 작거나 같은게 아니라 K인 곳만 구하기)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18352_특정거리의도시찾기 {
    static int N, M, K, X;
    static
    ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<Integer>[] city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호 

        city = new ArrayList[N+1]; // 0 비우려고 +1
        for (int i = 0; i < N+1; i++) {
           city[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); // A->B 단방향 도로
            int A = Integer.parseInt(st.nextToken()); // 출발
            int B = Integer.parseInt(st.nextToken()); // 도착
            city[A].add(B);
        }

        move(X);
        if(result.size()==0) System.out.println(-1);
        else {
            Collections.sort(result);
            for(int i : result) System.out.println(i);
        }
    }

    static class Point {
        int num, cnt;

        public Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static void move(int start) {
        Queue<Point> q = new LinkedList<>();
        boolean[] v = new boolean[N+1]; //도시 방문 여부
        v[start] = true;
        q.add(new Point(start, 0));

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.cnt==K) {
                result.add(now.num);
                continue;
            }
            for(int next : city[now.num]) {
                if(v[next]) continue;
                v[next] = true;
                q.add(new Point(next, now.cnt+1));
            }
        }
    }
}
