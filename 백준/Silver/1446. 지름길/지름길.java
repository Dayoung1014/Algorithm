import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, D;
    
    static class Route implements Comparable<Route>{
        int start, end, len;

        public Route(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Route o) {
            return this.start-o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //지름길 개수
        D = Integer.parseInt(st.nextToken()); //고속도로의 길이

        PriorityQueue<Route> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //지름길 시작 위치
            int e = Integer.parseInt(st.nextToken()); //지름길 도착 위치
            int l = Integer.parseInt(st.nextToken()); //지름길 길이
            q.add(new Route(s, e, l));
        }

        int now = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        //다익스트라
        while(now < D) {
            while(!q.isEmpty() && q.peek().start <= now) {
                Route r = q.poll(); //지름길 시작점이 현재 위치보다 작거나 같은 것 뽑아옴
                if(r.start == now) { //지름길 시작점이 현재 위치와 같다면
                    // dist[지름길 도착점] : 아래 중 작은 값 저장
                    // 현재에서 + 지름길 사용 길이
                    // 지름길 도착점에 저장된 값
                    dist[r.end] = Math.min(dist[now]+r.len, dist[r.end]);
                }
            }
            // dist[now+1] : 아래 중 작은 값 저장
            // dist[now+1] 위치에 저장되어 있는 값
            // 현재에서 그냥 1 이동한 값
            dist[now + 1] = Math.min(dist[now+1], dist[now]+1);
            now++; //현재 위치 1 이동
        }

        System.out.println(dist[D]);
    }


}