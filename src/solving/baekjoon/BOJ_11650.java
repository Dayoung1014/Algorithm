import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cor = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cor[i][0] = Integer.parseInt(st.nextToken());
            cor[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cor, new corCompare());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(cor[i][0] + " "+ cor[i][1]+"\n");
        }
        System.out.println(sb);
    }

    static class corCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }
    }
}
