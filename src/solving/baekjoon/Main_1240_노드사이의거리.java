package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1240_노드사이의거리 {
    static class Node {
        int f, l;

        public Node(int f, int l) {
            this.f = f;
            this.l = l;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 거리 구할 노드 쌍의 수

        ArrayList<Node>[] tree = new ArrayList[N+1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            tree[s].add(new Node(e, l));
            tree[e].add(new Node(s, l));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            boolean[] v = new boolean[N+1];
            v[s] = true;
            for (Node next : tree[s]) {
                if(v[next.f]) continue;
                v[next.f] = true;
                q.add(new Node(next.f, next.l));
            }

            while (!q.isEmpty()) {
                Node now = q.poll();
                if(now.f == e) {
                    System.out.println(now.l);
                    break;
                }

                for (Node next : tree[now.f]) {
                    if(v[next.f]) continue;
                    v[next.f] = true;
                    q.add(new Node(next.f, now.l + next.l));
                }

            }
        }
    }
}
