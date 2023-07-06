import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[1000*2+1];

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())+1000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = -1000; i <= 1000; i++) {
            if(arr[i+1000]) sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
