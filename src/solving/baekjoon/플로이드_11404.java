package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드_11404 {
    static int n, m;
    static int[][] graph;

    static void floydWarshall() {
        for (int point = 0; point < n; point++) { //경유지
            for (int i = 0; i < n; i++) { //출발지
                for (int j = 0; j < n; j++) { //도착지
                    if(i == j || graph[i][point] == 0 || graph[point][j] == 0) continue; //경로가 없는 경우
                    if(graph[i][j] == 0) graph[i][j] = graph[i][point]+graph[point][j];
                    else graph[i][j] = Math.min(graph[i][j], graph[i][point]+graph[point][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int finish = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            if(graph[start][finish] == 0) graph[start][finish] = cost;
            else graph[start][finish] = graph[start][finish] = Math.min(graph[start][finish], cost); //한 경로에 버스가 여러 개인 경우 최소 비용 저장
        }

        floydWarshall();
    }
}
