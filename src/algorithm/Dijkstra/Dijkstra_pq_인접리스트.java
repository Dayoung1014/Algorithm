package algorithm.Dijkstra;

/*
그래프 최단 거리 구하는 알고리즘
- 다익스트라 (음수 가중치 불가, 음수 사이클 불가, O(mlog n))
- 벨만 포드 (음수 가중치 가능, 음수 사이클 불가, O(mn))
- 플로이드 와샬

다익스트라 과정
1. 출발 노드 설정
2. 최단 거리 저장 테이블 초기화
3. 방문하지 않은 노드 중 최단거리(가중치가 작은) 노드 선택
4. 선택한 노드에서 최단 거리 테이블 갱신
5. 3 & 4 반복

[Input]
7 11
0 1 2
0 2 2
0 5 8
1 2 1
1 3 19
2 5 5
3 4 7
3 5 11
3 6 15
4 5 9
4 6 3

* */


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 인접 리스트 + 우선순위 큐 사용
public class Dijkstra_pq_인접리스트 {
    static class Node implements Comparable<Node>{
        int e, c;
        Node(int e, int c){
            this.e=e;
            this.c=c;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.c, o.c);
        }
    }
    static int V,E; //노드 개수, 간선 개수
    static int[] dist; //노드별 최단거리 저장
    static boolean[] v; //노드 방문 여부
    static ArrayList<Node>[] adj; //노드 인접리스트

    static void dijkstra() {
        dist = new int[V]; //최단 거리 저장할 리스트
        Arrays.fill(dist, Integer.MAX_VALUE); //최단 거리를 구할것이므로 초기값은 max값으로 세팅
        dist[0]=0; //시작값은 0으로
        v = new boolean[V]; //방문 여부

        PriorityQueue<Node> Q = new PriorityQueue<Dijkstra_pq_인접리스트.Node>();
        Q.add(new Node(0, 0));
        while(!Q.isEmpty()) {
            Node p = Q.poll();

            v[p.e]=true;

            for (Node next : adj[p.e]) {
                if(v[next.e]) continue;;
                dist[next.e] = Math.min(dist[next.e], dist[p.e]+next.c);
                Q.add(new Node(next.e,dist[next.e]));
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        adj = new ArrayList[V]; //인접리스트
        for (int i = 0; i < V; i++) {
            adj[i]=new ArrayList();
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a].add(new Node(b, c));
        }

        dijkstra();

    }
}
