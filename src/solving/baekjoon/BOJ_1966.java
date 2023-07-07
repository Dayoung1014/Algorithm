import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //문서의 개수
            int M = Integer.parseInt(st.nextToken()); //궁금한 문서의 순서 (0~

            LinkedList<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                queue.add(new int[]{j, now}); //순서, 중요도
                pq.add(now);
            }

            int cnt=0;
            while(!queue.isEmpty()) {
                int[] now = queue.poll();
                if(now[1] ==pq.peek()) {
                    cnt++;
                    pq.poll();
                    if(now[0] == M) {
                        System.out.println(cnt);
                        break;
                    }
                }
                else {
                    queue.add(now);
                }
            }
        }
    }
}
