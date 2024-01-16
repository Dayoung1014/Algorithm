import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[][] graph;
    static void floydWarsall() {
        for (int start = 0; start < V; start++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(graph[i][start] != Integer.MAX_VALUE && graph[start][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][start]+graph[start][j]); //최단 거리 갱신
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if(graph[i][i]==Integer.MAX_VALUE) continue;
            min = Math.min(min, graph[i][i]);
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
        for (int i = 0; i < V; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        
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