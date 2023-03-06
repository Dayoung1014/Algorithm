package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11779_최소비용구하기2 {
    static class Node implements Comparable<Node>{
        int e,c;

        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", c=" + c +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.c, o.c);
        }
    }
    static int V, E;
    static int[] dist, preCity;
    //static boolean[] v;
    static ArrayList<Node>[] adj;

    static Stack<Node> route = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine()); // 도시 개수
        E = Integer.parseInt(br.readLine()); // 버스 개수

        adj = new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[V+1];
        preCity = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        //v = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라 계산 시작
        dist[start] = 0;
        PriorityQueue<Node> q =new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node n = q.poll();
            int idx = n.e;
            //v[idx] = true;
            if(dist[idx] < n.c) continue; //dist 값이 이미 현재보다 작다면 보지 않기
            for(Node next : adj[idx]) {
                // 도착 정점
                if(dist[next.e] > dist[idx]+ next.c) {
                    dist[next.e] = dist[idx]+ next.c;
                    q.add(new Node(next.e, dist[next.e]));
                    preCity[next.e]= idx;
                }
            }
        }

        System.out.println(dist[end]);

        // 경로 역추적
        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (preCity[end] != 0) {
            cnt += 1;
            stack.push(preCity[end]);
            end = preCity[end];
        }
        System.out.println(cnt);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}