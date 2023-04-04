package solving.baekjoon;

/*
* N개의 도시, M개의 버스
* A에서 B까지 가는데 드는 최소 비용 구하기
* 도시 번호 1~N
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
    static int N, M;
    static ArrayList<Bus>[] graph;

    static class Bus implements Comparable<Bus>{
        int e,c;

        public Bus(int e, int c) {
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Bus o) {
            return this.c-o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //도시의 개수
        M = Integer.parseInt(br.readLine()); //버스의 개수

        graph = new ArrayList[N+1]; //0비우기
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //버스 출발 도시
            int e = Integer.parseInt(st.nextToken()); //버스 도착 도시
            int c = Integer.parseInt(st.nextToken()); //버스 비용
            graph[s].add(new Bus(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        int[] dist = new int[N+1]; //최소비용 저장 (0비움)
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] v = new boolean[N+1]; //방문 여부 저장 (0비움)

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));
        while (!pq.isEmpty()) {
            Bus now = pq.poll();
            if(v[now.e]) continue;
            v[now.e] = true;
            for(Bus next : graph[now.e]) {
                dist[next.e] = Math.min(dist[next.e], dist[now.e]+ next.c);
                pq.offer(new Bus(next.e, dist[next.e]));
                //System.out.println(next.e +" /  "+ next.c+" : "+Arrays.toString(dist));
            }
        }

        System.out.println(dist[end]);
    }
}
