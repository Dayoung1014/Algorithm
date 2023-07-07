import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if(k==0) break;
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            combi(arr, new int[6], 0, 0);

            System.out.println(sb);
        }
    }

    static void combi(int[] arr, int[] sel, int idx, int cnt) {
        if(cnt == sel.length){
            for(int s : sel) {
                sb.append(s+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length ; i++) {
            sel[cnt] = arr[i];
            combi(arr, sel, i+1, cnt+1);
        }
    }
}
