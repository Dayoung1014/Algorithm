package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 운동_1956 {
    static int V, E;
    static int[][] graph;
    static void floydWarsall() {
        int dist[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(graph[i][j] == 0 || i==j) dist[i][j] = Integer.MAX_VALUE; //경로가 없는 곳
                else dist[i][j] = graph[i][j];
            }
        }

        for (int start = 0; start < V; start++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(dist[i][start] != Integer.MAX_VALUE && dist[start][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][start]+dist[start][j]); //최단 거리 갱신
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if(dist[i][i]==Integer.MAX_VALUE) continue;
            min = Math.min(min, dist[i][i]);
        }

        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new int[V][V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int finish = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            graph[start][finish] = cost;
        }

        floydWarsall();
    }
}
